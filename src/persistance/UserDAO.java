package persistance;

import business.entities.User;

public interface UserDAO {
    boolean addUser(User user);
    User getUser(String userName, String pwd);
    boolean deleteUser(String user);
    Boolean existsUser(String username);
    boolean existsEmail(String email);
}
