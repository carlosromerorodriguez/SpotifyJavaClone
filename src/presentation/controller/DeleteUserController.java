package presentation.controller;

import business.BusinessLogicUser;
import business.entities.User;
import persistance.exceptions.PasswordException;
import persistance.exceptions.UsernameException;
import presentation.view.DeleteUserView;
import presentation.view.ViewsController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteUserController implements ActionListener {


    private BusinessLogicUser businessLogicUser;
    private DeleteUserView deleteUserView;
    private ViewsController viewsController;

    public DeleteUserController(BusinessLogicUser businessLogicUser, DeleteUserView deleteUserView, ViewsController viewsController){
        this.businessLogicUser = businessLogicUser;
        this.deleteUserView = deleteUserView;
        this.viewsController = viewsController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(deleteUserView.DELETE_COMMAND)){
            try {
                businessLogicUser.deleteUser(deleteUserView.getUserText(), deleteUserView.getPasswordText());
            } catch (UsernameException | PasswordException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
