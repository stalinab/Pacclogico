/*
|-------------------------------------|
| © 2024 EPN-FIS, All rights reserved |
| kevin.calles@epn.edu.ec             |
|-------------------------------------|
Autor: Kevin Calles
Fecha: 25 - 02 - 2024
Script: PatTextBox
*/

package UserInterface.CustomerControl;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class PatTextBox extends JTextField {
    // El `public PatTextBox() { personalizarComponent(); }` método en la clase `PatTextBox` es el
    // constructor de la clase. Cuando se crea una instancia de `PatTextBox`, este constructor se llama
    // automáticamente. Dentro del constructor, se llama al método `customizeComponent()`, que
    // establece varias propiedades visuales para el componente `PatTextBox` usando estilos
    // predefinidos. Esto ayuda a inicializar `PatTextBox` con la apariencia visual y el comportamiento
    // deseados.
    public PatTextBox() {
        customizeComponent();
    }

    /**
     * La función `customizeComponent` establece varias propiedades visuales para un componente Java
     * utilizando estilos predefinidos.
     */
    private void customizeComponent() {
        setFont(PatStyle.FONT);
        setForeground(PatStyle.COLOR_FONT);
        setBorder(createBorderRect());
        setCaretColor(PatStyle.COLOR_CURSOR);
        setMargin(new Insets(10, 10, 10, 10));
        setOpaque(false);
        setColumns(10);
    }

    /**
     * La función crea un borde compuesto con un borde de línea y un borde vacío con inserciones
     * específicas.
     * 
     * @return Se devuelve un objeto CompoundBorder, que se crea combinando un LineBorder y un
     * EmptyBorder.
     */
    private Border createBorderRect() {
        Border lineBorder = BorderFactory.createLineBorder(PatStyle.COLOR_BORDER);
        Border emptyBorder = new EmptyBorder(5, 5, 5, 5);
        return new CompoundBorder(lineBorder, emptyBorder);
    }

    /**
     * La función crea un borde compuesto con un borde vacío en la parte superior y un borde mate con
     * un color y grosor específicos en la parte inferior.
     * 
     * @return Se devuelve un borde compuesto, que consta de un borde vacío en la parte superior y un
     * borde mate en la parte inferior con un grosor y color específicos.
     */
    public Border createBorderLine() {
        int thickness = 1;
        return BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(0, 0, thickness, 0),
                BorderFactory.createMatteBorder(0, 0, thickness, 0, PatStyle.COLOR_BORDER));
    }
}