package presentation.controller;

import business.BusinessLogicUser;

public class SignInController {

    BusinessLogicUser businessLogicUser;

    public SignInController(BusinessLogicUser businessLogicUser){
        this.businessLogicUser = businessLogicUser;
    }

    public void signInButtonPressed(String nom_correu, char[] password) {
        businessLogicUser.loginUser(nom_correu, password.toString());
    }

}
