package presentation.controller;

import business.BusinessLogicUser;
import presentation.view.ViewsController;
import presentation.view.WelcomeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeController implements ActionListener {

    private WelcomeView welcomeView;

    private ViewsController viewsController;

    BusinessLogicUser businessLogicUser;

    public WelcomeController(WelcomeView welcomeView, BusinessLogicUser businessLogicUser, ViewsController viewsController){
        this.welcomeView = welcomeView;
        this.businessLogicUser = businessLogicUser;
        this.viewsController = viewsController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(welcomeView.REGISTER_VIEW_COMMAND)){
            viewsController.setRegisterView();
        } else if (e.getActionCommand().equals(welcomeView.SIGNUP_VIEW_COMMAND)) {
            viewsController.setSignInView();
        }
    }
}
