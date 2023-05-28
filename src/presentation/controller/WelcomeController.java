package presentation.controller;

import business.BusinessLogicUser;
import presentation.view.ViewsController;
import presentation.view.WelcomeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeController implements ActionListener {
    private final ViewsController viewsController;

    public WelcomeController(ViewsController viewsController){
        this.viewsController = viewsController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(WelcomeView.REGISTER_VIEW_COMMAND)){
            viewsController.setRegisterView();
        } else if (e.getActionCommand().equals(WelcomeView.SIGNUP_VIEW_COMMAND)) {
            viewsController.setSignInView();
        }
    }
}
