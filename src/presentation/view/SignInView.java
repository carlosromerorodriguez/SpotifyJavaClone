package presentation.view;

import presentation.controller.SignInController;
import presentation.controller.SignUpController;
import presentation.view.Utilities.TemplateField;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static presentation.view.Utilities.UIPalette.APP_BACKGROUND;

public class SignInView extends JFrame {


    public static final String LOGIN_COMMAND = "LOGIN_COMMAND";

    public static final String BACK_FROM_SIGNIN = "BACK_FROM_SIGNIN";

    private JTextField jTF_nom_correu;
    private JPasswordField jTF_contrasenya;

    private JPanel panel_signin;

    private JButton bIniciarSessio;

    private JButton bBack;

    public String getLoginUserMail() {
        return jTF_nom_correu.getText();
    }

    public String getLoginUserPassword() {
        return jTF_contrasenya.getPassword().toString();
    }

    public JPanel getPanel_signin() {
        return panel_signin;
    }

    public SignInView() {

        panel_signin = new JPanel(new GridBagLayout());
        panel_signin.setBackground(APP_BACKGROUND.getColor());
        GridBagConstraints c = new GridBagConstraints();

        Font fuente_titol = new Font("Sans-Serif", Font.PLAIN, 35);
        Font fuente_petit = new Font("Sans-Serif", Font.PLAIN, 15);

        panel_signin.setBorder(new EmptyBorder(0, 0, 0, 0));


        JLabel iniciar_sessio = new JLabel("INICIAR SESSIO");
        iniciar_sessio.setForeground(UIPalette.TEXT_COLOR.getColor());
        iniciar_sessio.setFont(fuente_titol);
        c.ipadx = 100;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(170, 0, 20, 0);
        panel_signin.add(iniciar_sessio, c);

        JLabel nom_correu = new JLabel("NOM O CORREU");
        nom_correu.setForeground(UIPalette.TEXT_COLOR.getColor());
        nom_correu.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 10, 0);
        panel_signin.add(nom_correu, c);

        jTF_nom_correu = new JTextField();
        jTF_nom_correu.setPreferredSize(new Dimension(120, 30));
        jTF_nom_correu.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 7;
        c.insets = new Insets(0, 0, 10, 0);
        panel_signin.add(jTF_nom_correu, c);

        JLabel contrasenya = new JLabel("CONTRASENYA");
        contrasenya.setForeground(UIPalette.TEXT_COLOR.getColor());
        contrasenya.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 10, 0);
        panel_signin.add(contrasenya, c);

        jTF_contrasenya = new JPasswordField();
        jTF_contrasenya.setPreferredSize(new Dimension(120, 30));
        jTF_contrasenya.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 7;
        c.insets = new Insets(0, 0, 10, 0);
        panel_signin.add(jTF_contrasenya, c);


        bIniciarSessio = new JButton("INICIAR SESSIO");
        bIniciarSessio.setPreferredSize(new Dimension(50, 30));
        bIniciarSessio.setActionCommand(LOGIN_COMMAND);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 10;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(20, 220, 0, 0);
        panel_signin.add(bIniciarSessio, c);

        bBack = new JButton("<");
        bBack.setActionCommand(BACK_FROM_SIGNIN);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 10;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(20, 0, 0, 220);
        panel_signin.add(bBack, c);

        c.ipady = 0;
        c.weighty = 0.2;
        c.gridx = 0;
        c.gridy = 11;
        c.anchor = GridBagConstraints.CENTER;
        panel_signin.add(new JLabel(), c);

    }

    public void registerController(ActionListener actionListener) {
        bIniciarSessio.addActionListener(actionListener);
    }


    public void backController(ActionListener actionListener) {
        bBack.addActionListener(actionListener);
    }
    public void wrongPasswordError() {
        JOptionPane.showMessageDialog(this,
                "<html><body><p style='width: 250px;'>Invalid password! Your password must:<br>" +
                        "<ul>" +
                        "<li>Be at least 8 characters long</li>" +
                        "<li>Contain at least one lowercase and one uppercase letter</li>" +
                        "<li>Include at least one numeric character</li>" +
                        "<li>Not contain any whitespaces</li>" +
                        "</ul>" +
                        "Please try again.</p></body></html>",
                "Invalid Password", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Shows incorrect password error message
     */
    public void passwordsMismatchError() {
        JOptionPane.showMessageDialog(this,
                "The passwords entered do not match. Please ensure both passwords are identical and try again.",
                "Password Mismatch", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Shows incorrect email error message
     */
    public void wrongEmailError() {
        JOptionPane.showMessageDialog(this,
                "The email address you entered is not valid. Please ensure the email format is correct and try again.",
                "Invalid Email Address", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Shows incorrect user error message
     */
    public void wrongUserError() {
        JOptionPane.showMessageDialog(this,
                "The username you entered is not valid. Please ensure it meets the requirements and try again.",
                "Invalid Username", JOptionPane.ERROR_MESSAGE);
    }

}

