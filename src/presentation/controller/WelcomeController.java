package presentation.controller;

import business.BusinessLogicUser;
import presentation.view.WelcomeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeController implements ActionListener {

    WelcomeView welcomeView;

    BusinessLogicUser businessLogicUser;

    WelcomeController(WelcomeView welcomeView, BusinessLogicUser businessLogicUser){
        this.welcomeView = welcomeView;
        this.businessLogicUser = businessLogicUser;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
