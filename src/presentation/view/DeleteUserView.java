package presentation.view;

import presentation.controller.LogOutController;
import presentation.view.Utilities.Fonts;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteUserView {


    private JPanel panelLogOut;
    private JTextField userText;
    private JPasswordField passwordText;

    private JButton confirmButton;
    public final String DELETE_COMMAND = "DELETE_COMMAND";

    public DeleteUserView() {
        GridBagLayout gridLayout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        panelLogOut = new JPanel();
        panelLogOut.setLayout(gridLayout);
        panelLogOut.setBackground(UIPalette.COLOR_PRIMARIO.getColor());

        Font titulo = Fonts.getBoldFont(30f);
        Font subtitulo = Fonts.getMediumFont(15f);

        JLabel tituloLogout = new JLabel("Delete :(");
        tituloLogout.setForeground(UIPalette.TEXT_COLOR.getColor());
        tituloLogout.setFont(titulo);

        JLabel user = new JLabel("User: ");
        user.setForeground(UIPalette.TEXT_COLOR.getColor());
        user.setFont(subtitulo);

        JLabel password = new JLabel("Password: ");
        password.setForeground(UIPalette.TEXT_COLOR.getColor());
        password.setFont(subtitulo);

        userText = new JTextField();
        userText.setPreferredSize(new Dimension(200, 30));
        userText.setFont(subtitulo);

        passwordText = new JPasswordField();
        passwordText.setPreferredSize(new Dimension(200, 30));
        userText.setFont(subtitulo);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setBackground(UIPalette.COLOR_PRIMARIO.getColor());

        confirmButton = new JButton();
        confirmButton.setBackground(UIPalette.TEXT_COLOR.getColor());
        confirmButton.setForeground(UIPalette.COLOR_PRIMARIO.getColor());

        confirmButton.setText("Confirm");
        confirmButton.setActionCommand(DELETE_COMMAND);
        confirmButton.setFont(subtitulo);

        confirmButton.setPreferredSize(new Dimension(120, 30));


        buttonsPanel.add(confirmButton);

        c.insets = new Insets(0, 0, 30, 0);

        c.gridx = 0;
        c.gridy = 0;
        panelLogOut.add(tituloLogout,c);
        c.gridy = 1;
        c.insets = new Insets(0, 0, 10, 160);
        panelLogOut.add(user,c);
        c.gridy = 2;
        c.insets = new Insets(0, 0, 30, 0);
        panelLogOut.add(userText,c);
        c.gridy = 3;
        c.insets = new Insets(0, 0, 10, 120);
        panelLogOut.add(password,c);
        c.gridy = 4;
        c.insets = new Insets(0, 0, 30, 0);
        panelLogOut.add(passwordText,c);
        c.gridy = 5;
        c.insets = new Insets(0, 0, 0, 0);
        panelLogOut.add(buttonsPanel,c);
    }

    public String getUserText() {
        return userText.getText();
    }

    public String getPasswordText() {
        return new String(passwordText.getPassword());
    }

    public void setActions(ActionListener actionListener) {
        confirmButton.addActionListener(actionListener);
    }

    public JPanel getPanelLogOut() {
        return panelLogOut;
    }
}
