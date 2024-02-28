package UserInterface.Form;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SapoForm extends JFrame{
    /**
     * Este fragmento de código define un constructor para la clase `SapoForm`. Dentro del constructor:
     * 1. Crea un nuevo componente `JLabel` llamado `label`.
     * 2. Especifica la ruta del archivo de una imagen llamada "Sapo.jpeg" ubicada en el directorio
     * "../Pacclogico/src/UserInterface/Resource/Img/".
     * 3. Lee el archivo de imagen y lo convierte en un `ImageIcon` llamado `icon`.
     * 4. Recupera el objeto "Imagen" del "icono".
     * 5. Escala la imagen para que se ajuste al tamaño de 300x300 píxeles utilizando el método `getScaledInstance`.
     * dando como resultado una nueva "Imagen" llamada "Imagen escalada".
     * 6. Crea un nuevo `ImageIcon` llamado `scaledIcon` con la imagen escalada.
     * 7. Establece el `scaledIcon` como el icono de la `etiqueta`.
     * 8. Agrega la "etiqueta" al marco.
     * 9. Establece el tamaño del marco en 300x300 píxeles.
     * 10. Centra el marco en la pantalla.
     * 11. Hace que el marco sea visible para el usuario.
     */
    public SapoForm(){
        JLabel label = new JLabel();
        String imagePath = "../Pacclogico/src/UserInterface/Resource/Img/Sapo.jpeg"; 
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
