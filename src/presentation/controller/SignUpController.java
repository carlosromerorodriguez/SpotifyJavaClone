package presentation.controller;

import business.BusinessLogicUser;

public class SignUpController {
    BusinessLogicUser businessLogicUser;

    public SignUpController(BusinessLogicUser businessLogicUser) {
        this.businessLogicUser = businessLogicUser;
    }

    public void registerButtonPressed(String email, String username, String password) {
        businessLogicUser.registerUser(email, username, password);
    }
}
