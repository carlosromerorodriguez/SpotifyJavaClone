package presentation.view.Utilities;

import java.awt.*;

/**
 * Defines a palette of colors used in the application's UI
 */
public enum UIPalette {
    ADD_SONG_COLOR(20, 92, 109),
    /**
     * The main background color of the application
     */
    TEXT_COLOR(236, 243, 158),
    APP_BACKGROUND(49, 87, 44),

    COLOR_PRIMARIO_CLARO(79, 119, 45),

    COLOR_REPRODUCTOR(19, 42, 19),

    INPUT_TEXT(51, 255, 153),

    COLOR_PRIMARIO(49, 87, 44),

    COLOR_SECUNDARIO(144, 169, 85),


    /**
     * The background color of menus
     */
    MENU_BACKGROUND(135, 189, 189),

    /**
     * The color of some buttons
     */
    BUTTON_BACKGROUND(93, 130, 130),

    /**
     * The color of text on top buttons when they are not selected
     */
    BUTTON_TEXT_DEFAULT(230, 241, 255),

    /**
     * The color of text on top buttons when they are selected
     */
    BUTTON_TEXT_ACTIVE(106, 250, 188),

    /**
     * The color of the "delete account" button
     */
    DELETE_BUTTON_BACKGROUND(99, 20, 20),

    /**
     * The color of the "confirm configuration" button
     */
    CONFIRM_BUTTON_BACKGROUND(60, 163, 117),

    /**
     * A custom color used for text on dark backgrounds
     */
    DARK_TEXT_COLOR(40, 40, 40),

    /**
     * A custom color used for success messages
     */
    SUCCESS_COLOR(50, 150, 50),

    /**
     * A custom color used for error messages
     */
    ERROR_COLOR(150, 50, 50),

    BUTTON_HOVER(100, 255, 153),

    BUTTON_COLOR(0, 255, 153);

    /**
     * The RGB values for the color
     */
    private final int red;
    private final int green;
    private final int blue;

    /**
     * Creates a new color constant with the specified RGB values
     * @param r The red value (0-255)
     * @param g The green value (0-255)
     * @param b The blue value (0-255)
     */
    UIPalette(int r, int g, int b){
        this.red = r;
        this.green = g;
        this.blue = b;
    }

    /**
     * Returns the color represented by this constant
     * @return The color as a Color object
     */
    public Color getColor() {
        return new Color(red, green, blue);
    }
}
