package presentation.controller;

import business.BusinessLogicUser;
import presentation.view.DeleteUserView;
import presentation.view.ViewsController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteUserController implements ActionListener {
    private final BusinessLogicUser businessLogicUser;
    private final DeleteUserView deleteUserView;
    private final ViewsController viewsController;

    /**
     * Delete user controller
     * @param businessLogicUser
     * @param deleteUserView
     * @param viewsController
     */
    public DeleteUserController(BusinessLogicUser businessLogicUser, DeleteUserView deleteUserView, ViewsController viewsController){
        this.businessLogicUser = businessLogicUser;
        this.deleteUserView = deleteUserView;
        this.viewsController = viewsController;
    }

    /**
     * Action performed
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(deleteUserView.DELETE_COMMAND)) {
            if (businessLogicUser.deleteUser(deleteUserView.getPasswordText())) {
                deleteUserView.successfulDelete();
                viewsController.createViewPrincipal();
            } else {
                deleteUserView.setErrorMessage();
            }
        }
    }
}
