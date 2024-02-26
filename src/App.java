import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;

import UserInterface.Form.SplashScreenForm;
import UserInterface.Form.MainForm;

public class App {
    public static void main(String[] args) throws Exception {

        FlatLightLaf.setup();
        FlatLightLaf.supportsNativeWindowDecorations();
        try{
            SplashScreenForm.show( ) ;
            UIManager.setLookAndFeel(new FlatAtomOneDarkIJTheme());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        MainForm  mf = new MainForm("APP");
    }
}
