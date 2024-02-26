import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;

import UserInterface.Form.SplashScreenForm;
import UserInterface.Form.LoginPanel;
import UserInterface.Form.MainForm;


public class App {
    public static void main(String[] args) throws Exception {

        QRgenerator qr = new QRgenerator();
        //qr.generarQR("https://static.wikia.nocookie.net/reinoanimalia/images/b/b5/Le%C3%B3n_wiki2.png/revision/latest?cb=20130303082204&path-prefix=es", "C:\\Users\\SnowPoom\\Desktop\\qr");
        FlatLightLaf.setup();
        FlatLightLaf.supportsNativeWindowDecorations();
        try{
            SplashScreenForm.show( ) ;
            LoginPanel loginPanel = new LoginPanel();
            loginPanel.iniciarSesion();
            UIManager.setLookAndFeel(new FlatAtomOneDarkIJTheme());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
}

