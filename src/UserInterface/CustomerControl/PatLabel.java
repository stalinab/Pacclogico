/*
|-------------------------------------|
| © 2024 EPN-FIS, All rights reserved |
| kevin.calles@epn.edu.ec             |
|-------------------------------------|
Autor: Kevin Calles
Fecha: 25 - 02 - 2024
Script: PatLabel
*/

package UserInterface.CustomerControl;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class PatLabel extends JLabel{

    // El `public PatLabel() { personalizarComponent(); }` el constructor de la clase `PatLabel` está
    // inicializando una nueva instancia de la clase `PatLabel` sin ningún texto especificado. Llama al
    // método `customizeComponent()` para establecer un estilo personalizado para el componente de
    // etiqueta, incluida la configuración de la fuente, el color y la alineación según los valores
    // predefinidos en el método `customizeComponent()`.
    public PatLabel() {
        customizeComponent();
    }

    // El constructor `public PatLabel(String text)` en la clase `PatLabel` está inicializando una
    // nueva instancia de la clase `PatLabel` con un valor de texto especificado.
    public PatLabel(String text) {
        setText(text);
        customizeComponent();
    }

    /**
     * La función `customizeComponent` establece un estilo personalizado para un componente utilizando
     * valores de fuente, color y alineación predefinidos.
     */
    private void customizeComponent() {
        setCustomizeComponent(getText(), PatStyle.FONT, PatStyle.COLOR_FONT_LIGHT, PatStyle.ALIGNMENT_LEFT);
    }

    /**
     * La función `setCustomizeComponent` establece el texto, fuente, color, alineación y apariencia de
     * un componente en Java.
     * 
     * @param text El parámetro de texto es una cadena que representa el contenido de texto que se
     * establecerá en el componente.
     * @param font El parámetro `font` en el método `setCustomizeComponent` se utiliza para especificar
     * el estilo y tamaño de fuente del texto en el componente. Es de tipo `Fuente`, lo que le permite
     * establecer propiedades como familia de fuentes, estilo de fuente (negrita, cursiva, etc.) y
     * tamaño de fuente.
     * @param color El parámetro `color` en el método `setCustomizeComponent` se refiere al color que
     * se establecerá como color de primer plano para el componente. Este color se utilizará para
     * representar el texto mostrado por el componente.
     * @param alignment El parámetro `alignment` en el método `setCustomizeComponent` especifica cómo
     * se debe alinear el texto dentro del componente. Puede tomar uno de los siguientes valores
     * enteros:
     */
    public void setCustomizeComponent(String text, Font font, Color color, int alignment) {
        setText(text);
        setFont(font);
        setOpaque(false);
        setBackground(null);
        setForeground(color);
        setHorizontalAlignment(alignment);
    }
}