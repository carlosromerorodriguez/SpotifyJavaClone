package presentation.view;

import business.BusinessLogicMusic;
import business.BusinessLogicSong;
import com.sun.tools.javac.Main;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import java.awt.*;

public class ViewsController {
    private final CardLayout cardLayout;

    private final JFrame window;

    private final JPanel cardPanelInici;

    private final JPanel panelPrincipal;

    public ViewsController(SignInView signInView, SignUpView signUpView, LogOutView logOutView, WelcomeView welcomeView,
                           AddMusicView addMusicView, ListMusicView listMusicView, DeleteMusicView deleteMusicView,
                           MainMenuView mainMenuView, PlayMusicView playMusicView){


        ImageIcon spotifyIcon = new ImageIcon("data/img/spotify.png");
        this.window = new JFrame("Espotifai");
        this.window.setIconImage(spotifyIcon.getImage());

        cardLayout = new CardLayout();
        cardPanelInici = new JPanel(cardLayout);
        cardPanelInici.add(signInView.getPanelSignIn(), "signIn");
        cardPanelInici.add(signUpView.getPanelSignup(), "signUp");
        cardPanelInici.add(logOutView.ventanaEmergenteLogOut(), "logout");
        cardPanelInici.add(welcomeView.getWelcomePanel(), "welcome");
        cardPanelInici.add(addMusicView.getPanel_add_song(), "addSong");
        cardPanelInici.add(listMusicView.getPanel_list(), "listMusic");
        cardPanelInici.add(deleteMusicView.getPanel_delete_song(), "deleteSong");

        panelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        JPanel panelSuperiorIzquierda = mainMenuView.getMenuPanel();
        panelSuperiorIzquierda.setBackground(UIPalette.COLOR_PRIMARIO_CLARO .getColor());
        JPanel panelSuperiorDerecha = new JPanel();
        panelSuperiorDerecha.setBackground(UIPalette.COLOR_PRIMARIO.getColor());
        JPanel panelInferior = new JPanel();
        panelInferior.setBackground(UIPalette.COLOR_PRIMARIO.getColor());

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.1;
        gbc.weighty = 1.0;
        panelPrincipal.add(panelSuperiorIzquierda, gbc);
        gbc.weightx = 0.9;
        gbc.gridx = 1;
        panelPrincipal.add(panelSuperiorDerecha, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weighty = 0.1;
        panelPrincipal.add(playMusicView.getPanelReproductor(), gbc);
    }

    public void createViewPrincipal(){
        window.add(this.cardPanelInici);
        window.setSize(500, 700);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        cardLayout.show(cardPanelInici, "welcome");
        window.setVisible(true);
    }

    public void createViewAddSong(){

        window.add(this.cardPanelInici);
        window.setSize(500, 700);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        cardLayout.show(cardPanelInici, "addSong");
        window.setVisible(true);
    }

    public void createViewListSong(){
        window.add(this.cardPanelInici);
        window.setSize(500, 700);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        cardLayout.show(cardPanelInici, "listMusic");
        window.setVisible(true);
    }

    public void createViewDeleteSong(){

        window.add(this.cardPanelInici);
        window.setSize(500, 700);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        cardLayout.show(cardPanelInici, "deleteSong");
        window.setVisible(true);
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

    public void setAddMusicView(){cardLayout.show(cardPanelInici, "addSong");}
    public void setDeleteMusicView(){cardLayout.show(cardPanelInici, "deleteSong");}

    public void createViewReproductor(){

        window.add(panelPrincipal);
        window.remove(cardPanelInici);
        window.pack();
        window.setSize(1300, 800);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        cardLayout.show(cardPanelInici, "welcome");
        window.setVisible(true);

    }
}
