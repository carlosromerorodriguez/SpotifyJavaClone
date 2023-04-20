import business.BusinessLogicUser;
import business.entities.DDBBInfo;
import persistance.DDBBAccess;
import persistance.UserDAO;
import persistance.UserDatabaseDAO;
import presentation.controller.LogOutController;
import presentation.controller.SignInController;
import presentation.controller.SignUpController;
import presentation.controller.ViewsController;
import presentation.view.LogOutView;
import presentation.view.SignInView;
import presentation.view.SignUpView;
import presentation.view.Utilities.TemplateField;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        SignUpView signUpView = new SignUpView(new SignUpController(new BusinessLogicUser(new UserDatabaseDAO(new DDBBAccess(new DDBBInfo(20, null, null, null, null), 2)))));
        SignInView signInView = new SignInView(new SignInController(new BusinessLogicUser(new UserDatabaseDAO(new DDBBAccess(new DDBBInfo(20, null, null, null, null), 2)))));
        LogOutView logOutView = new LogOutView(new LogOutController(new BusinessLogicUser(new UserDatabaseDAO(new DDBBAccess(new DDBBInfo(20, null, null, null, null), 2)))));

        /*JPanel jPanel = signUpView.windowSignUp();
        JFrame jFrame = new JFrame();
        jFrame.add(jPanel);
        jFrame.pack();
        jFrame.setVisible(true);
         */

        ViewsController viewsController = new ViewsController(signInView, signUpView, logOutView);
        viewsController.createView();
    }
}
