package presentation.view;

import presentation.view.Utilities.Fonts;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LogoutView {

    private JPanel contentPane;

    public final String LOGOUT_COMMAND = "LOGOUT_COMMAND";

    private JButton logoutButton;

    public LogoutView() {
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
        logoutButton = new JButton("Logout");
        logoutButton.setFont(Fonts.getMediumFont(15f));
        logoutButton.setBackground(UIPalette.TEXT_COLOR.getColor());
        logoutButton.setForeground(UIPalette.COLOR_PRIMARIO.getColor());
        logoutButton.setActionCommand(LOGOUT_COMMAND);
        contentPane.add(logoutButton , c);
    }

    public JPanel getContentPane() {
        return contentPane;
    }

    public void setAction(ActionListener actionListener) {
        logoutButton.addActionListener(actionListener);
    }

}
