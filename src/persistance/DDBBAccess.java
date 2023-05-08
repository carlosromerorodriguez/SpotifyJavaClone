package persistance;

import javax.management.MBeanAttributeInfo;
import java.sql.*;

/**
 * The SQLConnector class will abstract the specifics of the connection to a MySQL database.
 *
 * This class follows the Singleton design pattern to facilitate outside access while maintaining
 * a single instance, as having multiple connectors to a database is generally discouraged.
 *
 * Be aware that this class presents a simplified approach. Configuration parameters SHOULD NOT be
 * hardcoded and the use of Statements COULD be replaced by PreparedStatements to avoid SQL Injection.
 */
public class DDBBAccess {

    // MAIN DE PRUEBA PARA TESTEAR LA CONEXIÓN CON LA BASE DE DATOS
    public static void main(String[] args) {
        // Obtén la instancia de DDBBAccess y conecta a la base de datos
        DDBBAccess db = DDBBAccess.getInstance();

        // Insertar un nuevo usuario
        String insertQuery = "INSERT INTO usuario (nom, email, password) VALUES ('John Doe', 'john.doe@example.com', 'password123')";
        db.insertQuery(insertQuery);
        String insertQuery2 = "INSERT INTO usuario (nom, email, password) VALUES ('Aniol Gilipollas', 'aniol.gay@pornhub.com', 'soyaniol')";
        db.insertQuery(insertQuery2);

        // Actualizar un usuario
        String updateQuery = "UPDATE usuario SET nom='Jane Doe', email='jane.doe@example.com' WHERE id=1";
        db.updateQuery(updateQuery);

        // Eliminar un usuario
        String deleteQuery = "DELETE FROM usuario WHERE id=2";
        db.deleteQuery(deleteQuery);

        // Seleccionar todos los usuarios
        String selectQuery = "SELECT * FROM usuario";
        ResultSet resultSet = db.selectQuery(selectQuery);

        // Imprimir los resultados
        try {
            System.out.println("Usuarios:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Nombre: " + resultSet.getString("nom") + ", Email: " + resultSet.getString("email") + ", Contraseña: " + resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Desconectar de la base de datos
        db.disconnect();
    }



    // The static attribute to implement the singleton design pattern.
    private static DDBBAccess instance = null;


    /**
     * Static method that returns the shared instance managed by the singleton.
     *
     * @return The shared SQLConnector instance.
     */
    public static DDBBAccess getInstance(){
        if (instance == null ){
            // NOT a good practice to hardcode connection data! Be aware of this for your project delivery ;)
            instance = new DDBBAccess("root", "", "localhost", 3306, "spotifai_db");
            instance.connect();
        }
        return instance;
    }

    // Attributes to connect to the database.
    private final String username;
    private final String password;
    private final String url;
    private Connection conn;

    // Parametrized constructor
    private DDBBAccess(String username, String password, String ip, int port, String database) {
        this.username = username;
        this.password = password;
        this.url = "jdbc:mysql://" + ip + ":" + port + "/" + database;
    }


    /**
     * Method that starts the inner connection to the database. Ideally, users would disconnect after
     * using the shared instance.
     */
    public void connect() {
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch(SQLException e) {
            System.err.println("Couldn't connect to --> " + url + " (" + e.getMessage() + ")");
        }
    }


    /**
     * Method that executes an insertion query to the connected database.
     *
     * @param query String representation of the query to execute.
     */
    public void insertQuery(String query){
        try {
            Statement s = conn.createStatement();
            s.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println(query);
            System.err.println("Problem when inserting --> " + e.getSQLState() + " (" + e.getMessage() + ")");
        }
    }


    /**
     * Method that executes an update query to the connected database.
     *
     * @param query String representation of the query to execute.
     */
    public void updateQuery(String query){
        try {
            Statement s = conn.createStatement();
            s.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println(query);
            System.err.println("Problema when updating --> " + e.getSQLState() + " (" + e.getMessage() + ")");
        }
    }


    /**
     * Method that executes a deletion query to the connected database.
     *
     * @param query String representation of the query to execute.
     */
    public void deleteQuery(String query){
        try {
            Statement s = conn.createStatement();
            s.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println(query);
            System.err.println("Problem when deleting --> " + e.getSQLState() + " (" + e.getMessage() + ")");
        }

    }


    /**
     * Method that executes a selection query to the connected database.
     *
     * @param query String representation of the query to execute.
     * @return The results of the selection.
     */
    public ResultSet selectQuery(String query){
        ResultSet rs = null;
        try {
            Statement s = conn.createStatement();
            rs = s.executeQuery(query);
        } catch (SQLException e) {
            System.err.println(query);
            System.err.println("Problem when selecting data --> " + e.getSQLState() + " (" + e.getMessage() + ")");
        }
        return rs;
    }


    /**
     * Method that closes the inner connection to the database. Ideally, users would disconnect after
     * using the shared instance.
     */
    public void disconnect(){
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Problem when closing the connection --> " + e.getSQLState() + " (" + e.getMessage() + ")");
        }
    }
}