/*
|-------------------------------------|
| © 2024 EPN-FIS, All rights reserved |
| kevin.calles@epn.edu.ec             |
|-------------------------------------|
Autor: Kevin Calles
Fecha: 25 - 02 - 2024
Script: PatButton
*/

package UserInterface.CustomerControl;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class PatButton  extends JButton implements MouseListener {
    Font font = new Font ("MesloLGL Nerd Font", Font.CENTER_BASELINE | Font.LAYOUT_LEFT_TO_RIGHT, 12);
    // El constructor `public PatButton(String label)` en la clase `PatButton` está inicializando una
    // nueva instancia de la clase `PatButton` con el texto `label` proporcionado. Luego llama al
    // método `goStyleLabel()` para aplicar un estilo específico al botón, configurando su apariencia y
    // comportamiento de acuerdo con las especificaciones de diseño definidas.
    public PatButton(String label){
        super(label);
        goStyleLabel();
    }
    // El constructor `public PatButton(String label, String iconPath)` en la clase `PatButton` está
    // inicializando una nueva instancia de la clase `PatButton` con una etiqueta de texto y una ruta
    // de icono proporcionadas como parámetros. Luego llama al método `goStyleMenu(label, iconPath)`
    // para aplicar un estilo específico al botón, configurando su apariencia y comportamiento de
    // acuerdo con las especificaciones de diseño definidas. Este constructor permite crear un botón
    // con texto y un icono que se muestra en él.
    public PatButton(String label, String iconPath){
        goStyleMenu(label, iconPath);
    }

    /**
     * La función `goStyleMenu` configura un elemento de menú con una etiqueta, un icono y propiedades
     * de estilo específicos.
     * 
     * @param label El parámetro `label` en el método `goStyleMenu` es una cadena que representa el
     * texto o etiqueta que se mostrará en el elemento del menú. Es el texto visible que el usuario
     * verá en el elemento del menú.
     * @param iconPath El parámetro `iconPath` en el método `goStyleMenu` es una cadena que representa
     * la ruta del archivo a la imagen del icono que se mostrará en el elemento del menú. Esta ruta
     * debe apuntar a la ubicación del archivo de imagen del icono en el sistema.
     */
    public void goStyleMenu(String label, String iconPath){ 
        addMouseListener(this);
        setText(label);
        setSize(20, 70);
        setBounds(50, 30, 90, 20); 
        
        setOpaque(false);
        setForeground(Color.GRAY);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setIcon(new ImageIcon(iconPath));
        setHorizontalAlignment(SwingConstants.LEFT);
        setFont(font);
    }
    /**
     * La función `goStyleLabel` establece varias propiedades visuales para que un componente de
     * etiqueta Java cree una apariencia de estilo "go" personalizada.
     */
    public void goStyleLabel() {
        setOpaque(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setForeground(Color.white);
        setHorizontalAlignment(SwingConstants.CENTER);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setFont(font);
    }

    /**
     * La función anterior es un método anulado que maneja eventos de clic del mouse en Java.
     * 
     * @param e El parámetro "e" en el método mouseClicked representa el objeto MouseEvent que contiene
     * información sobre el evento del mouse, como la ubicación del clic del mouse, el tipo de botón
     * del mouse en el que se hizo clic y las teclas modificadoras que se presionaron durante el clic.
     * Puede utilizar este objeto MouseEvent para recuperar información sobre el mouse.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    /**
     * La función anterior es un método anulado que maneja eventos de pulsación del mouse en Java.
     * 
     * @param e El parámetro "e" en el método "mousePressed" representa el objeto MouseEvent que
     * contiene información sobre el evento del mouse, como la ubicación del cursor del mouse, el tipo
     * de evento del mouse (por ejemplo, presionado, liberado, hecho clic) y cualquier modificador.
     * teclas que se presionaron (por ejemplo, Shift
     */
    @Override
    public void mousePressed(MouseEvent e) {
    }

    /**
     * La función `mouseReleased` es un método anulado que se llama cuando se suelta el botón del
     * mouse.
     * 
     * @param e El parámetro "e" en el método "mouseReleased" de la clase MouseEvent representa el
     * objeto MouseEvent que contiene información sobre el evento del mouse que ocurrió, como las
     * coordenadas del mouse, el botón en el que se hizo clic y las teclas modificadoras presionadas.
     * Puede utilizar este objeto para recuperar información sobre el evento del mouse que desencadenó
     * el método.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
    }

    /**
     * La función `mouseEntered` cambia el color de primer plano a negro y establece el cursor en un
     * cursor de mano cuando el mouse ingresa a un componente.
     * 
     * @param e En el método `mouseEntered`, el parámetro `e` de tipo `MouseEvent` representa el evento
     * que ocurrió cuando el mouse ingresó al componente. Este objeto de evento contiene información
     * sobre el evento del mouse, como el componente de origen, la ubicación del mouse y otros detalles
     * relevantes. Puedes usar esto
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        setForeground(Color.BLACK);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    /**
     * La función `mouseExited` cambia el color de primer plano a gris y establece el cursor en el
     * cursor predeterminado cuando el mouse sale del componente.
     * 
     * @param e En el método `mouseExited`, el parámetro `e` de tipo `MouseEvent` representa el evento
     * que ocurrió cuando el mouse salió del componente. Este objeto de evento contiene información
     * sobre la interacción del mouse, como el componente de origen, las coordenadas y los
     * modificadores. Puede utilizar este objeto `MouseEvent` para
     */
    @Override
    public void mouseExited(MouseEvent e) {
        setForeground(Color.GRAY);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
}