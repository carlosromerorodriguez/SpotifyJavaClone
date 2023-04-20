package presentation.view;

import presentation.controller.SignUpController;
import presentation.view.Utilities.TemplateField;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpView extends JFrame implements ActionListener, SignUpObserver {
    /**
     * Window width size
     */
    private static final int WINDOW_WIDTH = 350;

    /**
     * Window height size
     */
    private static final int WINDOW_HEIGHT = 350;
    private GridLayout gridLayout;
    private TemplateField tfEmail, tfUsername, tfFirstPassword, tfSecondPassword;
    private JButton bRegister;
    private JLabel jlRegister, jlEmail, jlUsername, jlPassword, jlPasswordConfirmation;
    private JPanel jpButton, panelSignup;
    private Font fTitle, fLowerText;
    private final SignUpController controller;

    public SignUpView(SignUpController signUpController) {
        this.controller = signUpController;

        this.setTitle("Sign Up");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setContentPane(windowSignUp());
    }

    public JPanel windowSignUp() {
        panelSignup = new JPanel();
        panelSignup.setLayout(new BoxLayout(panelSignup, BoxLayout.Y_AXIS));
        panelSignup.setBackground(UIPalette.APP_BACKGROUND.getColor());
        panelSignup.setBorder(new EmptyBorder(50, 50, 50, 50));

        Font fTitle = new Font("Sans-Serif", Font.PLAIN, 35);
        Font fLowerText = new Font("Sans-Serif", Font.PLAIN, 15);

        JLabel registrarse = createLabel(fTitle);
        tfEmail = createTemplateField("Email", false, fLowerText);
        tfUsername = createTemplateField("Username", false, fLowerText);
        tfFirstPassword = createTemplateField("Password", true, fLowerText);
        tfSecondPassword = createTemplateField("Password", true, fLowerText);
        jpButton = createButtonPanel();

        panelSignup.add(registrarse);
        panelSignup.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        panelSignup.add(tfEmail);
        panelSignup.add(tfUsername);
        panelSignup.add(tfFirstPassword);
        panelSignup.add(tfSecondPassword);
        panelSignup.add(jpButton);

        return panelSignup;
    }

    private JLabel createLabel(Font font) {
        JLabel label = new JLabel("REGISTRARSE");
        label.setFont(font);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    private TemplateField createTemplateField(String labelText, boolean isPassword, Font font) {
        TemplateField field = new TemplateField(labelText, isPassword);
        field.setFont(font);
        return field;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(UIPalette.APP_BACKGROUND.getColor());

        bRegister = new JButton("REGISTRARSE");
        bRegister.setPreferredSize(new Dimension(120, 30));
        bRegister.addActionListener(this);

        buttonPanel.add(bRegister);

        return buttonPanel;
    }

    /**
     * Checks if the email input by the user complies with the requirements
     * @return True if the email complies with the format specifications
     */
    private boolean checkMail() {
        return (tfEmail.getFieldInput() != null &&
                tfEmail.getFieldInput().matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"));
    }

    /**
     * Checks if the password is valid
     * @return True if the password complies with MIT password policies
     */
    private boolean checkPassword() {
        return !String.valueOf(tfFirstPassword.getFieldInput()).equals("") &&
                String.valueOf(tfFirstPassword.getFieldInput()).matches("(^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$)");
    }

    /**
     * Checks if both passwords are equal
     * @return True if they are equal
     */
    private boolean checkPasswords() {
        return (tfFirstPassword.getFieldInput().equals(tfSecondPassword.getFieldInput()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bRegister) {
            if (tfUsername.getFieldInput().isBlank()) {
                wrongUser();
            } else if (!checkMail()) {
                wrongEmail();
            } else if (!checkPassword()) {
                wrongPassword();
            } else if (!checkPasswords()) {
                wrongPasswords();
            } else {
                controller.registerButtonPressed(tfUsername.getFieldInput(), tfEmail.getFieldInput(), tfFirstPassword.getFieldInput());
            }
        }
    }

    /**
     * Shows incorrect password requirements & error message
     */
    private void wrongPassword() {
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
    private void wrongPasswords() {
        JOptionPane.showMessageDialog(this,
                "The passwords entered do not match. Please ensure both passwords are identical and try again.",
                "Password Mismatch", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Shows incorrect email error message
     */
    private void wrongEmail() {
        JOptionPane.showMessageDialog(this,
                "The email address you entered is not valid. Please ensure the email format is correct and try again.",
                "Invalid Email Address", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Shows incorrect user error message
     */
    private void wrongUser() {
        JOptionPane.showMessageDialog(this,
                "The username you entered is not valid. Please ensure it meets the requirements and try again.",
                "Invalid Username", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Shows successful registration informative message
     */
    @Override
    public void userRegisteredSuccessfully() {
        JOptionPane.showMessageDialog(this, "Account created successfully", "Successful Registration", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Shows incorrect user error message
     */
    @Override
    public void userRegistrationFailed() {
        JOptionPane.showMessageDialog(this, "This username is already taken. Please try again.", "Wrong registration", JOptionPane.ERROR_MESSAGE);
    }
}
