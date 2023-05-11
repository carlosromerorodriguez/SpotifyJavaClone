import business.BusinessLogicUser;
import persistance.ConfigDatabaseDAO;
import persistance.DDBBAccess;
import persistance.UserDatabaseDAO;
import persistance.exceptions.ConfigFileNotFoundException;
import presentation.controller.*;
import presentation.view.ErrorHandler;
import presentation.view.SignUpView;
import presentation.view.WelcomeView;
import presentation.controller.WelcomeController;
import presentation.view.*;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // TODO: Esto SIEMPRE es igual, no hay que cambiarlo
        ConfigDatabaseDAO configDatabaseDAO = new ConfigDatabaseDAO("data/config.json");
        DDBBAccess ddBBAccess = new DDBBAccess();

        // TODO: Esto se puede modificar
        UserDatabaseDAO userDatabaseDAO = new UserDatabaseDAO(ddBBAccess);
        BusinessLogicUser businessLogicUser = new BusinessLogicUser(userDatabaseDAO);

        SignUpView signUpView = new SignUpView();
        LogOutView logOutView = new LogOutView();
        SignInView signInView = new SignInView();
        WelcomeView welcomeView = new WelcomeView();
        PlayMusicView playMusicView = new PlayMusicView();
        ViewsController viewsController = new ViewsController(signInView, signUpView, logOutView, welcomeView, playMusicView);

        //LogOutController logOutController = new LogOutController(businessLogicUser);
        SignUpController signUpController = new SignUpController(signUpView, businessLogicUser, viewsController);
        SignInController signInController = new SignInController(signInView, businessLogicUser, viewsController);
        WelcomeController welcomeController = new WelcomeController(welcomeView, businessLogicUser, viewsController);
        PlayMusicController playMusicController = new PlayMusicController(playMusicView, businessLogicUser, viewsController);

        signUpView.registerController(signUpController);
        signUpView.backController(signUpController);
        signInView.registerController(signInController);
        signInView.backController(signInController);
        welcomeView.registerController(welcomeController);
        welcomeView.signinController(welcomeController);
        playMusicView.addController(playMusicController);

        viewsController.createViewPrincipal();
    }
}
