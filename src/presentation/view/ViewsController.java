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

    PlayMusicView playMusicView;

    CardLayout cardLayout;

    JFrame ventana = new JFrame("Spotifai");

    private JPanel cardPanelInici;

    private JPanel panelPrincipal;

    public ViewsController(SignInView signInView, SignUpView signUpView, LogOutView logOutView, WelcomeView welcomeView
    , PlayMusicView playMusicView){

        ImageIcon imagenIcono = new ImageIcon("src/img/spotify.png");

        ventana.setIconImage(imagenIcono.getImage());
        this.signInView = signInView;
        this.signUpView = signUpView;
        this.logOutView = logOutView;
        this.welcomeView = welcomeView;
        this.playMusicView = playMusicView;

        cardLayout = new CardLayout();
        cardPanelInici = new JPanel(cardLayout);
        cardPanelInici.add(signInView.getPanel_signin(), "signIn");
        cardPanelInici.add(signUpView.getPanelSignup(), "signUp");
        cardPanelInici.add(logOutView.ventanaEmergenteLogOut(), "logout");
        cardPanelInici.add(welcomeView.getWelcomePanel(), "welcome");

        panelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        JPanel panelSuperiorIzquierda = new JPanel();
        panelSuperiorIzquierda.setBackground(Color.BLUE);
        JPanel panelSuperiorDerecha = new JPanel();
        panelSuperiorDerecha.setBackground(Color.RED);
        JPanel panelInferior = new JPanel();
        panelInferior.setBackground(Color.GREEN);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.3;
        gbc.weighty = 1.0;
        panelPrincipal.add(panelSuperiorIzquierda, gbc);
        gbc.weightx = 0.7;
        gbc.gridx = 1;
        panelPrincipal.add(panelSuperiorDerecha, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weighty = 0.2;
        panelPrincipal.add(playMusicView.getPanel_reproductor(), gbc);
    }

    public void createViewPrincipal(){

        ventana.add(this.cardPanelInici);
        ventana.setSize(500, 700);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        cardLayout.show(cardPanelInici, "welcome");
        ventana.setVisible(true);
    }

    public void setSignInView(){
        cardLayout.show(cardPanelInici, "signIn");
    }

    public void setRegisterView(){
        cardLayout.show(cardPanelInici, "signUp");
    }

    public void setWelcomeView(){
        cardLayout.show(cardPanelInici, "welcome");
    }

    public void createViewReproductor(){

        ventana.add(panelPrincipal);
        ventana.remove(cardPanelInici);
        ventana.pack();
        ventana.setSize(1300, 800);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        cardLayout.show(cardPanelInici, "welcome");
        ventana.setVisible(true);

    }
}
