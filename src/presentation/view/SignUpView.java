package presentation.view;

import presentation.view.Utilities.Fonts;
import presentation.view.Utilities.TemplateField;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class SignUpView extends JFrame implements SignUpObserver {

    /**
     * TAG to register a user
     */
    public static final String REGISTER_COMMAND = "REGISTER_COMMAND";

    public static final String BACK_FROM_SIGNUP_COMMAND = "BACK_FROM_SIGNUP_COMMAND";
    private final TemplateField tfEmail;
    private final TemplateField tfUsername;
    private final TemplateField tfFirstPassword;
    private final TemplateField tfSecondPassword;

    /**
     * Button to register a user
     */
    private final JButton bRegister;

    private final JPanel panelSignup;

    private final JButton bBack;

    public SignUpView() {

        panelSignup = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        panelSignup.setBackground(UIPalette.APP_BACKGROUND.getColor());
        panelSignup.setBorder(new EmptyBorder(0, 0, 0, 0));


        Font fTitle = Fonts.getBoldFont(30f);
        Font fLowerText = Fonts.getLightFont(15f);

        JLabel registerTitle = createLabel(fTitle);
        registerTitle.setForeground(UIPalette.TEXT_COLOR.getColor());
        tfEmail = createTemplateField("Email", false, fLowerText);
        tfEmail.setForeground(UIPalette.TEXT_COLOR.getColor());
        tfUsername = createTemplateField("Username", false, fLowerText);
        tfUsername.setForeground(UIPalette.TEXT_COLOR.getColor());
        tfFirstPassword = createTemplateField("Password", true, fLowerText);
        tfFirstPassword.setForeground(UIPalette.TEXT_COLOR.getColor());
        tfSecondPassword = createTemplateField("Password Confirmation", true, fLowerText);
        tfSecondPassword.setForeground(UIPalette.TEXT_COLOR.getColor());

        c.ipadx = 100;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(20, 0, 20, 0);
        panelSignup.add(registerTitle, c);

        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 6;
        c.insets = new Insets(0, 0, 10, 0);
        panelSignup.add(tfUsername, c);

        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 6;
        c.insets = new Insets(0, 0, 10, 0);
        panelSignup.add(tfEmail, c);

        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 6;
        c.insets = new Insets(0, 0, 10, 0);
        panelSignup.add(tfFirstPassword, c);

        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 6;
        c.insets = new Insets(0, 0, 10, 0);
        panelSignup.add(tfSecondPassword,c );

        bRegister = new JButton("Entrar");
        bRegister.setPreferredSize(new Dimension(50, 30));
        bRegister.setActionCommand(REGISTER_COMMAND);

        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 10;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(20, 220, 0, 0);
        panelSignup.add(bRegister, c);

        bBack = new JButton("<");
        bBack.setActionCommand(BACK_FROM_SIGNUP_COMMAND);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 10;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(20, 0, 0, 220);
        panelSignup.add(bBack, c);

    }

    public JPanel getPanelSignup() {
        return panelSignup;
    }

    /**
     * Creates a label
     * @param font Font to use
     * @return JLabel
     */
    private JLabel createLabel(Font font) {
        JLabel label = new JLabel("Registrar-se.");
        label.setFont(font);
        label.setForeground(UIPalette.TEXT_COLOR.getColor());
        return label;
    }

    public void registerController(ActionListener actionListener) {
        bRegister.addActionListener(actionListener);
    }

    public void backController(ActionListener actionListener) {
        bBack.addActionListener(actionListener);
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
        field.setForeground(UIPalette.TEXT_COLOR.getColor());
        return field;
    }

    /**
     * Creates the button panel
     * @return JPanel with the buttons
     */


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
