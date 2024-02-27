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
        //qr.generarQR("https://drive.google.com/uc?export=download&id=1w8_hEWWeN2FVCKXLRTdM6RespVCnChIc", "C:\\Users\\kevin\\OneDrive\\Escritorio\\Tortuga.png");
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

