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
import java.io.IOException;

public class SignInController implements ActionListener {
    private final BusinessLogicUser businessLogicUser;

    private final ViewsController viewsController;

    private final SignInView signInView;

    public SignInController(SignInView signInView, BusinessLogicUser businessLogicUser, ViewsController viewsController){
        this.signInView = signInView;
        this.businessLogicUser = businessLogicUser;
        this.viewsController = viewsController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(SignInView.LOGIN_COMMAND)) {
            try {
                businessLogicUser.loginUser(signInView.getLoginUserMail(), signInView.getLoginUserPassword());
                viewsController.createViewReproductor();
            } catch (UsernameException ex) {
                signInView.showUsernameError();
            } catch (PasswordException ex) {
                signInView.showPasswordError();
            } catch (IOException ex) {
                signInView.showIOError();
            }
        }
        if (e.getActionCommand().equals(SignInView.BACK_FROM_SIGNIN)){
            viewsController.setWelcomeView();
        }
    }

}
