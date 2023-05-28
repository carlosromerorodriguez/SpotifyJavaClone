package presentation.view;

import presentation.view.Utilities.Fonts;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LogOutView {
    /**
     * Content pane of the view (panel).
     */
    private final JPanel contentPane;
    /**
     * Action command for the log-out button.
     */
    public final String LOGOUT_COMMAND = "LOGOUT_COMMAND";
    /**
     * Log-out button of the view.
     */
    private final JButton logOutButton;

    /**
     * Creates the view for the log-out panel.
     */
    public LogOutView() {
        contentPane = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        contentPane.setBackground(UIPalette.COLOR_PRIMARIO.getColor());

        JLabel titlePanel = new JLabel("Or you just can...");
        titlePanel.setForeground(UIPalette.TEXT_COLOR.getColor());
        titlePanel.setFont(Fonts.getBoldFont(25f));
        c.gridy = 0;
        c.gridx = 0;
        c.insets = new Insets(0, 0, 30, 0);
        contentPane.add(titlePanel, c);

        c.gridy = 1;
        logOutButton = new JButton("Logout");
        logOutButton.setFont(Fonts.getMediumFont(15f));
        logOutButton.setBackground(UIPalette.TEXT_COLOR.getColor());
        logOutButton.setForeground(UIPalette.COLOR_PRIMARIO.getColor());
        logOutButton.setActionCommand(LOGOUT_COMMAND);
        contentPane.add(logOutButton, c);
    }

    /**
     * Returns the content pane of the view.
     * @return Content pane of the view.
     */
    public JPanel getContentPane() {
        return contentPane;
    }

    /**
     * Returns the log-out button of the view.
     * @return Log-out button of the view.
     */
    public JButton getLogOutButton() {
        return logOutButton;
    }

    /**
     * Sets the action listener for the log-out button.
     * @param actionListener
     */
    public void setAction(ActionListener actionListener) {
        logOutButton.addActionListener(actionListener);
    }
}