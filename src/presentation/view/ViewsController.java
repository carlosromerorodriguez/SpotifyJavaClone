package presentation.view;

import presentation.view.LogOutView;
import presentation.view.SignInView;
import presentation.view.SignUpView;

import javax.swing.*;
import java.awt.*;

public class ViewsController {

    SignInView signInView;
    SignUpView signUpView;
    LogOutView logOutView;

    WelcomeView welcomeView;

    CardLayout cardLayout;

    JFrame ventana = new JFrame("Spotifai");
    private JPanel cardPanel;

    public ViewsController(SignInView signInView, SignUpView signUpView, LogOutView logOutView, WelcomeView welcomeView){

        this.signInView = signInView;
        this.signUpView = signUpView;
        this.logOutView = logOutView;
        this.welcomeView = welcomeView;

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.add(signInView.getPanel_signin(), "signIn");
        cardPanel.add(signUpView.getPanelSignup(), "signUp");
        cardPanel.add(logOutView.ventanaEmergenteLogOut(), "logut");
        cardPanel.add(welcomeView.getWelcomePanel(), "welcome");
    }

    public void createView(){

        ventana.add(this.cardPanel);
        ventana.setSize(500, 700);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        cardLayout.show(cardPanel, "welcome");
        ventana.setVisible(true);
    }

    public void setSignInView(){
        cardLayout.show(cardPanel, "signIn");
    }

    public void setRegisterView(){
        cardLayout.show(cardPanel, "signUp");
    }

    public void setWelcomeView(){
        cardLayout.show(cardPanel, "welcome");
    }
}
