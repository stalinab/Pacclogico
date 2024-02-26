package UserInterface.Form;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import UserInterface.GUI.PnlPersonal;

public class MainForm extends JFrame implements ActionListener  {

    JPanel pnlMenu, pnlContainer;

    PnlPersonal pnlPanel1;

    CardLayout cardLayout;
 
    public MainForm(String titleApp) throws Exception {
        setTitle("Interfaz con Menú y Paneles");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 800);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menú");

        JMenuItem item1 = new JMenuItem("Panel Personal");

        item1.addActionListener(this);

        menu.add(item1);      

        menuBar.add(menu);
        setJMenuBar(menuBar);

        pnlPanel1 = new PnlPersonal();
        pnlPanel1.setBackground(new Color(56, 61, 72));

        cardLayout = new CardLayout();
        setLayout(cardLayout);

        add(pnlPanel1, "Panel Personal");

        isVisible();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Panel Personal")) {
            cardLayout.show(getContentPane(), "Panel Personal");
        }

    }
}