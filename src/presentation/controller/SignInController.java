package presentation.controller;

import business.BusinessLogicUser;
import persistance.exceptions.EmailException;
import persistance.exceptions.PasswordException;
import persistance.exceptions.PasswordMismatchException;
import persistance.exceptions.UsernameException;
import presentation.view.SignInView;
import presentation.view.ViewsController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInController implements ActionListener {

    BusinessLogicUser businessLogicUser;

    ViewsController viewsController;

    SignInView signInView;

    public SignInController(SignInView signInView, BusinessLogicUser businessLogicUser, ViewsController viewsController){
        this.signInView = signInView;
        this.businessLogicUser = businessLogicUser;
        this.viewsController = viewsController;
    }

    public void signInButtonPressed(String nom_correu, char[] password) {
        //businessLogicUser.loginUser(nom_correu, password.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(signInView.LOGIN_COMMAND)) {
            try {
                if(businessLogicUser.loginUser(signInView.getLoginUserMail(), signInView.getLoginUserPassword())){
                    System.out.println("Login correcte");
                    viewsController.createViewReproductor();
                }
            } catch (UsernameException ex) {
                throw new RuntimeException(ex);
            } catch (PasswordException ex) {
                throw new RuntimeException(ex);
            }
        }
        if(e.getActionCommand().equals(signInView.BACK_FROM_SIGNIN)){
            viewsController.setWelcomeView();
        }
    }

}
