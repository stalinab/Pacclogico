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
import UserInterface.Form.CapibaraForm;
import UserInterface.Form.CondorForm;
import UserInterface.Form.GorilaForm;
import UserInterface.Form.HipopotamoForm;
import UserInterface.Form.LeonForm;
import UserInterface.Form.PatoAmericanoForm;
import UserInterface.Form.SapoForm;
import UserInterface.Form.SerpienteForm;
import UserInterface.Form.TigreForm;
import UserInterface.Form.TortugaForm;

public class PnlAnimal extends JPanel implements ActionListener{
    private Integer idAnimal, idMaxAnimal;
    private AnimalBL  animalBL = null;
    private AnimalDTO animal   = null;

    /**
     * El constructor `public PnlAnimal() throws Exception` en la clase `PnlAnimal` es responsable de inicializar una nueva instancia del panel `PnlAnimal`. 
     * Aquí hay un desglose de lo que hace:
     * @throws Exception
     */
    public PnlAnimal() throws Exception{
        customerSizeControl();
        loadData();
        showData();
        showTable();
    }
    
    
    /**
     * El método `loadData` inicializa variables relacionadas con un objeto animal recuperando datos de
     * una base de datos usando una clase de lógica de negocios `AnimalBL`.
     * @throws Exception
     */
    private void loadData() throws Exception {
        idAnimal      = 1;
        animalBL      = new AnimalBL();
        animal        = animalBL.getBy(idAnimal);
        idMaxAnimal   = animalBL.getMaxId();
    }

    /**
     * La función `showData` calcula la página actual y el total de páginas en función de las
     * identificaciones de los animales y actualiza una etiqueta con esta información.
     */
    private void showData() {
        int currentPage = (idAnimal - 1) / 10 + 1,
            totalPages  = (idMaxAnimal - 1) / 10 + 1;
        lblTotalReg.setText("Página " + currentPage + " de " + totalPages);
    }


    /**
     * La función muestra la tabla
     * @throws Exception
     */
    private void showTable() throws Exception {
        String[] header = {"Id", "Sexo", "Habitat", "Clasificacion", "Nombre"};
        Object[][] data = new Object[animalBL.getAll().size()][6];  
        int index = 0;
     
        /**
         * Este bucle `for` itera sobre una lista de objetos `AnimalDTO` obtenidos de
         * `animalBL.getAll()`. Para cada objeto `AnimalDTO` `pr` en la lista, realiza las siguientes
         * acciones:
         * 1. Crea instancias de `ClasificacionBL` y `HabitatBL`.
         * 2. Recupera información específica del objeto `pr` como `idAnimal`, `sexo`, `habitat`,
         * `clasificacion` y `nombre`.
         * 3. Convierte el valor `sexo` en una representación de cadena "Macho" si es igual a 1, en
         * caso contrario "Hembra".
         * 4. Recupera el nombre del hábitat y la clasificación usando las instancias `HabitatBL` y
         * `ClasificacionBL` respectivamente.
         * 5. Rellena la matriz "datos" con la información extraída en el índice correspondiente.
         * 6. Incrementa la variable `index` para pasar a la siguiente fila en la matriz `data`.
         */
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

        /**
         * Este metodo  se encarga de mostrar los detalles de la seleccion de filas
         */
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
                        LeonForm oLeonForm = new LeonForm();
                    }
                    if(Integer.parseInt(strIdAnimal) == 2){
                        SapoForm oSapoForm = new SapoForm();
                    }
                    if(Integer.parseInt(strIdAnimal) == 3){
                        TigreForm oTigreForm = new TigreForm();
                    }
                    if(Integer.parseInt(strIdAnimal) == 4){
                        GorilaForm oGorilaForm = new GorilaForm();
                    }
                    if(Integer.parseInt(strIdAnimal) == 5){
                        HipopotamoForm oHipopotamoForm = new HipopotamoForm();
                    }
                    if(Integer.parseInt(strIdAnimal) == 6){
                        SerpienteForm oSerpienteForm = new SerpienteForm();
                    }
                    if(Integer.parseInt(strIdAnimal) == 7){
                        CondorForm oCondorForm = new CondorForm();
                    }
                    if(Integer.parseInt(strIdAnimal) == 8){
                        PatoAmericanoForm oPatoAmericanoForm = new PatoAmericanoForm();
                    }
                    if(Integer.parseInt(strIdAnimal) == 9){
                        CapibaraForm oCapibaraForm = new CapibaraForm();
                    }
                    if(Integer.parseInt(strIdAnimal) == 10){
                        TortugaForm oTortugaForm = new TortugaForm();
                    }
                }
            }
        });
        
        
    }

    /**
     * Esta función maneja las acciones de los botones para actualizar la variable idAnimal en función
     * de los clics en los botones.
     * 
     * @param e El parámetro `e` en el método `actionPerformed` es un objeto `ActionEvent`. Este objeto
     * representa la acción que ocurrió, como hacer clic en un botón o seleccionar un menú, y
     * proporciona información sobre el evento, como el origen del evento.
     */
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

    /**
     * La función `customerSizeControl` configura un diseño con componentes para mostrar datos y
     * controles de paginación en una GUI de Java.
     */
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