package presentation.view.Utilities;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.border.EmptyBorder;

import static presentation.view.Utilities.UIPalette.INPUT_TEXT;
import static presentation.view.Utilities.UIPalette.TEXT_COLOR;

public class TemplateField extends JPanel {
    /**
     * Width of the window
     */
    private static final int DEFAULT_WINDOW_WIDTH = 400;

    /**
     * Height of the JPanel
     */
    private static final int DEFAULT_INPUT_HEIGHT = 40;

    /**
     * Preferred height of labels
     */
    private static final int PREFERRED_LABEL_HEIGHT = 20;

    /**
     * Preferred width of labels
     */
    private static final int PREFERRED_LABEL_WIDTH = 100;

    /**
     * JPanel's input
     */
    private final JTextField jtfInput;
    /**
     * JPanel's toggle visibility button
     */
    private final JToggleButton jtbToggleVisibility;

    /**
     * It specifies a text and if the input should be hidden
     * @param s Text to show
     * @param isPassword If the input should be hidden
     */
    public TemplateField(String s, boolean isPassword) {
        // Create a new BoxLayout with a vertical orientation
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel text = new JLabel(s.toUpperCase()); // Convert the text to uppercase
        text.setForeground(TEXT_COLOR.getColor());
        text.setPreferredSize(new Dimension(PREFERRED_LABEL_WIDTH, PREFERRED_LABEL_HEIGHT));
        // Align the label to the left
        text.setAlignmentX(Component.LEFT_ALIGNMENT);

        text.setBorder(new EmptyBorder(0, 0, 10, 0));

        jtfInput = new JPasswordField();
        ((JPasswordField) jtfInput).setEchoChar(isPassword ? '•' : (char) 0);

        JPanel innerPanel = new JPanel(new BorderLayout());
        innerPanel.add(jtfInput, BorderLayout.CENTER);

        if (isPassword) {
            jtbToggleVisibility = new JToggleButton();

            // Cargamos las imágenes desde un archivo
            ImageIcon eyeOpenIcon = null;
            ImageIcon eyeClosedIcon = null;
            try {
                Image eyeOpenImage = ImageIO.read(new File("data/img/contra_ojo_cerrado.png"));
                eyeOpenIcon = new ImageIcon(eyeOpenImage.getScaledInstance(20, 20, Image.SCALE_SMOOTH)); // Cambia el tamaño de la imagen
                Image eyeClosedImage = ImageIO.read(new File("data/img/contra_ojo_abierto.png"));
                eyeClosedIcon = new ImageIcon(eyeClosedImage.getScaledInstance(20, 20, Image.SCALE_SMOOTH)); // Cambia el tamaño de la imagen
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            jtbToggleVisibility.setIcon(eyeOpenIcon); // Establece la imagen inicial del botón
            jtbToggleVisibility.setPreferredSize(new Dimension(20, 20)); // El tamaño que prefieras para el botón
            ImageIcon finalEyeOpenIcon = eyeOpenIcon;
            ImageIcon finalEyeClosedIcon = eyeClosedIcon;
            jtbToggleVisibility.addActionListener(e -> {
                if (jtbToggleVisibility.isSelected()) {
                    ((JPasswordField) jtfInput).setEchoChar((char) 0); // Muestra la contraseña
                    jtbToggleVisibility.setIcon(finalEyeClosedIcon); // Cambia la imagen del botón
                } else {
                    ((JPasswordField) jtfInput).setEchoChar('•'); // Oculta la contraseña
                    jtbToggleVisibility.setIcon(finalEyeOpenIcon); // Cambia la imagen del botón
                }
            });
            innerPanel.add(jtbToggleVisibility, BorderLayout.EAST);
        } else {
            jtbToggleVisibility = null;
        }

        add(text);
        add(innerPanel);

        setBackground(UIPalette.APP_BACKGROUND.getColor());
        setMaximumSize(new Dimension(DEFAULT_WINDOW_WIDTH, DEFAULT_INPUT_HEIGHT));
    }

    /**
     * It returns the input
     * @return Input
     */
    public String getFieldInput() {
        return new String(((JPasswordField) jtfInput).getPassword());
    }

    public void clearWrongField() {
        jtfInput.setText("");
        jtfInput.setBorder(BorderFactory.createLineBorder(UIPalette.ERROR_COLOR.getColor()));
    }
}
