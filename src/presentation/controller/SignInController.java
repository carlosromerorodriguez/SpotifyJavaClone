package presentation.controller;

import main.persistance.UserDAO;
import main.persistance.UserDatabaseDAO;

public class SignInController {



    public static void signInButtonPressed(String nom_correu, char[] password) {
    }

    private static boolean checkIfMailUser(String nom_correu){

        if(nom_correu.contains("@")){
            return true;
        }
        else{
            return false;
        }
    }
}
