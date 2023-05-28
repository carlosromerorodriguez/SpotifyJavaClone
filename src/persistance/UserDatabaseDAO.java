package persistance;

import business.entities.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

public class UserDatabaseDAO implements UserDAO {
    private final DDBBAccess ddbbAccess;

    /**
     * Constructor
     * @param ddbbAccess Database access
     */
    public UserDatabaseDAO(DDBBAccess ddbbAccess) {
        this.ddbbAccess = ddbbAccess;
    }

    /**
     * @param userName User name or email to delete from database
     * @return true if the user has been added successfully
     */
    @Override
    public boolean deleteUser(String userName, String password) {
        String query = "DELETE FROM usuario WHERE (nom = ?) AND password = ?";
        try {
            PreparedStatement statement = ddbbAccess.getConnection().prepareStatement(query);
            statement.setString(1, userName);
            statement.setString(2, password);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar el usuario: " + e.getMessage());
        }
        return false;
    }

    /**
     * @param user User email or name to add to database
     * @return true if the user has been added successfully
     */
    public boolean addUser(User user) {
        String query = "INSERT INTO usuario(email, nom, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = ddbbAccess.getConnection().prepareStatement(query);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getUser());
            statement.setString(3, user.getPassword());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al insertar el usuario: " + e.getMessage());
        }
        return false;
    }

    /**
     * @param nom User name to delete
     * @param password User password to delete
     * @return true if the user has been deleted successfully
     */
    public boolean checkUserByName(String nom, String password) {
        String query = "SELECT * FROM usuario WHERE nom = ? AND password = ?";
        try {
            PreparedStatement statement = ddbbAccess.getConnection().prepareStatement(query);
            statement.setString(1, nom);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error al comprobar el usuario: " + e.getMessage());
        }
        return false;
    }

    /**
     * @param email Email to check
     * @param password Password to check
     * @return true if the user exists
     */
    public boolean checkUserByEmail(String email, String password){
        String query = "SELECT * FROM usuario WHERE email = ? AND password = ?";
        try {
            PreparedStatement statement = ddbbAccess.getConnection().prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error al comprobar el usuario: " + e.getMessage());
        }
        return false;
    }

    @Override
    public void writeUserToTxtFile(String username) {
        try {
            Files.write(Paths.get("data/user/userInfo"), Collections.singletonList(username), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.out.println("Error al escribir el usuario en el fichero: " + e.getMessage());
        }
    }

    @Override
    public void writeUserNameFromEmail(String emailUser) {
        String query = "SELECT nom FROM usuario WHERE email = ?";
        try {
            PreparedStatement statement = ddbbAccess.getConnection().prepareStatement(query);
            statement.setString(1, emailUser);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                writeUserToTxtFile(rs.getString("nom"));
            }
        } catch (SQLException e) {
            System.err.println("Error al comprobar el usuario: " + e.getMessage());
        }
    }

    @Override
    public String getUserNameFromFile() {
        try {
            return Files.readAllLines(Paths.get("data/user/userInfo")).get(0);
        } catch (IOException e) {
            System.out.println("Error al leer el usuario del fichero: " + e.getMessage());
        }
        return "";
    }
}
