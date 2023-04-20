package persistance;

import business.entities.DDBBInfo;
import persistance.exceptions.MaxConnectionsReachedException;
import org.jetbrains.annotations.NotNull;

import java.sql.*;

public class DDBBAccess {
    /*  Descargar el driver aquí: "https://jdbc.postgresql.org/download/"
        Descargar el driver para Java 8
        Se añade de la siguiente manera al proyecto:

        1. Open your IntelliJ IDEA project and select "File" from the menu bar.
        2. Select "Project Structure" from the drop-down menu.
        3. In the Project Structure dialog box, select "Modules" from the left-hand menu.
        4. Select your module from the list of modules on the right-hand side.
        5. Select the "Dependencies" tab.
        6. Click the "+" button at the bottom of the window and select "JARs or directories".
        7. Navigate to the directory where you saved the JDBC driver JAR file and select it.
        8. Click "OK" to close the dialog box.
     */
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://";
    private final Connection[] connections;
    private final boolean[] connectionsInUse;

    public DDBBAccess(DDBBInfo ddbbInfo, int maxConnections) throws SQLException, ClassNotFoundException {
        //Class.forName(DRIVER);
        this.connections = new Connection[maxConnections];
        this.connectionsInUse = new boolean[maxConnections];

        for (int i = 0; i < this.connections.length; i++) {
           // this.connections[i] = DriverManager.getConnection(String.format(URL + ddbbInfo.getHost() + "/" + ddbbInfo.getName() + ddbbInfo.getUser() + ddbbInfo.getPassword()));
            this.connectionsInUse[i] = false;
        }
    }

    private synchronized int getAvailableConnectionHandler() throws MaxConnectionsReachedException {
        for (int i = 0; i < this.connectionsInUse.length; i++) {
            if (!this.connectionsInUse[i]) {
                this.connectionsInUse[i] = true;
                return i;
            }
        }
        throw new MaxConnectionsReachedException();
    }

    private synchronized void releaseConnectionHandler(int connectionId) {
        this.connectionsInUse[connectionId] = false;
    }

    public int runQuery(String sql, Object @NotNull ... params) throws SQLException, MaxConnectionsReachedException {
        int connectionId = this.getAvailableConnectionHandler();
        int i = 0;

        try {
            PreparedStatement preparedStatement = this.connections[connectionId].prepareStatement(sql);
            for (i = 0; i < params.length; i++) { preparedStatement.setObject(i+1, params[i]); }
            i = preparedStatement.executeUpdate();
            preparedStatement.close();
            this.releaseConnectionHandler(connectionId);
            return i;
        } catch (SQLException e) {
            this.releaseConnectionHandler(connectionId);
            throw e;
        }
    }

    public ResultSet getQuery(String sql, Object @NotNull ... params) throws SQLException, MaxConnectionsReachedException {
        int connectionId = this.getAvailableConnectionHandler();
        int i = 0;

        try {
            PreparedStatement preparedStatement = this.connections[connectionId].prepareStatement(sql);
            for (i = 0; i < params.length; i++) preparedStatement.setObject(i + 1, params[i]);
            ResultSet resultSet = preparedStatement.executeQuery();
            preparedStatement.close();
            this.releaseConnectionHandler(connectionId);
            return resultSet;
        } catch (SQLException e) {
            this.releaseConnectionHandler(connectionId);
            throw e;
        }
    }
}
