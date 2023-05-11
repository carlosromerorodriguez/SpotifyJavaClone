package business;

import business.entities.User;
import persistance.UserDAO;
import persistance.exceptions.EmailException;
import persistance.exceptions.PasswordException;
import persistance.exceptions.PasswordMismatchException;
import persistance.exceptions.UsernameException;

import java.util.UUID;

public class BusinessLogicUser {
    private final UserDAO userDao;

    public BusinessLogicUser(UserDAO userDao) {
        this.userDao = userDao;
    }

    public void registerUser(String email, String username, String firstPassword, String secondPassword) throws EmailException, PasswordException, PasswordMismatchException, UsernameException {
        if (username.isEmpty() || username.isBlank()) { throw new UsernameException(); }
        if (!checkEmail(email)) { throw new EmailException(); }
        if (!checkPassword(firstPassword)) { throw new PasswordException(); }
        if (!checkPasswords(firstPassword, secondPassword)) { throw new PasswordMismatchException(); }

        if (userDao.addUser(new User(UUID.randomUUID(), username, email, firstPassword))) {
            System.out.println("User added");
        }
    }

    public void loginUser(String email_user, String password) throws UsernameException, PasswordException {
        boolean exists = false;
        if (email_user.isEmpty() || email_user.isBlank()) { throw new UsernameException(); }
        if (!checkPassword(password)) { throw new PasswordException(); }

        if(email_user.contains("@")){
            exists = userDao.checkUserByEmail(email_user, password);
        } else {
            exists = userDao.checkUserByName(email_user, password);
        }

        if(exists){
            System.out.println("User exists");
        }
        else{
            System.out.println("User does not exist");
        }
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
}
