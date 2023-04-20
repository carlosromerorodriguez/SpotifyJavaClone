package presentation.view.Utilities;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

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
     * It specifies a text and if the input should be hidden
     * @param s Text to show
     * @param isPassword If the input should be hidden
     */
    public TemplateField(String s, boolean isPassword) {
        // Create a new BoxLayout with a vertical orientation
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel text = new JLabel(s.toUpperCase()); // Convert the text to uppercase
        int adjustedWidth = PREFERRED_LABEL_WIDTH - 50; // Adjust the width
        text.setPreferredSize(new Dimension(adjustedWidth, PREFERRED_LABEL_HEIGHT));
        // Align the label to the left
        text.setAlignmentX(Component.LEFT_ALIGNMENT);

        text.setBorder(new EmptyBorder(0, 0, 2, 0)); // Add spacing below the text label

        jtfInput = (isPassword ? new JPasswordField() : new JTextField());
        jtfInput.setPreferredSize(new Dimension(adjustedWidth, PREFERRED_LABEL_HEIGHT));
        // Align the input field to the left
        jtfInput.setAlignmentX(Component.LEFT_ALIGNMENT);

        add(text);
        add(jtfInput);

        setBackground(UIPalette.APP_BACKGROUND.getColor());
        setMaximumSize(new Dimension(DEFAULT_WINDOW_WIDTH, DEFAULT_INPUT_HEIGHT));
    }



    /**
     * It returns the input
     * @return Input
     */
    public String getFieldInput() {
        return (jtfInput instanceof JPasswordField) ? String.valueOf(((JPasswordField) jtfInput).getPassword()) : jtfInput.getText();
    }

}
