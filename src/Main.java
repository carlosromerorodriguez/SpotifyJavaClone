import business.BusinessLogicUser;
import persistance.ConfigDatabaseDAO;
import persistance.DDBBAccess;
import persistance.UserDatabaseDAO;
import persistance.exceptions.ConfigFileNotFoundException;
import presentation.controller.SignUpController;
import presentation.view.ErrorHandler;
import presentation.view.SignUpView;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            // TODO: Esto SIEMPRE es igual, no hay que cambiarlo
            ConfigDatabaseDAO configDatabaseDAO = new ConfigDatabaseDAO("data/config.json");
            DDBBAccess ddBBAccess = new DDBBAccess(configDatabaseDAO.readConfigJson(), 5);

            // TODO: Esto se puede modificar
            UserDatabaseDAO userDatabaseDAO = new UserDatabaseDAO(ddBBAccess);
            BusinessLogicUser businessLogicUser = new BusinessLogicUser(userDatabaseDAO);

            SignUpView signUpView = new SignUpView();
            SignUpController signUpController = new SignUpController(signUpView, businessLogicUser);
            signUpView.registerController(signUpController);

            // TODO: Hacer la view creada visible
            signUpView.setVisible(true);
        } catch (SQLException e) {
            ErrorHandler.showErrorOnScreen("SQL error", "SQL ERROR");
        } catch (ConfigFileNotFoundException e) {
            ErrorHandler.showErrorOnScreen("Config file not found", "CONFIG FILE ERROR");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
