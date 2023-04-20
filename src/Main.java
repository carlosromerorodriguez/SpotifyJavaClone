import business.BusinessLogicUser;
import business.entities.DDBBInfo;
import persistance.DDBBAccess;
import persistance.UserDAO;
import persistance.UserDatabaseDAO;
import presentation.controller.LogOutController;
import presentation.controller.SignUpController;
import presentation.view.SignUpView;
import presentation.view.Utilities.TemplateField;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        SignUpView signUpView = new SignUpView(new SignUpController(new BusinessLogicUser(new UserDatabaseDAO(new DDBBAccess(new DDBBInfo(20, null, null, null, null), 2)))));
        JPanel jPanel = signUpView.windowSignUp();
        JFrame jFrame = new JFrame();
        jFrame.add(jPanel);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
