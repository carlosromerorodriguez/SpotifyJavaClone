package presentation.view;

import presentation.controller.SignInController;
import presentation.controller.WelcomeController;
import presentation.view.Utilities.TemplateField;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Spliterators;

import static presentation.view.SignUpView.REGISTER_COMMAND;

public class WelcomeView extends JFrame {


    /**
     * Window width size
     */
    private static final int WINDOW_WIDTH = 350;

    /**
     * Window height size
     */
    private static final int WINDOW_HEIGHT = 350;

    /**
     * Button to register a user
     */
    private JButton bRegister;

    /**
     * Button to sign in a user
     */
    private JButton bSignIn;

    public WelcomeView() {
        this.setTitle("Welcome");
        this.setSize(WINDOW_WIDTH, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setContentPane(ventanaWelcome());
    }

    public JPanel ventanaWelcome() {
        JPanel panelWelcome = new JPanel(new GridBagLayout());
        panelWelcome.setBackground(UIPalette.APP_BACKGROUND.getColor());

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        c.anchor = GridBagConstraints.CENTER;

        Font fuente_titol = new Font("Sans-Serif", Font.PLAIN, 35);
        JLabel welcomeTitle = createLabel(fuente_titol);
        panelWelcome.add(welcomeTitle, c);

        c.gridx = 0;
        c.gridy = 1;
        panelWelcome.add(Box.createRigidArea(new Dimension(0, 30)), c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        bRegister = new JButton("Register");
        panelWelcome.add(bRegister, c);
        c.gridx = 0;
        c.gridy = 3;
        panelWelcome.add(Box.createRigidArea(new Dimension(0, 30)), c);
        c.gridx = 0;
        c.gridy = 4;
        bSignIn = new JButton("Sign In");
        panelWelcome.add(bSignIn, c);

        return panelWelcome;
    }



    /**
     * Creates a label
     *
     * @param font Font to use
     * @return JLabel
     */
    private JLabel createLabel(Font font) {
        JLabel label = new JLabel("WELCOME");
        label.setFont(font);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

}