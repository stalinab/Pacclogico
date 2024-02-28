/*
|-------------------------------------|
| © 2024 EPN-FIS, All rights reserved |
| kevin.calles@epn.edu.ec             |
|-------------------------------------|
Autor: Kevin Calles
Fecha: 25 - 02 - 2024
Script: PatLabelText
*/

package UserInterface.CustomerControl;

import javax.swing.*;
import java.awt.*;

public class PatLabelText extends JPanel {

    private PatLabel lblEtiqueta = new PatLabel();
    private JLabel txtContenido = new JLabel();

    // El constructor `PatLabelText` en el código Java proporcionado está inicializando una nueva
    // instancia de la clase `PatLabelText` con un parámetro `etiqueta` especificado. Aquí hay un
    // desglose de lo que está haciendo el constructor:
    public PatLabelText(String etiqueta) {
        setLayout(new BorderLayout());
        lblEtiqueta.setCustomizeComponent(
                etiqueta,
                PatStyle.FONT,
                PatStyle.COLOR_FONT,
                PatStyle.ALIGNMENT_CENTER);

        add(lblEtiqueta, BorderLayout.NORTH);
        add(txtContenido, BorderLayout.CENTER);
    }
}