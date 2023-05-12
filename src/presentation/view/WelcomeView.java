package presentation.view;

import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WelcomeView extends JFrame {


    private final JPanel welcomePanel;
    public static final String REGISTER_VIEW_COMMAND = "REGISTER_VIEW_COMMAND";

    public static final String SIGNUP_VIEW_COMMAND = "SIGNUP_VIEW_COMMAND";
    /**
     * Button to register a user
     */
    private final JButton bRegister;

    /**
     * Button to sign in a user
     */
    private final JButton bSignIn;

    public WelcomeView() {
        welcomePanel = new JPanel(new GridBagLayout());
        welcomePanel.setBackground(UIPalette.APP_BACKGROUND.getColor());

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        c.anchor = GridBagConstraints.CENTER;

        Font fuente_titol = new Font("Sans-Serif", Font.PLAIN, 35);
        JLabel welcomeTitle = createLabel(fuente_titol);
        welcomeTitle.setForeground(UIPalette.TEXT_COLOR.getColor());
        welcomePanel.add(welcomeTitle, c);

        c.gridx = 0;
        c.gridy = 1;
        welcomePanel.add(Box.createRigidArea(new Dimension(0, 30)), c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        bRegister = new JButton("Register");
        bRegister.setActionCommand(REGISTER_VIEW_COMMAND);
        bRegister.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                bRegister.setBackground(UIPalette.BUTTON_HOVER.getColor());
            }
            public void mouseExited(MouseEvent evt) {
                bRegister.setBackground(UIPalette.TEXT_COLOR.getColor());
            }
        });

        welcomePanel.add(bRegister, c);
        c.gridx = 0;
        c.gridy = 3;
        welcomePanel.add(Box.createRigidArea(new Dimension(0, 30)), c);
        c.gridx = 0;
        c.gridy = 4;
        bSignIn = new JButton("Sign In");
        bSignIn.setActionCommand(SIGNUP_VIEW_COMMAND);
        bSignIn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                bSignIn.setBackground(UIPalette.BUTTON_HOVER.getColor());
            }
            public void mouseExited(MouseEvent evt) {
                bSignIn.setBackground(UIPalette.TEXT_COLOR.getColor());
            }
        });
        welcomePanel.add(bSignIn, c);
    }

    private JLabel createLabel(Font font) {
        JLabel label = new JLabel("WELCOME");
        label.setFont(font);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    public JPanel getWelcomePanel() {
        return welcomePanel;
    }

    public void registerController(ActionListener actionListener) {
        bRegister.addActionListener(actionListener);
    }

    public void welcomeController(ActionListener actionListener) {
        bSignIn.addActionListener(actionListener);
    }
}