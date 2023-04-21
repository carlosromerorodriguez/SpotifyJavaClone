package presentation.controller;

import business.BusinessLogicUser;
import persistance.exceptions.EmailException;
import persistance.exceptions.PasswordException;
import persistance.exceptions.PasswordMismatchException;
import persistance.exceptions.UsernameException;
import presentation.view.SignUpView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpController implements ActionListener {
    private SignUpView signUpView;
    private BusinessLogicUser businessLogicUser;
    public SignUpController(SignUpView signUpView, BusinessLogicUser businessLogicUser) {
        this.signUpView = signUpView;
        this.businessLogicUser = businessLogicUser;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(signUpView.REGISTER_COMMAND)) {
            try {
                businessLogicUser.registerUser(signUpView.getEmail(), signUpView.getUsername(), signUpView.getFirstPassword(), signUpView.getSecondPassword());
            } catch (PasswordException ex) {
                signUpView.wrongPasswordError();
            } catch (PasswordMismatchException ex) {
                signUpView.passwordsMismatchError();
            } catch (EmailException ex) {
                signUpView.wrongEmailError();
            } catch (UsernameException ex) {
                signUpView.wrongUserError();
            }
        }
    }
}
