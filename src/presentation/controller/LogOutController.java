package presentation.controller;

import presentation.view.LogOutView;
import presentation.view.ViewsController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogOutController implements ActionListener {
    private final LogOutView logOutView;
    private final ViewsController viewsController;

    public LogOutController(LogOutView logoutView, ViewsController viewsController){
        this.logOutView = logoutView;
        this.viewsController = viewsController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(logOutView.LOGOUT_COMMAND)) {
            viewsController.createViewPrincipal();
        }
    }
}