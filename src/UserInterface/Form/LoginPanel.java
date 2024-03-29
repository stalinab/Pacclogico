/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| angeltomasbq@gmail.com   AngelTBarahona|
|----------------------------------------|
Autor : AngelTBarahona 
Fecha : 27.feb.2k24
src: Creacion del Login
*/
package UserInterface.Form;
import javax.swing.*;

import BusinessLogic.CuentaBL;
import DataAccessComponent.DTO.CuentaDTO;
import java.util.List;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {

    private JTextField      usernameField;
    private JPasswordField  passwordField;
    private JButton         loginButton;
    private CuentaBL        cuentaBL;
    private CuentaDTO       cuentaDTO;

    public LoginPanel(CuentaBL cuentaBL) {
        this.cuentaBL = new CuentaBL();
        initializeComponents();
        setupLayout();
        setupActions();
    }

    private void initializeComponents() {
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        Font customFont = new Font("Arial", Font.PLAIN, 20);  
        usernameField.setFont(customFont);
        passwordField.setFont(customFont);
        loginButton.setFont(customFont);
        setBackground(new Color(56, 61, 72));
        setForeground(Color.WHITE);
        usernameField.setBackground(new Color(80, 87, 100));
        passwordField.setBackground(new Color(80, 87, 100));
        loginButton.setBackground(new Color(41, 128, 185));
        loginButton.setForeground(Color.WHITE);
        usernameField.setColumns(15);
        passwordField.setColumns(15);
        loginButton.setPreferredSize(new Dimension(100, 40));
    }
    /**
     * Metodo  que se encarga de organizar los componentes en el panel
     */
    private void setupLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(new JLabel("Username:"), gbc);
        gbc.gridy++;
        add(usernameField, gbc);
        gbc.gridy++;
        add(new JLabel("Password:"), gbc);
        gbc.gridy++;
        add(passwordField, gbc);
        gbc.gridy++;
        add(loginButton, gbc);
    }
    /**
     * Metodo que se encarga de las acciones de autenticacion
     */
    private void setupActions() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredUsername = usernameField.getText();
                char[] enteredPassword = passwordField.getPassword();
                boolean isAuthenticated = authenticateUser(enteredUsername, new String(enteredPassword));
                if (isAuthenticated) {
                    JOptionPane.showMessageDialog(LoginPanel.this, "Login Exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    usernameField.setText("");
                    passwordField.setText("");
                    try {
                        transicionDespuesDeLogin();
                        
                    } catch (Exception e1) {
                        // TODO: handle exception
                    }
                } else {
                    JOptionPane.showMessageDialog(LoginPanel.this, "Autenticación fallida", "Error", JOptionPane.ERROR_MESSAGE);
                    usernameField.setText("");
                    passwordField.setText("");
                }
            }
        });
    }
    /**
     * Metodo que se encarga de transcicionar
     */
    private void transicionDespuesDeLogin() throws Exception{
        SwingUtilities.getWindowAncestor(this).dispose();
        MainForm mf = new MainForm("APP", cuentaDTO);

    } 
    /**
     * @param username
     * @param password
     * @return
     *  Metodo  que se encarga de validar si el usuario y la contraseña son correctos o no desde el BL
     */
    private boolean authenticateUser(String username, String password) {
        boolean isAuthenticated = false;
        try {
            List<CuentaDTO> cuentas = cuentaBL.getAll();
            for (CuentaDTO cuenta : cuentas) {
                if (cuenta.getCorreo().equals(username) && cuenta.getPassword().equals(password)) {
                    isAuthenticated = true;
                    cuentaDTO = new CuentaDTO();
                    cuentaDTO.setIdPersonal(cuenta.getIdPersonal());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return isAuthenticated;
    }
    /**
     * Método para iniciar la sesión y mostrar el panel de inicio de sesión en una ventana.
     */
    public void iniciarSesion() {
        JFrame frame = new JFrame("Inicio de Sesión");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
