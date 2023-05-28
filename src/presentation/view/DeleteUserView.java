package presentation.view;

import presentation.view.Utilities.Fonts;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DeleteUserView {
    private final JPanel panelLogOut;
    private final JTextField userText;
    private final JPasswordField passwordText;
    private final JButton confirmButton;
    public final String DELETE_COMMAND = "DELETE_COMMAND";

    /**
     * Constructor de la vista de eliminar usuario
     */
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

    /**
     * Devuelve el string del usuario
     * @return
     */
    public String getUserText() {
        return userText.getText();
    }

    /**
     * Devuelve el string de la contraseña
     * @return
     */
    public String getPasswordText() {
        return new String(passwordText.getPassword());
    }

    /**
     * Añade un action listener al boton de confirmar
     * @param actionListener
     */
    public void setActions(ActionListener actionListener) {
        confirmButton.addActionListener(actionListener);
    }

    /**
     * Devuelve el panel de log out
     * @return
     */
    public JPanel getPanelLogOut() {
        return panelLogOut;
    }

    /**
     * Muestra un mensaje de error
     */
    public void setErrorMessage() {
        JOptionPane.showMessageDialog(panelLogOut, "User or password incorrect", "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Muestra un mensaje de exito
     */
    public void successfulDelete() {
        JOptionPane.showMessageDialog(panelLogOut, "User deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
