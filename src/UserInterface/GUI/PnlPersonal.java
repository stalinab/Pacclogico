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
import UserInterface.Form.SapoForm;

public class PnlPersonal extends JPanel implements ActionListener{
    private Integer idPersonal, idMaxPersonal;
    private PersonalBL  personalBL = null;
    private PersonalDTO personal   = null;

    public PnlPersonal() throws Exception{
        customerSizeControl();
        loadData();
        showData();
        showTable();
        
        
        /**
         * El fragmento de código `btnGuardar.addActionListener(new ActionListener() {... });` agrega
         * un ActionListener al botón `btnGuardar`. Cuando se hace clic en el botón `btnGuardar`, se
         * ejecutará el método `actionPerformed` dentro de ActionListener. En este caso, llama al
         * método `btnGuardarClick(e)`, que maneja la lógica para guardar o actualizar datos
         * relacionados con la entidad "Personal" en el panel GUI. Si ocurre una excepción durante la
         * ejecución de `btnGuardarClick(e)`, se detectará y los detalles de la excepción se imprimirán
         * en la consola usando `e1.printStackTrace()`.
         */
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {   try {
                btnGuardarClick(e);
            } catch (Exception e1) {
                e1.printStackTrace();
            }    }
        });

        
        /**
         * El código anterior agrega un ActionListener a un botón llamado `btnEliminar`. Cuando se hace
         * clic en el botón, se llama al método `actionPerformed`. Dentro de este método, intenta
         * llamar al método `btnEliminarClick` y detecta cualquier excepción que pueda ocurrir,
         * imprimiendo el seguimiento de la pila si se detecta una excepción.
         */
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
    
    /**
     * El método `loadData` inicializa variables relacionadas con datos personales recuperando
     * información de un objeto `PersonalBL`.
     */
    private void loadData() throws Exception {
        idPersonal      = 1;
        personalBL      = new PersonalBL();
        personal        = personalBL.getBy(idPersonal);
        idMaxPersonal   = personalBL.getMaxId();
    }

    /**
     * La función `showData` calcula la página actual y el total de páginas en función de las
     * identificaciones personales y actualiza una etiqueta con esta información.
     */
    private void showData() {
        int currentPage = (idPersonal - 1) / 10 + 1,
            totalPages  = (idMaxPersonal - 1) / 10 + 1;
        lblTotalReg.setText("Página " + currentPage + " de " + totalPages);
    }
   
    /**
     * Esta función de Java muestra un cuadro de diálogo de confirmación para eliminar un registro y
     * luego lo elimina si se confirma.
     * 
     * @param e El parámetro `e` en el método `btnEliminarClick` de tipo `ActionEvent` representa el
     * evento de acción que ocurrió, como un clic en un botón. Proporciona información sobre el evento,
     * como la fuente del evento y cualquier detalle adicional relacionado con el evento. En este caso,
     * el
     */
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
   
    /**
     * Esta función de Java maneja el evento de hacer clic en un botón "Guardar", solicitando al
     * usuario que confirme guardar los datos y luego agregar o actualizar un registro según la entrada
     * del usuario.
     * 
     * @param e El parámetro `e` en el método `btnGuardarClick` representa el `ActionEvent` que se
     * activa cuando se hace clic en el botón. Este evento contiene información sobre la acción que
     * ocurrió, como el origen del evento (en este caso, el botón en el que se hizo clic).
     */
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

    /**
     * La función muestra la tabla
     * @throws Exception
     */
    private void showTable() throws Exception {
        String[] header = {"Id", "Padre", "Nombre", "Estado"};
        Object[][] data = new Object[personalBL.getAll().size()][4];  
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

        /**
         * Este metodo  se encarga de mostrar los detalles de la seleccion de filas
         */
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
                        SapoForm oJirafaForm = new SapoForm();
                    }
                    
                }
            }
        });
        
        
    }

   /**
    * El método actionPerformed actualiza la variable idPersonal según el botón que desencadenó el
    * evento de acción.
    * 
    * @param e El parámetro `e` en el método `actionPerformed` de un `ActionListener` representa el
    * `ActionEvent` que ocurrió. Proporciona información sobre el evento que desencadenó la acción,
    * como el origen del evento (por ejemplo, un botón), cualquier modificador (por ejemplo, la tecla
    * Ctrl
    */
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

    /**
     * La función `customerSizeControl` configura un diseño con varios componentes, como botones,
     * etiquetas y campos de texto, organizados mediante GridBagLayout en una GUI de Java.
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