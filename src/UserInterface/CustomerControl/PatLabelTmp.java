/*
|-------------------------------------|
| © 2024 EPN-FIS, All rights reserved |
| kevin.calles@epn.edu.ec             |
|-------------------------------------|
Autor: Kevin Calles
Fecha: 25 - 02 - 2024
Script: PatLabelTmp
*/

package UserInterface.CustomerControl;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PatLabelTmp extends JLabel implements MouseListener {

    // El constructor `PatLabelTmp(String label)` en la clase `PatLabelTmp` está inicializando una
    // nueva instancia de la clase `PatLabelTmp` con el texto `label` especificado. Llama al
    // constructor de la superclase `JLabel` con el texto `label` proporcionado usando `super(label)`,
    // que establece el texto de la etiqueta. Además, luego llama al método `setPersonalizacion()` para
    // aplicar un estilo y comportamiento personalizados al componente de etiqueta.
    PatLabelTmp(String label){
        super(label);
        setPersonalizacion();
    }

    // El constructor `PatLabelTmp(String label, String iconPath)` en la clase `PatLabelTmp` está
    // creando una nueva instancia de la clase `PatLabelTmp` con texto y un icono especificados. Esto
    // es lo que hace:
    PatLabelTmp(String label, String iconPath){
        super();
        setPersonalizacion();
        setIcon(new ImageIcon(iconPath));
    }
    
    /**
     * La función `setPersonalizacion` establece el color de primer plano en gris claro y hace que el
     * componente sea transparente al mismo tiempo que agrega un detector de mouse.
     */
    void setPersonalizacion(){
        addMouseListener(this);
        setOpaque(false);
        setForeground(Color.lightGray);
    }
    
    /**
     * La función anterior es un método anulado que maneja eventos de clic del mouse en Java.
     * 
     * @param e El parámetro "e" en el método mouseClicked representa el objeto MouseEvent que contiene
     * información sobre el evento del mouse, como la posición del cursor del mouse y el tipo de evento
     * del mouse que ocurrió. Puede utilizar este objeto para recuperar información sobre el clic del
     * mouse, como las coordenadas del clic o el
     */
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    /**
     * La función anterior es un método anulado que maneja eventos de pulsación del mouse en Java.
     * 
     * @param e El parámetro "e" en el método "mousePressed" de la clase MouseEvent representa el
     * objeto MouseEvent que contiene información sobre el evento del mouse, como la posición del
     * cursor del mouse y el tipo de botón del mouse que se presionó. Puede utilizar este objeto para
     * recuperar información sobre el evento del mouse que ocurrió
     */
    @Override
    public void mousePressed(MouseEvent e) {
    }

    /**
     * La función `mouseReleased` en Java es un método anulado que se llama cuando se suelta un botón
     * del mouse.
     * 
     * @param e El parámetro "e" en el método "mouseReleased" de la clase MouseEvent representa el
     * objeto MouseEvent que contiene información sobre el evento del mouse, como la posición del
     * cursor del mouse, el tipo de evento del mouse (por ejemplo, presionar el mouse, soltar el mouse)
     * y cualquier tecla modificadora que se presionó (
     */
    @Override
    public void mouseReleased(MouseEvent e) {
    }

    /**
     * La función `mouseEntered` cambia el cursor a un cursor de mano cuando el mouse ingresa a un
     * componente específico.
     * 
     * @param e El parámetro "e" en el método "mouseEntered(MouseEvent e)" representa el objeto
     * MouseEvent que contiene información sobre el evento del mouse que ocurrió, como las coordenadas
     * del mouse, el botón en el que se hizo clic y las teclas modificadoras presionadas. Puede
     * utilizar este objeto para recuperar información sobre el evento del mouse que desencadenó el
     * método.
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    /**
     * La función `mouseExited` cambia el cursor al cursor predeterminado cuando el mouse sale de un
     * componente.
     * 
     * @param e El parámetro "e" en el método "mouseExited" de la clase MouseEvent representa el evento
     * que ocurrió cuando el mouse salió del componente. Contiene información sobre el evento, como el
     * origen del evento, la marca de tiempo, la ubicación del mouse y otros detalles relevantes.
     */
    @Override
    public void mouseExited(MouseEvent e) {
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
}