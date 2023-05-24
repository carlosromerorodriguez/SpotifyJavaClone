package persistance;

import business.entities.User;
/**
 * User DAO interface
 */
public interface UserDAO {
    /**
     * @param user User to add
     * @return true if the user has been added successfully
     */
    boolean addUser(User user);

    boolean deleteUser(String user, String password);
    /**
     * @param nom User name to delete
     * @param password User password to delete
     * @return true if the user has been deleted successfully
     */
    boolean checkUserByName(String nom, String password);
    /**
     * @param email User email to delete
     * @param password User password to delete
     * @return true if the user has been deleted successfully
     */
    boolean checkUserByEmail(String email, String password);
}
