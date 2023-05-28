package presentation.controller;

import business.BusinessLogicUser;
import presentation.view.ViewsController;
import presentation.view.WelcomeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeController implements ActionListener {
    private final ViewsController viewsController;

    /**
     * Welcome controller
     * @param viewsController views controller
     */
    public WelcomeController(ViewsController viewsController){
        this.viewsController = viewsController;
    }

    /**
     * Action performed
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(WelcomeView.REGISTER_VIEW_COMMAND)){
            viewsController.setRegisterView();
        } else if (e.getActionCommand().equals(WelcomeView.SIGNUP_VIEW_COMMAND)) {
            viewsController.setSignInView();
        }
    }
}
