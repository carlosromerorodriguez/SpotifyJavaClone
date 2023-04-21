package persistance;

import business.entities.User;
import persistance.exceptions.MaxConnectionsReachedException;

import java.sql.ResultSet;
import java.sql.SQLException;

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
     *
     * @param user User to add
     * @return true if the user has been added successfully
     */
    @Override
    public boolean addUser(User user) {
        if (this.existsUser(user.getUser()) != null) {
            return false; // User already exists or error
        }

        try {
            Integer id = this.addNewUserAndReturnNewId(user.getUser());
            if (id == null) {
                return false; // Error while adding user
            }
            String query = "INSERT INTO usuario(id, user_name, user_email, user_password) VALUES (?,?,md5(?),1,1)"; // md5 => encrypt password PostgreeSQL
            return (this.ddbbAccess.runQuery(query, id, user.getEmail(), user.getPassword()) > 0);
        } catch (SQLException | MaxConnectionsReachedException ex) {
            return false;
        }
    }

    /**
     * Adds a new user to the database and returns the new id
     * @param username Username to add
     * @return New id
     */
    private synchronized Integer addNewUserAndReturnNewId(String username) {
        try {
            if (this.ddbbAccess.runQuery("INSERT INTO usuario(user_name) VALUES (?);", username) > 0) {
                ResultSet resultSet = this.ddbbAccess.getQuery("SELECT MAX(id) FROM usuario WHERE user_name = ?;", username);
                return resultSet.next() ? resultSet.getInt(1) : null;
            }
        } catch (SQLException ignored) { } catch (MaxConnectionsReachedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public User getUser(String userName, String pwd) {
        return null;
    }

    @Override
    public boolean deleteUser(String user) {
        return false;
    }

    @Override
    public Boolean existsUser(String username) {
        try {
            ResultSet resultSet = this.ddbbAccess.getQuery("SELECT user_name FROM usuario WHERE username = ?;", username);
            if (!resultSet.next()) {
                return false; // no existing user in database
            }
            return (resultSet.getInt(1) > 0);
        } catch (SQLException | MaxConnectionsReachedException ex) {
            return null;
        }
    }

    @Override
    public Boolean existsEmail(String email) {
        try {
            ResultSet resultSet = this.ddbbAccess.getQuery("SELECT user_mail FROM usuario WHERE email = ?;", email);
            if (!resultSet.next()) {
                return false; // no existing user in database
            }
            return (resultSet.getInt(1) > 0);
        } catch (SQLException | MaxConnectionsReachedException ex) {
            return null;
        }
    }

    @Override
    public Boolean checkCombination(String email_user, String password){
        try {
            ResultSet resultSet = this.ddbbAccess.getQuery("SELECT * FROM user WHERE user_name = " + email_user +" AND user_password = "+ password);
            if (!resultSet.next()) {
                return false; // no existing user in database
            }
            return (resultSet.getInt(1) > 0);
        } catch (SQLException | MaxConnectionsReachedException ex) {
            return null;
        }
    }
}
