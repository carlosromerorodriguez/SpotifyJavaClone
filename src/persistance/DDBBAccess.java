package persistance;

import java.sql.*;

public class DDBBAccess {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String IP = "localhost";
    private static final int PORT = 3306;
    private static final String DATABASE = "spotifai_db";
    private static final String URL = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;

    private static DDBBAccess instance = null;
    private Connection conn;

    public DDBBAccess() {
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Couldn't connect to --> " + URL + " (" + e.getMessage() + ")");
        }
    }

    public static DDBBAccess getInstance() {
        if (instance == null) {
            instance = new DDBBAccess();
        }
        return instance;
    }

    public void insertQuery(String query) {
        try (Statement statement = conn.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println(query);
            System.err.println("Problem when inserting --> " + e.getSQLState() + " (" + e.getMessage() + ")");
        }
    }

    public void updateQuery(String query) {
        try (Statement statement = conn.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println(query);
            System.err.println("Problem when updating --> " + e.getSQLState() + " (" + e.getMessage() + ")");
        }
    }

    public void deleteQuery(String query) {
        try (Statement statement = conn.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println(query);
            System.err.println("Problem when deleting --> " + e.getSQLState() + " (" + e.getMessage() + ")");
        }
    }

    public ResultSet selectQuery(String query) {
        ResultSet rs = null;
        try (Statement statement = conn.createStatement()) {
            rs = statement.executeQuery(query);
        } catch (SQLException e) {
            System.err.println(query);
            System.err.println("Problem when selecting data --> " + e.getSQLState() + " (" + e.getMessage() + ")");
        }
        return rs;
    }

    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Problem when closing the connection --> " + e.getSQLState() + " (" + e.getMessage() + ")");
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public boolean isConnected() {
        try {
            return conn != null && !conn.isClosed();
        } catch (SQLException e) {
            System.err.println("Error al verificar el estado de la conexión: " + e.getMessage());
            return false;
        }
    }

}
