/*
|-------------------------------------|
| © 2024 EPN-FIS, All rights reserved |
| kevin.calles@epn.edu.ec             |
|-------------------------------------|
Autor: Kevin Calles
Fecha: 26 - 02 - 2024
Script: Panel de presentación de datos y CRUD para Animal
*/

package UserInterface.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import BusinessLogic.AnimalBL;
import BusinessLogic.ClasificacionBL;
import BusinessLogic.HabitatBL;
import DataAccessComponent.DTO.AnimalDTO;
import DataAccessComponent.DTO.HabitatDTO;
import UserInterface.CustomerControl.PatButton;
import UserInterface.CustomerControl.PatLabel;
import UserInterface.Form.JirafaForm;

public class PnlAnimal extends JPanel implements ActionListener{
    private Integer idAnimal, idMaxAnimal;
    private AnimalBL  animalBL = null;
    private AnimalDTO animal   = null;

    public PnlAnimal() throws Exception{
        customerSizeControl();
        loadData();
        showData();
        showTable();
    }
    
    private void loadData() throws Exception {
        idAnimal      = 1;
        animalBL      = new AnimalBL();
        animal        = animalBL.getBy(idAnimal);
        idMaxAnimal   = animalBL.getMaxId();
    }

    private void showData() {
        int currentPage = (idAnimal - 1) / 10 + 1,
            totalPages  = (idMaxAnimal - 1) / 10 + 1;
        lblTotalReg.setText("Página " + currentPage + " de " + totalPages);
    }

    private void showTable() throws Exception {
        String[] header = {"Id", "Sexo", "Habitat", "Clasificacion", "Nombre"};
        Object[][] data = new Object[animalBL.getAll().size()][6];  
        int index = 0;
        for(AnimalDTO pr : animalBL.getAll()) {
            ClasificacionBL cBl = new ClasificacionBL();
            HabitatBL hBl = new HabitatBL();
            data[index][0] = pr.getIdAnimal();
            data[index][1] = Integer.parseInt(pr.getSexo()) == 1 ? "Macho":"Hembra";
            data[index][2] = hBl.getBy(Integer.parseInt(pr.getHabitat())).getNombre();
            data[index][3] = cBl.getBy(Integer.parseInt(pr.getClasificacion())).getNombre();
            data[index][4] = pr.getNombre();
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
                    String strIdAnimal = table.getModel().getValueAt(row, col).toString();
        
                    idAnimal = Integer.parseInt(strIdAnimal);
                    try {
                        animal = animalBL.getBy(idAnimal);
                        showData();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    System.out.println("Tabla.Selected: " + strIdAnimal);
                    if(Integer.parseInt(strIdAnimal) == 1){
                        JirafaForm oJirafaForm = new JirafaForm();
                    }
                    
                }
            }
        });
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnIni)
            idAnimal  = 1;
        if(e.getSource() == btnAnt  &&  (idAnimal>1) )
            idAnimal--;
        if(e.getSource() == btnSig  &&  (idAnimal<idMaxAnimal))
            idAnimal++;
        if(e.getSource() == btnFin)
            idAnimal = idMaxAnimal;
    }

/********************************
 * FormDesing : Kevin Calles
 ********************************/ 

    private PatLabel 
            lblTitulo               = new PatLabel("ANIMAL"    ),
            lblTotalReg             = new PatLabel("  0 de 0  ");
    private PatButton  
            btnIni     = new PatButton(" |< "),
            btnAnt     = new PatButton(" << "),           
            btnSig     = new PatButton(" >> "),
            btnFin     = new PatButton(" >| ");
    private JPanel 
            pnlTabla   = new JPanel(),
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

    }

}