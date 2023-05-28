package business.entities;

public class DDBBInfo {
    private final int port;
    private final String ip;
    private final String name;
    private final String user;
    private final String password;

    /**
     * Constructor
     * @param port port of the database server
     * @param ip ip of the database server
     * @param name name of the database server
     * @param user user of the database server
     * @param password password of the database server
     */
    public DDBBInfo(int port, String ip, String name, String user, String password) {
        this.port = port;
        this.ip = ip;
        this.name = name;
        this.user = user;
        this.password = password;
    }

    /**
     * Get name of the database server
     * @return name of the database server
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get user of the database server
     * @return user of the database server
     */
    public String getUser() {
        return this.user;
    }

    /**
     * Get password of the database server
     * @return password of the database server
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Get host of the database server
     * @return host of the database server
     */
    public String getHost() {
        return this.ip + ":" + this.port;
    }
}
