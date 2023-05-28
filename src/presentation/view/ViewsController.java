package presentation.view;

import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import java.awt.*;

public class ViewsController {
    private final CardLayout cardLayout;

    private CardLayout mainPanelCardLayout;

    private final JFrame window;

    private final JPanel cardPanelInici;

    private JPanel panelSuperiorDerecha;

    private JPanel panelPrincipal;

    /**
     * Creates the view controller for the views.
     *
     * @param signInView                 Sign-in view.
     * @param signUpView                 Sign-up view.
     * @param logOutView                 Log-out view.
     * @param welcomeView                Welcome to view.
     * @param addMusicView               Add music view.
     * @param listMusicView              List music view.
     * @param deleteMusicView            Delete music view.
     * @param mainMenuView               Main menu view.
     * @param playMusicView              Play music view.
     * @param playlistView               Playlist view.
     * @param musicStatisticsView        Music statistics view.
     * @param showMusicInfoView          Show music info view.
     * @param addPlaylistView            Add playlist view.
     * @param playlistSongsView          Playlist songs view.
     * @param addSongToPlaylistView      Add song to playlist view.
     * @param deletePlaylistView         Delete playlist view.
     * @param deleteSongFromPlaylistView Delete song from playlist view.
     * @param deleteUserView             Delete user view.
     */
    public ViewsController(SignInView signInView, SignUpView signUpView, LogOutView logOutView, WelcomeView welcomeView,
                           AddMusicView addMusicView, ListMusicView listMusicView, DeleteMusicView deleteMusicView,
                           MainMenuView mainMenuView, PlayMusicView playMusicView, PlaylistView playlistView,
                           MusicStatisticsView musicStatisticsView, ShowMusicInfoView showMusicInfoView,
                           AddPlaylistView addPlaylistView, PlaylistSongsView playlistSongsView,
                           AddSongToPlaylistView addSongToPlaylistView, DeletePlaylistView deletePlaylistView,
                           DeleteSongFromPlaylistView deleteSongFromPlaylistView, DeleteUserView deleteUserView) {

        ImageIcon spotifyIcon = new ImageIcon("data/img/spotify.png");
        this.window = new JFrame("Espotifai");
        this.window.setIconImage(spotifyIcon.getImage());

        cardLayout = new CardLayout();
        cardPanelInici = new JPanel(cardLayout);
        cardPanelInici.add(signInView.getPanelSignIn(), "signIn");
        cardPanelInici.add(signUpView.getPanelSignup(), "signUp");
        cardPanelInici.add(welcomeView.getWelcomePanel(), "welcome");

        createMainPanel(mainMenuView, playMusicView, playlistView, listMusicView, logOutView, musicStatisticsView,
                addMusicView, showMusicInfoView, deleteMusicView, addPlaylistView, playlistSongsView,
                addSongToPlaylistView, deletePlaylistView, deleteSongFromPlaylistView, deleteUserView);
    }

    /**
     * Creates the main panel of the view.
     * @param mainMenuView Main menu view.
     * @param playMusicView Play music view.
     * @param playlistView Playlist view.
     * @param listMusicView List music view.
     * @param logOutView Log-out view.
     * @param musicStatisticsView Music statistics view.
     * @param addMusicView Add music view.
     * @param showMusicInfoView Show music info view.
     * @param deleteMusicView Delete music view.
     * @param addPlaylistView Add playlist view.
     * @param playlistSongsView Playlist songs view.
     * @param addSongToPlaylistView Add song to playlist view.
     * @param deletePlaylistView Delete playlist view.
     * @param deleteSongFromPlaylistView Delete song from playlist view.
     * @param deleteUserView Delete user view.
     */
    private void createMainPanel(MainMenuView mainMenuView, PlayMusicView playMusicView, PlaylistView playlistView, ListMusicView listMusicView,
                                 LogOutView logOutView, MusicStatisticsView musicStatisticsView, AddMusicView addMusicView, ShowMusicInfoView showMusicInfoView,
                                 DeleteMusicView deleteMusicView, AddPlaylistView addPlaylistView, PlaylistSongsView playlistSongsView,
                                 AddSongToPlaylistView addSongToPlaylistView, DeletePlaylistView deletePlaylistView, DeleteSongFromPlaylistView deleteSongFromPlaylistView,
                                 DeleteUserView deleteUserView) {

        panelPrincipal = new JPanel(new BorderLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0; // Peso en la dirección X
        gbc.weighty = 1.0; // Peso en la dirección Y

        JPanel panelSuperiorIzquierda = mainMenuView.getMenuPanel();
        panelSuperiorIzquierda.setBackground(UIPalette.COLOR_PRIMARIO_CLARO .getColor());

        JPanel outView = new JPanel();
        outView.setBackground(UIPalette.COLOR_PRIMARIO.getColor());
        outView.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(100, 0, 0, 0);
        outView.add(deleteUserView.getPanelLogOut(), c);
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(70, 0, 100, 0);
        outView.add(logOutView.getContentPane(), c);

        mainPanelCardLayout = new CardLayout();
        panelSuperiorDerecha = new JPanel(mainPanelCardLayout);
        panelSuperiorDerecha.add(playlistView.getContentPane(), "playlist");
        panelSuperiorDerecha.add(listMusicView.getPanelList(), "listMusic");
        panelSuperiorDerecha.add(outView, "logout");
        panelSuperiorDerecha.add(addMusicView.getPanelAddSong(), "addMusic");
        panelSuperiorDerecha.add(deleteMusicView.getPanelDeleteSong(), "deleteSong");
        panelSuperiorDerecha.add(addPlaylistView.getPanelAddSong(), "addPlaylist");
        panelSuperiorDerecha.add(deletePlaylistView.getPanelAddSong(), "deletePlaylist");
        panelSuperiorDerecha.add(showMusicInfoView.getPanelShowSongInfo(), "showMusicInfo");
        panelSuperiorDerecha.add(musicStatisticsView.getContentPane(), "musicStatistics");
        panelSuperiorDerecha.add(playlistSongsView.getPanelList(), "playlistSongs");
        panelSuperiorDerecha.add(addSongToPlaylistView.getPanelList(), "addSongToPlaylist");
        panelSuperiorDerecha.add(deleteSongFromPlaylistView.getPanel(), "deleteSongFromPlaylist");

        mainPanelCardLayout.show(panelSuperiorDerecha, "listMusic");
        panelSuperiorDerecha.setBackground(UIPalette.COLOR_PRIMARIO.getColor());

        panelSuperiorIzquierda.setPreferredSize(new Dimension(400, 700));
        panelPrincipal.add(panelSuperiorIzquierda,BorderLayout.LINE_START);
        panelSuperiorDerecha.setPreferredSize(new Dimension(900, 700));
        panelPrincipal.add(panelSuperiorDerecha, BorderLayout.CENTER);
        JPanel panelInferior = playMusicView.getPanelReproductor();
        panelInferior.setPreferredSize(new Dimension(1300, 100));
        panelPrincipal.add(panelInferior, BorderLayout.PAGE_END);
    }

    /**
     * Cambia la vista del panel principal a la vista de las playlists
     */
    public void setMusicStatisticsView(){
        mainPanelCardLayout.show(panelSuperiorDerecha, "musicStatistics");
    }

    /**
     * Cambia la vista del panel principal a la vista de las playlists
     */
    public void createViewPrincipal(){
        window.add(this.cardPanelInici);
        window.remove(panelPrincipal);
        window.setSize(500, 700);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        cardLayout.show(cardPanelInici, "welcome");
        window.setVisible(true);
    }

    /**
     * Cambia la vista del panel principal a la vista de las playlists
     */
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

    /**
     * Cambia la vista del panel principal a la vista de las playlists
     */
    public void setSignInView(){
        cardLayout.show(cardPanelInici, "signIn");
    }

    /**
     * Cambia la vista del panel principal a la vista de las playlists
     */
    public void setRegisterView(){
        cardLayout.show(cardPanelInici, "signUp");
    }

    /**
     * Cambia la vista del panel principal a la vista de las playlists
     */
    public void setWelcomeView() {
        cardLayout.show(cardPanelInici, "welcome");
    }

    /**
     * Cambia la vista del panel principal a la vista de las playlists
     */
    public void setAddMusicView(){mainPanelCardLayout.show(panelSuperiorDerecha, "addMusic");}

    /**
     * Cambia la vista del panel principal a la vista de las playlists
     */
    public void setDeleteMusicView(){mainPanelCardLayout.show(panelSuperiorDerecha, "deleteSong");}

    /**
     * Cambia la vista del panel principal a la vista de las playlists
     */
    public void setPlaylistView(){
        mainPanelCardLayout.show(panelSuperiorDerecha, "playlist");
    }

    /**
     * Cambia la vista del panel principal a la vista de las playlists
     */
    public void setListMusicView(){
        mainPanelCardLayout.show(panelSuperiorDerecha, "listMusic");
    }

    /**
     * Cambia la vista del panel principal a la vista de las playlists
     */
    public void setAddPlaylistView() {
        mainPanelCardLayout.show(panelSuperiorDerecha, "addPlaylist");
    }

    /**
     * Cambia la vista del panel principal a la vista de las playlists
     */
    public void setDeletePlaylistView() {
        mainPanelCardLayout.show(panelSuperiorDerecha, "deletePlaylist");
    }

    /**
     * Cambia la vista del panel principal a la vista de las playlists
     */
    public void setLogOutView(){
        mainPanelCardLayout.show(panelSuperiorDerecha, "logout");
    }


    /**
     * Cambia la vista del panel principal a la vista de las playlists
     */
    public void showMusicInfo() {
        mainPanelCardLayout.show(panelSuperiorDerecha, "showMusicInfo");
    }

    /**
     *  Cambia la vista del panel principal a la vista de las playlists
     */
    public void setPlaylistSongsView() {
        mainPanelCardLayout.show(panelSuperiorDerecha, "playlistSongs");
    }


    /**
     *  Cambia la vista del panel principal a la vista de las playlists
     */
    public void setAddSongToPlaylistView() {
        mainPanelCardLayout.show(panelSuperiorDerecha, "addSongToPlaylist");
    }

    /**
     *  Cambia la vista del panel principal a la vista de las playlists
     */
    public void setDeleteSongFromPlaylistView() {
        mainPanelCardLayout.show(panelSuperiorDerecha, "deleteSongFromPlaylist");
    }
}
