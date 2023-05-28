package persistance;

import business.entities.User;

/**
 * User DAO interface
 */
public interface UserDAO {
    /**
     * @param user User to add to database
     * @return true if the user has been added successfully
     */
    boolean addUser(User user);
    /**
     * @param user User name or email to delete from database
     * @return true if the user has been added successfully
     */
    boolean deleteUser(String user, String password);
    /**
     * @param nom User name to delete from database
     * @param password User password to delete
     * @return true if the user has been deleted successfully
     */
    boolean checkUserByName(String nom, String password);
    /**
     * @param email User email to delete from database
     * @param password User password to delete
     * @return true if the user has been deleted successfully
     */
    boolean checkUserByEmail(String email, String password);

    /**
     * @param username Username to write to file
     */
    void writeUserToTxtFile(String username);

    /**
     * @param emailUser Email to get username from database
     */
    void writeUserNameFromEmail(String emailUser);
    /**
     * @return Username from file userInfo
     */
    String getUserNameFromFile();

}
