package presentation.view;

import presentation.view.Utilities.TemplateField;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class SignUpView extends JFrame implements SignUpObserver {
    /**
     * Window width size
     */
    private static final int WINDOW_WIDTH = 350;

    /**
     * Window height size
     */
    private static final int WINDOW_HEIGHT = 350;

    /**
     * TAG to register a user
     */
    public static final String REGISTER_COMMAND = "REGISTER_COMMAND";

    /**
     * TAG to go back to the login view
     */
    private TemplateField tfEmail, tfUsername, tfFirstPassword, tfSecondPassword;

    /**
     * Button to register a user
     */
    private JButton bRegister;

    public SignUpView() {
        this.setTitle("Sign Up");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setContentPane(windowSignUp());
    }

    public JPanel windowSignUp() {
        JPanel panelSignup = new JPanel();
        panelSignup.setLayout(new BoxLayout(panelSignup, BoxLayout.Y_AXIS));
        panelSignup.setBackground(UIPalette.APP_BACKGROUND.getColor());
        panelSignup.setBorder(new EmptyBorder(50, 50, 50, 50));

        Font fTitle = new Font("Sans-Serif", Font.PLAIN, 35);
        Font fLowerText = new Font("Sans-Serif", Font.PLAIN, 15);

        JLabel registerTitle = createLabel(fTitle);
        tfEmail = createTemplateField("Email", false, fLowerText);
        tfUsername = createTemplateField("Username", false, fLowerText);
        tfFirstPassword = createTemplateField("Password", true, fLowerText);
        tfSecondPassword = createTemplateField("Password", true, fLowerText);
        JPanel jpButton = createButtonPanel();

        panelSignup.add(registerTitle);
        panelSignup.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing

        panelSignup.add(tfUsername);
        panelSignup.add(tfEmail);
        panelSignup.add(tfFirstPassword);
        panelSignup.add(tfSecondPassword);
        panelSignup.add(jpButton);

        return panelSignup;
    }

    /**
     * Creates a label
     * @param font Font to use
     * @return JLabel
     */
    private JLabel createLabel(Font font) {
        JLabel label = new JLabel("REGISTRARSE");
        label.setFont(font);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    /**
     * Creates a template field
     * @param labelText Text to display in the field
     * @param isPassword True if the field is a password field
     * @param font Font to use
     * @return TemplateField
     */
    private TemplateField createTemplateField(String labelText, boolean isPassword, Font font) {
        TemplateField field = new TemplateField(labelText, isPassword);
        field.setFont(font);
        return field;
    }

    /**
     * Creates the button panel
     * @return JPanel with the buttons
     */
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(UIPalette.APP_BACKGROUND.getColor());

        bRegister = new JButton("REGISTRARSE");
        bRegister.setPreferredSize(new Dimension(120, 30));
        bRegister.setActionCommand(REGISTER_COMMAND);

        buttonPanel.add(bRegister);

        return buttonPanel;
    }

    /**
     * Registers a listener to the register button
     * @param actionListener Controller to register
     */
    public void registerController(ActionListener actionListener) {
        bRegister.addActionListener(actionListener);
    }

    /**
     * Gets the email from the email field
     * @return String with the email
     */
    public String getEmail() {
        return tfEmail.getFieldInput();
    }

    /**
     * Gets the username from the username field
     * @return String with the username
     */
    public String getUsername() {
        return tfUsername.getFieldInput();
    }

    /**
     * Gets the first password from the password field
     * @return String with the password
     */
    public String getFirstPassword() {
        return tfFirstPassword.getFieldInput();
    }

    /**
     * Gets the second password from the password field
     * @return String with the password
     */
    public String getSecondPassword() {
        return tfSecondPassword.getFieldInput();
    }

    /**
     * Shows incorrect password requirements & error message
     */
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
