package presentation.controller;

import presentation.view.LogOutView;
import presentation.view.SignInView;
import presentation.view.SignUpView;

import javax.swing.*;
import java.awt.*;

public class ViewsController {

    SignInView signInView;
    SignUpView signUpView;
    LogOutView logOutView;

    JFrame ventana = new JFrame("Spotifai");

    public ViewsController(SignInView signInView, SignUpView signUpView, LogOutView logOutView){
        this.signInView = signInView;
        this.signUpView = signUpView;
        this.logOutView = logOutView;
    }

    public void createView(){

        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        cardPanel.add(signInView.ventanaSignIn(), "signIn");
        cardPanel.add(signUpView.windowSignUp(), "signUp");
        cardPanel.add(logOutView.ventanaEmergenteLogOut(), "logut");

        cardLayout.next(cardPanel);

        ventana.add(cardPanel);
        ventana.setSize(500, 700);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
