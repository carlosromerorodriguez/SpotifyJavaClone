package business;

import business.entities.User;
import persistance.UserDAO;
import persistance.exceptions.*;

import java.io.IOException;

public class BusinessLogicUser {
    private final UserDAO userDao;

    /**
     * Constructor
     * @param userDao User DAO
     */
    public BusinessLogicUser(UserDAO userDao) {
        this.userDao = userDao;
    }

    /**
     * Register
     * @param email Correo electronico
     * @param username Nombre de usuario
     * @param firstPassword Primera contraseña
     * @param secondPassword Segunda contraseña
     * @return True if the user is registered
     *
     * @throws EmailException exception for email
     * @throws PasswordException exception for password
     * @throws PasswordMismatchException exception for password mismatch
     * @throws UsernameException exception for username
     * @throws UserAlreadyExistsException exception for user already exists
     */
    public boolean registerUser(String email, String username, String firstPassword, String secondPassword) throws EmailException, PasswordException, PasswordMismatchException, UsernameException, UserAlreadyExistsException {
        if (username.isEmpty() || username.isBlank()) { throw new UsernameException(); }
        if (!checkEmail(email)) { throw new EmailException(); }
        if (!checkPassword(firstPassword)) { throw new PasswordException(); }
        if (!checkPasswords(firstPassword, secondPassword)) { throw new PasswordMismatchException(); }

        if (this.checkUserExists(username, firstPassword) || this.checkUserExists(email, firstPassword)) {
            throw new UserAlreadyExistsException();
        }

        if (userDao.addUser(new User(username, email, firstPassword))) {
            userDao.writeUserToTxtFile(username);
            return true;
        }
        return false;
    }

    /**
     * Login
     * @param email_user User name or email
     * @param password User password
     * @throws UsernameException exception for username
     * @throws PasswordException exception for password
     * @throws IOException exception for input/output
     */
    public void loginUser(String email_user, String password) throws UsernameException, PasswordException, IOException {
        validateInput(email_user, password);
    }

    /**
     * Checks the inputs of the user
     * @param email_user User name or email
     * @param password User password
     * @throws UsernameException exception for username
     * @throws PasswordException exception for password
     */
    private void validateInput(String email_user, String password) throws UsernameException, PasswordException {
        if (email_user == null || email_user.trim().isEmpty() || !checkUserExists(email_user, password)) {
            throw new UsernameException();
        }

        if (!checkPassword(password)) {
            throw new PasswordException();
        }

    }

    /**
     * Checks if the user exists
     * @param s User name or email
     * @param password User password
     * @return True if the user exists
     */
    private boolean checkUserExists(String s, String password) {
        if (s.contains("@")) {
            if (userDao.checkUserByEmail(s, password)) {
                userDao.writeUserNameFromEmail(s);
                return true;
            }
        } else {
            if (userDao.checkUserByName(s, password)) {
                userDao.writeUserToTxtFile(s);
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the email input by the user complies with the requirements
     * @return True if the email complies with the format specifications
     */
    private boolean checkEmail(String email) {
        return (email != null &&
                email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"));
    }

    /**
     * Checks if the password is valid
     * @return True if the password complies with MIT password policies
     */
    private boolean checkPassword(String password) {
        return !password.equals("") &&
                password.matches("(^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$)");
    }

    /**
     * Checks if both passwords are equal
     * @return True if they are equal
     */
    private boolean checkPasswords(String firstPassword, String secondPassword) {
        return (firstPassword.equals(secondPassword));
    }

    /**
     * Deletes the user
     * @param passwordText Password of the user
     * @return True if the user has been deleted successfully
     */
    public boolean deleteUser(String passwordText) {
        return userDao.deleteUser(userDao.getUserNameFromFile(), passwordText);
    }

    /**
     * Deletes the user info file
     */
    public void cleanUserInfoFile() {
        userDao.writeUserToTxtFile("");
    }
}
