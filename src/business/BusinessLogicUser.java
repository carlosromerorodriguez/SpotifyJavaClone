package business;

import business.entities.User;
import persistance.UserDAO;
import persistance.exceptions.*;

import java.io.IOException;

public class BusinessLogicUser {
    private final UserDAO userDao;

    public BusinessLogicUser(UserDAO userDao) {
        this.userDao = userDao;
    }

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

    public void loginUser(String email_user, String password) throws UsernameException, PasswordException, IOException {
        validateInput(email_user, password);
    }

    private void validateInput(String email_user, String password) throws UsernameException, PasswordException {
        if (email_user == null || email_user.trim().isEmpty() || !checkUserExists(email_user, password)) {
            throw new UsernameException();
        }

        if (!checkPassword(password)) {
            throw new PasswordException();
        }

    }

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

    public boolean deleteUser(String passwordText) {
        return userDao.deleteUser(userDao.getUserNameFromFile(), passwordText);
    }

    public void cleanUserInfoFile() {
        userDao.writeUserToTxtFile("");
    }
}
