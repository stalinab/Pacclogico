package UserInterface.Form;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import BusinessLogic.CuentaBL;
import DataAccessComponent.DTO.CuentaDTO;
import UserInterface.GUI.PnlAnimal;
import UserInterface.GUI.PnlCuenta;
import UserInterface.GUI.PnlPersonal;

public class MainForm extends JFrame implements ActionListener  {

    CuentaDTO  cuentaDTO = new CuentaDTO();

    JPanel pnlMenu, pnlContainer;

    PnlPersonal pnlPanel1;
    PnlAnimal pnlPanel2;
    PnlCuenta pnlPanel3;
    LoginPanel pLoginPanel;

    CardLayout cardLayout;
 
    /**
     * Este constructor `MainForm` es responsable de configurar el marco principal de la aplicación con una barra de menú y paneles para diferentes funcionalidades. 
     * @param titleApp
     * @param cuentaDTO
     * @throws Exception
     */
    public MainForm(String titleApp, CuentaDTO cuentaDTO) throws Exception {
        this.cuentaDTO = cuentaDTO;
        setTitle("Interfaz con Menú y Paneles");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 800);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menú");

        JMenuItem item1 = new JMenuItem("Panel Personal");
        JMenuItem item2 = new JMenuItem("Panel Animal");
        JMenuItem item3 = new JMenuItem("Panel Cuenta");
        JMenuItem item4 = new JMenuItem("Cerrar Sesion");

        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        item4.addActionListener(this);

        menu.add(item2);   
        menu.add(item1);   
        menu.add(item3); 
        menu.add(item4);

        menuBar.add(menu);
        setJMenuBar(menuBar);

        pnlPanel1 = new PnlPersonal();
        pnlPanel1.setBackground(new Color(56, 61, 72));
        pnlPanel2 = new PnlAnimal();
        pnlPanel2.setBackground(new Color(56, 61, 72));
        pnlPanel3 = new PnlCuenta();
        pnlPanel3.setBackground(new Color(56, 61, 72));
        
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        add(pnlPanel2, "Panel Animal");
        add(pnlPanel1, "Panel Personal");
        add(pnlPanel3, "Panel Cuenta");

        isVisible();
        setLocationRelativeTo(null);
        setVisible(true);
    }

   /**
    * Este método `actionPerformed` es una implementación de la interfaz `ActionListener` en Java Swing.
    * Se utiliza para manejar acciones realizadas por el usuario en los elementos del menú en la clase `MainForm`.
    */
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Panel Personal")) {
            if(cuentaDTO.getIdPersonal()!=3){
                cardLayout.show(getContentPane(), "Panel Personal");
            }else{
                JOptionPane.showMessageDialog(MainForm.this, "Usted no tiene permiso para ver esto", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getActionCommand().equals("Panel Animal")) {
            cardLayout.show(getContentPane(), "Panel Animal");
        }
        if (e.getActionCommand().equals("Panel Cuenta")) {
            if(cuentaDTO.getIdPersonal()!=3){
                cardLayout.show(getContentPane(), "Panel Cuenta");
            }else{
                JOptionPane.showMessageDialog(MainForm.this, "Usted no tiene permiso para ver esto", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getActionCommand().equals("Cerrar Sesion")) {
            dispose();
            pLoginPanel = new LoginPanel(null);
            pLoginPanel.iniciarSesion();
        }

    }
}
