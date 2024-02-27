package UserInterface.Form;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TortugaForm extends JFrame{
    public TortugaForm(){
        JLabel label = new JLabel();
        String imagePath = "../Pacclogico/src/UserInterface/Resource/Img/Tortuga.png"; 
        // Lee la imagen desde el archivo y la convierte en un ImageIcon
        ImageIcon icon = new ImageIcon(imagePath);
        // Obtiene la imagen del ImageIcon
        Image image = icon.getImage();
        // Escala la imagen para ajustarse al tamaño de la etiqueta
        Image scaledImage = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        // Crea un nuevo ImageIcon con la imagen escalada
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        // Establece el ImageIcon escalado como icono de la etiqueta
        label.setIcon(scaledIcon);
        add(label);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);    
    }
    public static void main(String[] args) {
        
    }
}

