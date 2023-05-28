package presentation.controller;

import presentation.view.LogOutView;
import presentation.view.ViewsController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Log out controller class
 */
public class LogOutController implements ActionListener {
    private final LogOutView logOutView;
    private final ViewsController viewsController;

    /**
     * Log out controller
     * @param logoutView log out view
     * @param viewsController views controller
     */
    public LogOutController(LogOutView logoutView, ViewsController viewsController){
        this.logOutView = logoutView;
        this.viewsController = viewsController;
    }

    /**
     * Action performed
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(logOutView.LOGOUT_COMMAND)) {
            viewsController.createViewPrincipal();
        }
    }
}