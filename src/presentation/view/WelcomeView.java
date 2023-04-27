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
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setContentPane(ventanaWelcome());
    }

    public JPanel ventanaWelcome() {
        JPanel panelWelcome = new JPanel();
        panelWelcome.setLayout(new BoxLayout(panelWelcome, BoxLayout.Y_AXIS));
        panelWelcome.setBackground(UIPalette.APP_BACKGROUND.getColor());
        panelWelcome.setBorder(new EmptyBorder(50, 50, 50, 50));

        Font fTitle = new Font("Sans-Serif", Font.PLAIN, 35);
        Font fLowerText = new Font("Sans-Serif", Font.PLAIN, 15);

        JLabel welcomeTitle = createLabel(fTitle);
        JPanel jpButton = createButtonPanel();

        panelWelcome.add(welcomeTitle);
        panelWelcome.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing

        panelWelcome.add(jpButton);

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


    /**
     * Creates the button panel
     *
     * @return JPanel with the buttons
     */
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(UIPalette.APP_BACKGROUND.getColor());

        bRegister = new JButton("REGISTRARSE");
        bRegister.setPreferredSize(new Dimension(120, 30));
        bRegister.setActionCommand(REGISTER_COMMAND);

        bSignIn = new JButton("INICIAR SESIÓN");
        bSignIn.setPreferredSize(new Dimension(120, 30));
        bSignIn.setActionCommand(REGISTER_COMMAND);

        buttonPanel.add(bRegister);
        buttonPanel.add(bSignIn);

        bRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        bSignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        return buttonPanel;
    }
}