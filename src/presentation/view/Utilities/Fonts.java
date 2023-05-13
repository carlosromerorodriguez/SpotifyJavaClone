package presentation.view.Utilities;

import java.awt.*;
import java.io.File;

/**
 * Defines a palette of colors used in the application's UI
 */
public class Fonts {

    public static Font getMediumFont(float size) {
        try {
            // Cargar el archivo de fuente (.ttf)
            File fontFile = new File("data/fonts/GothamMedium.ttf");

            // Crear una instancia de Font con la fuente personalizada
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);

            // Derivar una fuente de tamaño predeterminado (por ejemplo, tamaño 12)
            Font customFont12 = customFont.deriveFont(size);

            // Registrar la fuente personalizada en el entorno gráfico
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

            return customFont12;
        } catch (Exception e) {
            e.printStackTrace();
            // Si ocurre un error, retornar una fuente predeterminada
            return new Font("Arial", Font.PLAIN, 12);
        }
    }

    public static Font getLightFont(float size) {
        try {
            // Cargar el archivo de fuente (.ttf)
            File fontFile = new File("data/fonts/GothamLight.ttf");

            // Crear una instancia de Font con la fuente personalizada
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);

            // Derivar una fuente de tamaño predeterminado (por ejemplo, tamaño 12)
            Font customFont12 = customFont.deriveFont(size);

            // Registrar la fuente personalizada en el entorno gráfico
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

            return customFont12;
        } catch (Exception e) {
            e.printStackTrace();
            // Si ocurre un error, retornar una fuente predeterminada
            return new Font("Arial", Font.PLAIN, 12);
        }
    }

    public static Font getBoldFont(float size) {
        try {
            // Cargar el archivo de fuente (.ttf)
            File fontFile = new File("data/fonts/GothamBold.ttf");

            // Crear una instancia de Font con la fuente personalizada
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);

            // Derivar una fuente de tamaño predeterminado (por ejemplo, tamaño 12)
            Font customFont12 = customFont.deriveFont(size);

            // Registrar la fuente personalizada en el entorno gráfico
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

            return customFont12;
        } catch (Exception e) {
            e.printStackTrace();
            // Si ocurre un error, retornar una fuente predeterminada
            return new Font("Arial", Font.PLAIN, 12);
        }
    }

}
