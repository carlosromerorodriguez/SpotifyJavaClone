import business.BusinessLogicMPlayer;
import business.BusinessLogicMusic;
import business.BusinessLogicSong;
import business.BusinessLogicUser;
import persistance.ConfigDatabaseDAO;
import persistance.DDBBAccess;
import persistance.SongDatabaseDAO;
import persistance.UserDatabaseDAO;
import presentation.controller.*;
import presentation.view.SignUpView;
import presentation.view.WelcomeView;
import presentation.controller.WelcomeController;
import presentation.view.*;

public class Main {
    public static void main(String[] args) {
        // TODO: Esto SIEMPRE es igual, no hay que cambiarlo
        ConfigDatabaseDAO configDatabaseDAO = new ConfigDatabaseDAO("data/config.json");
        DDBBAccess ddBBAccess = new DDBBAccess(configDatabaseDAO);

        // TODO: Esto se puede modificar
        UserDatabaseDAO userDatabaseDAO = new UserDatabaseDAO(ddBBAccess);
        BusinessLogicUser businessLogicUser = new BusinessLogicUser(userDatabaseDAO);
        BusinessLogicMPlayer businessLogicMPlayer = new BusinessLogicMPlayer();
        SongDatabaseDAO songDatabaseDAO = new SongDatabaseDAO(ddBBAccess);
        BusinessLogicSong businessLogicSong = new BusinessLogicSong(songDatabaseDAO);
        BusinessLogicMusic businessLogicMusic = new BusinessLogicMusic(songDatabaseDAO);

        SignUpView signUpView = new SignUpView();
        LogOutView logOutView = new LogOutView();
        SignInView signInView = new SignInView();
        WelcomeView welcomeView = new WelcomeView();
        PlayMusicView playMusicView = new PlayMusicView();
        MainMenuView mainMenuView = new MainMenuView();
        AddMusicView addMusicView = new AddMusicView();
        ListMusicView listMusicView = new ListMusicView(businessLogicMusic);
        DeleteMusicView deleteMusicView = new DeleteMusicView();
        PlaylistView playlistView = new PlaylistView();
        ViewsController viewsController = new ViewsController(signInView, signUpView, logOutView, welcomeView, addMusicView, listMusicView, deleteMusicView, mainMenuView, playMusicView, playlistView);

        LogOutController logOutController = new LogOutController(businessLogicUser);
        SignUpController signUpController = new SignUpController(signUpView, businessLogicUser, viewsController);
        SignInController signInController = new SignInController(signInView, businessLogicUser, viewsController);
        WelcomeController welcomeController = new WelcomeController(welcomeView, businessLogicUser, viewsController);
        PlayMusicController playMusicController = new PlayMusicController(playMusicView, businessLogicMPlayer, viewsController);
        AddMusicController addMusicController = new AddMusicController(businessLogicSong, addMusicView);
        DeleteMusicController deleteMusicController = new DeleteMusicController(deleteMusicView, businessLogicSong);
        MainMenuController mainMenuController = new MainMenuController(mainMenuView, businessLogicUser, viewsController);

        signUpView.registerController(signUpController);
        signUpView.backController(signUpController);
        signInView.logInController(signInController);
        signInView.backController(signInController);
        welcomeView.registerController(welcomeController);
        welcomeView.welcomeController(welcomeController);
        playMusicView.playMusicController(playMusicController);
        addMusicView.addMusicController(addMusicController);
        addMusicView.backSongController(addMusicController);
        deleteMusicView.deleteMusicController(deleteMusicController);
        mainMenuView.setActionListeners(mainMenuController);

        //viewsController.createViewPrincipal();
        //viewsController.createViewAddSong();
        //viewsController.createViewListSong();
        //viewsController.createViewDeleteSong();
        viewsController.createViewReproductor();
    }
}
