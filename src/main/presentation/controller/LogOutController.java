package src.main.presentation.controller;

import src.main.business.entities.User;

import java.util.ArrayList;

public class LogOutController {
    public static void removeUser(String userToRemove, String password){
        User user = new User();
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
