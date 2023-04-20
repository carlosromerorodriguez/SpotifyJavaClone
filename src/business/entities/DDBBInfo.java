package business.entities;

public class DDBBInfo {
    private final int port;
    private final String ip;
    private final String name;
    private final String user;
    private final String password;

    public DDBBInfo(int port, String ip, String name, String user, String password) {
        this.port = port;
        this.ip = ip;
        this.name = name;
        this.user = user;
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public String getUser() {
        return this.user;
    }

    public String getPassword() {
        return this.password;
    }

    public String getHost() {
        return this.ip + ":" + this.port;
    }
}
