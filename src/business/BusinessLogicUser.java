package business;

import business.entities.User;
import persistance.UserDAO;
import persistance.exceptions.EmailException;
import persistance.exceptions.PasswordException;
import persistance.exceptions.PasswordMismatchException;
import persistance.exceptions.UsernameException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
            try {
                writeTxtFile(username);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("User added");
        }
    }

    public void deleteUser(String username, String password) throws UsernameException, PasswordException{

        if(userDao.deleteUser(username, password)){

        }

    }

    public boolean loginUser(String email_user, String password) throws UsernameException, PasswordException {
        boolean exists;
        if (email_user.isEmpty() || email_user.isBlank()) { throw new UsernameException(); }
        if (!checkPassword(password)) { throw new PasswordException(); }

        if(email_user.contains("@")){
            exists = userDao.checkUserByEmail(email_user, password);
        }
        else{
            exists = userDao.checkUserByName(email_user, password);
        }
        if (exists) {
            try {
                writeTxtFile(email_user);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        } else { return false; }
    }

    private static String readTxtFile() throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get("data/user/userInfo"))) {
            return lines.collect(Collectors.joining("\n"));
        }
    }

    private void writeTxtFile(String username) throws IOException {
        Files.write(Paths.get("data/user/userInfo"), Collections.singletonList(username), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
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
