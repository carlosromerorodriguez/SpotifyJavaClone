package presentation.view;

import javax.swing.*;

public class ErrorHandler {
    /**
     * Shows a message on the screen
     * @param message Message to show on the screen
     */
    public static void showErrorOnScreen(String message, String title) {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, message, title, JOptionPane.ERROR_MESSAGE);
        frame.dispose();
    }
}
