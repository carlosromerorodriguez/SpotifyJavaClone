package presentation.controller;

import business.BusinessLogicUser;
import persistance.exceptions.*;
import presentation.view.SignUpView;
import presentation.view.ViewsController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpController implements ActionListener {
    private final SignUpView signUpView;
    private final BusinessLogicUser businessLogicUser;
    private final ViewsController viewsController;

    public SignUpController(SignUpView signUpView, BusinessLogicUser businessLogicUser, ViewsController viewsController) {
        this.signUpView = signUpView;
        this.businessLogicUser = businessLogicUser;
        this.viewsController = viewsController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(SignUpView.REGISTER_COMMAND)) {
            try {
                businessLogicUser.registerUser(signUpView.getEmail(), signUpView.getUsername(), signUpView.getFirstPassword(), signUpView.getSecondPassword());
                signUpView.userRegisteredSuccessfully();
            } catch (PasswordException ex) {
                signUpView.wrongPasswordError();
            } catch (PasswordMismatchException ex) {
                signUpView.passwordsMismatchError();
            } catch (EmailException ex) {
                signUpView.wrongEmailError();
            } catch (UsernameException ex) {
                signUpView.wrongUserError();
            } catch (UserAlreadyExistsException ex) {
                signUpView.userRegistrationFailed();
            }
        }
        if (e.getActionCommand().equals(SignUpView.BACK_FROM_SIGNUP_COMMAND)){
            viewsController.setWelcomeView();
        }
    }
}
