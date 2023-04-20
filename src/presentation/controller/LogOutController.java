package presentation.controller;

import business.entities.User;

import java.util.ArrayList;

public class LogOutController {
    public static void removeUser(String userToRemove, String password){
        User user = new User(null, null, null, null);
        ArrayList<User> arrayUser = new ArrayList<>();
        for (User u : arrayUser) {
            if(u.getUser().equals(userToRemove) && u.getPassword().equals(password)){
                user = u;
            }
        }
        // para que no se te queje de que estás modificando el array dinamico
        arrayUser.remove(user);
    }
}
