package main.persistance;

import main.business.entities.User;

public interface UserDAO {
    boolean addUser(User user);
    User getUser(String userName, String pwd);
    boolean deleteUser(String user);
    boolean existsUser(String user);
    boolean existsEmail(String email);
}
