package presentation.view;

import presentation.view.Utilities.Fonts;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static presentation.view.Utilities.UIPalette.APP_BACKGROUND;

public class SignInView extends JFrame {


    public static final String LOGIN_COMMAND = "LOGIN_COMMAND";

    public static final String BACK_FROM_SIGNIN = "BACK_FROM_SIGNIN";

    private final JTextField jTF_nom_correu;
    private final JPasswordField jTF_contrasenya;

    private final JPanel panel_signin;

    private final JButton bIniciarSessio;

    private final JButton bBack;

    public String getLoginUserMail() {
        return jTF_nom_correu.getText();
    }

    public String getLoginUserPassword() {
        return new String(jTF_contrasenya.getPassword());
    }

    public JPanel getPanelSignIn() {
        return panel_signin;
    }

    public SignInView() {

        panel_signin = new JPanel(new GridBagLayout());
        panel_signin.setBackground(APP_BACKGROUND.getColor());
        GridBagConstraints c = new GridBagConstraints();

        Font fuente_titol = Fonts.getBoldFont(30f);
        Font fuente_petit = Fonts.getLightFont(15f);

        panel_signin.setBorder(new EmptyBorder(0, 0, 0, 0));


        JLabel iniciar_sessio = new JLabel("Iniciar Sessió.");
        iniciar_sessio.setForeground(UIPalette.TEXT_COLOR.getColor());
        iniciar_sessio.setFont(fuente_titol);
        c.ipadx = 100;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(170, 0, 20, 0);
        panel_signin.add(iniciar_sessio, c);

        JLabel nom_correu = new JLabel("Nom o Correu");
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
        jTF_nom_correu.setFont(Fonts.getMediumFont(20f));
        jTF_nom_correu.setBackground(UIPalette.COLOR_SECUNDARIO.getColor());
        jTF_nom_correu.setForeground(UIPalette.COLOR_PRIMARIO.getColor());
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 7;
        c.insets = new Insets(0, 0, 10, 0);
        panel_signin.add(jTF_nom_correu, c);

        JLabel contrasenya = new JLabel("Contrasenya");
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
        jTF_contrasenya.setFont(Fonts.getMediumFont(20f));
        jTF_contrasenya.setForeground(UIPalette.COLOR_PRIMARIO.getColor());
        jTF_contrasenya.setBackground(UIPalette.COLOR_SECUNDARIO.getColor());
        char defaultEchoChar = jTF_contrasenya.getEchoChar();
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 7;
        c.insets = new Insets(0, 0, 10, 0);

        JPanel passwordFieldPanel = new JPanel(new BorderLayout());
        passwordFieldPanel.add(jTF_contrasenya, BorderLayout.CENTER);

        JToggleButton showPasswordToggle = new JToggleButton();
        ImageIcon eyeClosedIcon = new ImageIcon(new ImageIcon("data/img/contra_ojo_cerrado.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        showPasswordToggle.setIcon(eyeClosedIcon);
        showPasswordToggle.setBorder(new EmptyBorder(0, 0, 0, 10));
        showPasswordToggle.setContentAreaFilled(false);
        showPasswordToggle.setFocusable(false);
        ImageIcon eyeOpenIcon = new ImageIcon(new ImageIcon("data/img/contra_ojo_abierto.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));

        showPasswordToggle.addActionListener(e -> {
            if (showPasswordToggle.isSelected()) {
                jTF_contrasenya.setEchoChar((char) 0);
                showPasswordToggle.setIcon(eyeOpenIcon);
            } else {
                jTF_contrasenya.setEchoChar(defaultEchoChar);
                showPasswordToggle.setIcon(eyeClosedIcon);
            }
        });

        passwordFieldPanel.add(showPasswordToggle, BorderLayout.EAST);
        panel_signin.add(passwordFieldPanel, c);

        passwordFieldPanel.add(showPasswordToggle, BorderLayout.EAST);
        panel_signin.add(passwordFieldPanel, c);

        bIniciarSessio = new JButton("Entrar");
        bIniciarSessio.setActionCommand(LOGIN_COMMAND);
        bIniciarSessio.setFont(Fonts.getBoldFont(20f));
        bIniciarSessio.setForeground(UIPalette.COLOR_SECUNDARIO.getColor());
        bIniciarSessio.setBackground(UIPalette.TEXT_COLOR.getColor());
        bIniciarSessio.setOpaque(true);
        bIniciarSessio.setFocusPainted(false);
        bIniciarSessio.setContentAreaFilled(true);
        bIniciarSessio.setBorderPainted(true);
        bIniciarSessio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bIniciarSessio.setBackground(UIPalette.COLOR_SECUNDARIO.getColor());
                bIniciarSessio.setForeground(UIPalette.TEXT_COLOR.getColor());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bIniciarSessio.setBackground(UIPalette.TEXT_COLOR.getColor());
                bIniciarSessio.setForeground(UIPalette.COLOR_SECUNDARIO.getColor());
            }
        });
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 10;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(20, 220, 0, 0);
        panel_signin.add(bIniciarSessio, c);

        bBack = new JButton("<");
        bBack.setFont(Fonts.getBoldFont(20f));
        bBack.setForeground(UIPalette.COLOR_SECUNDARIO.getColor());
        bBack.setBackground(UIPalette.TEXT_COLOR.getColor());
        bBack.setOpaque(true);
        bBack.setFocusPainted(false);
        bBack.setContentAreaFilled(true);
        bBack.setBorderPainted(true);
        bBack.setActionCommand(BACK_FROM_SIGNIN);
        bBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bBack.setBackground(UIPalette.COLOR_SECUNDARIO.getColor());
                bBack.setForeground(UIPalette.TEXT_COLOR.getColor());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bBack.setBackground(UIPalette.TEXT_COLOR.getColor());
                bBack.setForeground(UIPalette.COLOR_SECUNDARIO.getColor());
            }
        });
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

    public void logInController(ActionListener actionListener) {
        bIniciarSessio.addActionListener(actionListener);
    }

    public void backController(ActionListener actionListener) {
        bBack.addActionListener(actionListener);
    }

}

