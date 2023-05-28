package persistance;

import business.entities.DDBBInfo;
import persistance.exceptions.ConfigFileNotFoundException;

import java.io.IOException;
import java.sql.*;
import java.util.HashMap;

public class DDBBAccess {
    private static String USERNAME;
    private static String PASSWORD;
    private static String URL;
    private Connection conn;

    /**
     * Constructor
     * @param configDatabaseDAO Database access
     */
    public DDBBAccess(ConfigDatabaseDAO configDatabaseDAO) {
        try {
            getInfoFromConfig(configDatabaseDAO);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException | ConfigFileNotFoundException | IOException e) {
            System.err.println("Couldn't connect to --> " + URL + " (" + e.getMessage() + ")");
        }
    }

    private void getInfoFromConfig(ConfigDatabaseDAO configDatabaseDAO) throws ConfigFileNotFoundException, IOException {
        DDBBInfo ddbbInfo = configDatabaseDAO.readConfigJson();
        USERNAME = ddbbInfo.getUser();
        PASSWORD = ddbbInfo.getPassword();
        URL = "jdbc:mysql://" + ddbbInfo.getHost() + "/" + ddbbInfo.getName();
    }

    /**
     * get the connection
     * @return Connection
     */
    public Connection getConnection() {
        return conn;
    }
}
