package persistance;

import business.entities.User;

public interface UserDAO {
    boolean addUser(User user);
    boolean checkUserByName(String nom, String password);

    boolean checkUserByEmail(String email, String password);
}
