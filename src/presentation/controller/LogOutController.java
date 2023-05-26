package presentation.controller;

import business.BusinessLogicUser;
import presentation.view.LogOutView;
import presentation.view.ViewsController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogOutController implements ActionListener {
    BusinessLogicUser businessLogicUser;
    LogOutView logoutView;
    ViewsController viewsController;

    public LogOutController(BusinessLogicUser businessLogicUser, LogOutView logoutView, ViewsController viewsController){
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