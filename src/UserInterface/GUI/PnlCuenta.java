/*
|-------------------------------------|
| © 2024 EPN-FIS, All rights reserved |
| kevin.calles@epn.edu.ec             |
|-------------------------------------|
Autor: Kevin Calles
Fecha: 23 - 02 - 2024
Script: Panel de presentación de datos y CRUD para Personal
*/

package UserInterface.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import BusinessLogic.CuentaBL;
import BusinessLogic.PersonalBL;
import DataAccessComponent.DTO.CuentaDTO;
import UserInterface.CustomerControl.PatButton;
import UserInterface.CustomerControl.PatLabel;
import UserInterface.CustomerControl.PatTextBox;
import UserInterface.Form.SapoForm;

public class PnlCuenta extends JPanel implements ActionListener{
    private Integer idCuenta, idMaxCuenta, nroPag=1, totalPag;
    private CuentaBL  cuentaBL = null;
    private CuentaDTO cuenta   = null;

    public PnlCuenta() throws Exception{
        customerSizeControl();
        loadData();
        showData();
        showTable();
        
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {   try {
                btnGuardarClick(e);
            } catch (Exception e1) {
                e1.printStackTrace();
            }    }
        });

        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {   try {
                    btnEliminarClick(e);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }   
            }
        });
        btnIni.addActionListener(this);
        btnAnt.addActionListener(this);
        btnSig.addActionListener(this);
        btnFin.addActionListener(this);
    }
    
    private void loadData() throws Exception {
        idCuenta      = 1;
        cuentaBL      = new CuentaBL();
        cuenta        = cuentaBL.getBy(idCuenta);
        idMaxCuenta   = cuentaBL.getMaxId();
    }

    private void showData() {
        totalPag  = (idMaxCuenta - 1) / 10 + 1;
        lblTotalReg.setText("Página " + nroPag + " de " + totalPag);
    }
   
    private void btnEliminarClick(ActionEvent e) throws Exception {
        if (JOptionPane.showConfirmDialog(this, "¿Está seguro que desea Eliminar?", "Eliminar...",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
               
            if(!cuentaBL.delete(cuenta.getIdCuenta()))
                JOptionPane.showMessageDialog(this, "Error al eliminar...!",
                                        "ERROR", JOptionPane.OK_OPTION);

            loadData();
            showData();
            showTable();
        }
    }
   
    private void btnGuardarClick(ActionEvent e) throws HeadlessException, Exception {
        boolean cuentaNull = (cuenta == null);
        if (JOptionPane.showConfirmDialog(this, "¿Seguro que desea guardar?", (cuentaNull)?"Agregar...": "Actualizar...", 
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            
            try {
                if (cuentaNull)
                    cuenta = new CuentaDTO();
                    
                if (txtIdPersonal.getText().trim().isEmpty() 
                || txtCorreo.getText().trim().isEmpty()
                || txtContrasena.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No deje registros en blanco",
                    "ERROR", JOptionPane.OK_OPTION);
                    return;
                }
                    
                // Actualizar personal antes de guardarlo
                cuenta.setIdPersonal(Integer.parseInt(txtIdPersonal.getText().trim()));
                cuenta.setCorreo(txtCorreo.getText().trim());
                cuenta.setPassword(txtContrasena.getText().trim());

                if (!cuentaBL.add(cuenta)) {
                    JOptionPane.showMessageDialog(this, "Error al guardar...!",
                                            "ERROR", JOptionPane.OK_OPTION);
                    return;
                }
            } catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese un número válido para el ID",
                                        "ERROR", JOptionPane.OK_OPTION);
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(this, "El registro se encuentra duplicado",
                                        "ERROR", JOptionPane.OK_OPTION);
            } 
            loadData();
            showData();
            showTable();
        }
    }

    private void showTable() throws Exception {
        int tamanoPagina = 10,
            startIndex = ((nroPag - 1) * tamanoPagina) + 1,
            endIndex = startIndex + 9;

        String[] header = {"Id", "IdPersonal", "Correo", "Contraseña", "Estado"};
        Object[][] data = new Object[endIndex - startIndex + 1][5];  
        int index = 0;
        for(int i = startIndex; i <= endIndex; i++) {
            PersonalBL oPersonalBL = new PersonalBL();
            CuentaDTO oCuentaDTO = cuentaBL.getBy(i);
            data[index][0] = oCuentaDTO.getIdCuenta() == 0 ? "": oCuentaDTO.getIdCuenta();
            data[index][1] = (oCuentaDTO.getIdPersonal() != 0) 
                            ? oPersonalBL.getBy(oCuentaDTO.getIdPersonal()).getNombre()
                            : "";
            data[index][2] = oCuentaDTO.getCorreo();
            data[index][3] = oCuentaDTO.getPassword();
            data[index][4] = oCuentaDTO.getEstado();
            index++;
        }

        JTable table  = new JTable(data, header);
        table.setShowHorizontalLines(true);
        table.setGridColor(Color.lightGray);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);

        table.setPreferredScrollableViewportSize(new Dimension(470, 150));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);

        pnlTabla.removeAll();
        pnlTabla.add(scrollPane);
        pnlTabla.revalidate();
        pnlTabla.repaint();

        
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int col = 0;
                int row = table.getSelectedRow();
                String strIdCuenta = table.getModel().getValueAt(row, col).toString();

                idCuenta = Integer.parseInt(strIdCuenta);
                try {
                    cuenta = cuentaBL.getBy(idCuenta);
                    showData(); 
                } catch (Exception e1) { }  
                System.out.println("Tabla.Selected: " + strIdCuenta);
            }
        });
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnIni)
            nroPag = 1;
        if(e.getSource() == btnAnt  &&  (nroPag > 1) )
            nroPag--;
        if(e.getSource() == btnSig  &&  (nroPag < totalPag))
            nroPag++;
        if(e.getSource() == btnFin)
            nroPag = totalPag;

        try {
            loadData();
            showData();
            showTable();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

/********************************
 * FormDesing : Kevin Calles
 ********************************/ 

    private PatLabel 
            lblTitulo       = new PatLabel("CUENTAS"    ),
            lblIdPersonal   = new PatLabel("IdPersonal: "),
            lblCorreo       = new PatLabel("Correo: "),
            lblContrasena   = new PatLabel("Contraseña: "),
            lblTotalReg     = new PatLabel("  0 de 0  ");
    private PatTextBox  
            txtIdPersonal  = new PatTextBox (),
            txtCorreo      = new PatTextBox (),
            txtContrasena  = new PatTextBox ();
    private PatButton  
            btnIni     = new PatButton(" |< "),
            btnAnt     = new PatButton(" << "),           
            btnSig     = new PatButton(" >> "),
            btnFin     = new PatButton(" >| ");
    private PatButton
            btnGuardar = new PatButton("Guardar"),
            btnEliminar= new PatButton("Eliminar");
    private JPanel 
            pnlTabla   = new JPanel(),
            pnlBtnCRUD = new JPanel(new FlowLayout()),
            pnlBtnPage = new JPanel(new FlowLayout());
    private Border  
            line       = new LineBorder(Color.lightGray),
            margin     = new EmptyBorder(5, 5, 5, 5),
            border     = new CompoundBorder(line, margin);
    
/************************
 * Customize : Form
 ************************/ 

    public void customerSizeControl() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Panel.Paginacion.Tabla
        pnlBtnPage.add(btnIni);       
        pnlBtnPage.add(btnAnt);  
        pnlBtnPage.add(lblTotalReg);        
        pnlBtnPage.add(btnSig);
        pnlBtnPage.add(btnFin);

        // Panel.CRUD
        pnlBtnCRUD.add(btnGuardar);
        pnlBtnCRUD.add(btnEliminar);
        pnlBtnCRUD.setBorder(border);

        // Restricciones generales
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Titulo
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        add(lblTitulo, gbc);

        // Separador
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(new JLabel("■ Sección de datos: "), gbc);

        // Sección de datos (Tabla)
        gbc.gridy = 2;
        gbc.weighty = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        add(pnlTabla, gbc);

        // Sección de paginación
        gbc.gridy = 3;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(pnlBtnPage, gbc);

        // Separador
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        add(new JLabel("■ Sección de registro: "), gbc);

        // IdPersonal
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        add(lblIdPersonal, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add(txtIdPersonal, gbc);

        // Correo
        gbc.gridy = 6;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(lblCorreo, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add(txtCorreo, gbc);

        // Contraseña
        gbc.gridy = 7;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(lblContrasena, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add(txtContrasena, gbc);

        // Sección de botones CRUD
        gbc.gridy = 8;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(30, 0, 0, 0);
        add(pnlBtnCRUD, gbc);

    }

}