package business;

import business.entities.User;
import persistance.UserDAO;

import java.util.UUID;

public class BusinessLogicUser {
    private final UserDAO userDao;

    public BusinessLogicUser(UserDAO userDao) {
        this.userDao = userDao;
    }

    public void registerUser(String correu, String usuari, String password) {
        userDao.addUser(new User(UUID.randomUUID(), usuari, correu, password));
    }

    public void loginUser(String email_user, String password){
        if(userDao.existsUser(email_user) || userDao.existsEmail(email_user)){
            if(userDao.checkCombination(email_user, password)){
                System.out.println("User exists");
            }
        }
    }
}
