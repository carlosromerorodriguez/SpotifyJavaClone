package presentation.controller;

import business.BusinessLogicUser;
import business.entities.User;
import presentation.view.LogoutView;
import presentation.view.ViewsController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LogOutController implements ActionListener {


    BusinessLogicUser businessLogicUser;

    LogoutView logoutView;

    ViewsController viewsController;

    public LogOutController(BusinessLogicUser businessLogicUser, LogoutView logoutView, ViewsController viewsController){
        this.businessLogicUser = businessLogicUser;
        this.logoutView = logoutView;
        this.viewsController = viewsController;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(logoutView.LOGOUT_COMMAND)){
            viewsController.closeWindow();
        }
    }
}
