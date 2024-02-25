package UserInterface.Form;
import java.awt.BorderLayout;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public abstract class SplashScreenForm {
    private static JFrame       frmSplash;
    private static JProgressBar prbLoaging;
    private static ImageIcon    icoImagen ;
    private static JLabel       lblSplash ;
    /*
     * Metodo Principal para mostrar la ventana de carga del Splash
     */

    public static void show() {
        URL imageURL = SplashScreenForm.class.getResource("/UserInterface/Resource/Img/Pacclogico.jpeg");
        icoImagen  = new ImageIcon(imageURL);
        lblSplash  = new JLabel(icoImagen);
        
        prbLoaging = new JProgressBar(0, 100);
        prbLoaging.setStringPainted(true);
        
        frmSplash = new JFrame("Splash Screen");
        frmSplash.setUndecorated(true);
        frmSplash.getContentPane().add(lblSplash, BorderLayout.CENTER);
        frmSplash.add(prbLoaging, BorderLayout.SOUTH);
        frmSplash.setSize(icoImagen.getIconWidth(), icoImagen.getIconHeight());
        frmSplash.setLocationRelativeTo(null); 
       
        frmSplash.setVisible(true);
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(50); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            prbLoaging.setValue(i);
        }
        frmSplash.setVisible(false);
    }
}
