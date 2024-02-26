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

import BusinessLogic.PersonalBL;
import DataAccessComponent.DTO.PersonalDTO;
import UserInterface.CustomerControl.PatButton;
import UserInterface.CustomerControl.PatLabel;
import UserInterface.CustomerControl.PatTextBox;
import UserInterface.Form.JirafaForm;

public class PnlPersonal extends JPanel implements ActionListener{
    private Integer idPersonal, idMaxPersonal;
    private PersonalBL  personalBL = null;
    private PersonalDTO personal   = null;

    public PnlPersonal() throws Exception{
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
    }
    
    private void loadData() throws Exception {
        idPersonal      = 1;
        personalBL      = new PersonalBL();
        personal        = personalBL.getBy(idPersonal);
        idMaxPersonal   = personalBL.getMaxId();
    }

    private void showData() {
        int currentPage = (idPersonal - 1) / 10 + 1,
            totalPages  = (idMaxPersonal - 1) / 10 + 1;
        lblTotalReg.setText("Página " + currentPage + " de " + totalPages);
    }
   
    private void btnEliminarClick(ActionEvent e) throws Exception {
        if (JOptionPane.showConfirmDialog(this, "¿Está seguro que desea Eliminar?", "Eliminar...",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
               
            if(!personalBL.delete(personal.getIdPersonal()))
                JOptionPane.showMessageDialog(this, "Error al eliminar...!",
                                        "ERROR", JOptionPane.OK_OPTION);

            loadData();
            showData();
            showTable();
        }
    }
   
    private void btnGuardarClick(ActionEvent e) throws HeadlessException, Exception {
        boolean personalNull = (personal == null);
        if (JOptionPane.showConfirmDialog(this, "¿Seguro que desea guardar?", (personalNull)?"Agregar...": "Actualizar...", 
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            
            try {
                if (personalNull)
                    personal = new PersonalDTO();
                    
                if (txtIdPersonal_Padre.getText().trim().isEmpty() 
                || txtNombre.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No deje registros en blanco",
                    "ERROR", JOptionPane.OK_OPTION);
                    return;
                }
                    
                // Actualizar personal antes de guardarlo
                personal.setIdPersonal_Padre(Integer.parseInt(txtIdPersonal_Padre.getText().trim()));
                personal.setNombre(txtNombre.getText().trim());

                if (!personalBL.add(personal)) {
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
        String[] header = {"Id", "Padre", "Nombre", "Estado"};
        Object[][] data = new Object[personalBL.getAll().size()][4];  
        int index = 0;
        for(PersonalDTO pr : personalBL.getAll()) {
            data[index][0] = pr.getIdPersonal();
            data[index][1] = (pr.getIdPersonal_Padre() != 0) 
                            ? personalBL.getBy(pr.getIdPersonal_Padre()).getNombre()
                            : "N/A";
            data[index][2] = pr.getNombre();
            data[index][3] = pr.getEstado();
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

        
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && !table.getSelectionModel().isSelectionEmpty()) {
                    int col = 0;
                    int row = table.getSelectedRow();
                    String strIdPersonal = table.getModel().getValueAt(row, col).toString();
        
                    idPersonal = Integer.parseInt(strIdPersonal);
                    try {
                        personal = personalBL.getBy(idPersonal);
                        showData();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    System.out.println("Tabla.Selected: " + strIdPersonal);
                    if(Integer.parseInt(strIdPersonal) == 1){
                        JirafaForm oJirafaForm = new JirafaForm();
                    }
                    
                }
            }
        });
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnIni)
            idPersonal  = 1;
        if(e.getSource() == btnAnt  &&  (idPersonal>1) )
            idPersonal--;
        if(e.getSource() == btnSig  &&  (idPersonal<idMaxPersonal))
            idPersonal++;
        if(e.getSource() == btnFin)
            idPersonal = idMaxPersonal;
    }

/********************************
 * FormDesing : Kevin Calles
 ********************************/ 

    private PatLabel 
            lblTitulo               = new PatLabel("PERSONA ROL"    ),
            lblIdPersonal_Padre   = new PatLabel("IdPersonal_Padre: "),
            lblNombre               = new PatLabel("Nombre: "),
            lblTotalReg             = new PatLabel("  0 de 0  ");
    private PatTextBox  
            txtIdPersonal_Padre  = new PatTextBox (),
            txtNombre              = new PatTextBox ();
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

        // IdPersonal_Padre
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        add(lblIdPersonal_Padre, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add(txtIdPersonal_Padre, gbc);

        // Nombre
        gbc.gridy = 6;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(lblNombre, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add(txtNombre, gbc);

        // Sección de botones CRUD
        gbc.gridy = 7;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(30, 0, 0, 0);
        add(pnlBtnCRUD, gbc);

    }

}