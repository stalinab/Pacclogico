/*
|-------------------------------------|
| © 2024 EPN-FIS, All rights reserved |
| kevin.calles@epn.edu.ec             |
|-------------------------------------|
Autor: Kevin Calles
Fecha: 25 - 02 - 2024
Script: PatStyle
*/

package UserInterface.CustomerControl;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.SwingConstants;

public abstract class PatStyle {
    public static final Color COLOR_FONT = Color.black;
    public static final Color COLOR_FONT_LIGHT = new Color(255, 255, 255);
    public static final Color COLOR_CURSOR = Color.white;
    public static final Color COLOR_BORDER = new Color(216, 210, 207);
    public static final Font FONT = new Font("JetBrains Mono", Font.PLAIN, 14);
    public static final Font FONT_BOLD = new Font("JetBrains Mono", Font.BOLD, 14);
    public static final Font FONT_SMALL = new Font("JetBrains Mono", Font.PLAIN, 10);
    public static final int ALIGNMENT_LEFT = SwingConstants.LEFT;
    public static final int ALIGNMENT_RIGHT = SwingConstants.RIGHT;
    public static final int ALIGNMENT_CENTER = SwingConstants.CENTER;
    public static final Cursor CURSOR_HAND = new Cursor(Cursor.HAND_CURSOR);
    public static final Cursor CURSOR_DEFAULT = new Cursor(Cursor.DEFAULT_CURSOR);

}