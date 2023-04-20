package main.persistance;

import src.main.business.entities.User;

public class UserDatabaseDAO implements UserDAO {
    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public User getUser(String userName, String pwd) {
        return null;
    }

    @Override
    public boolean deleteUser(String user) {
        return false;
    }

    @Override
    public boolean existsUser(String user) {
        return false;
    }

    @Override
    public boolean existsEmail(String email) {
        return false;
    }

    @Override
    public User getUserMail(String email, String pwd) {
        return null;
    }
}
