public class Config {
    private int port;
    private String ip;
    private String nom;
    private String user;
    private int password;

    public Config(int port, String ip, String nom, String user, int password) {
        this.port = port;
        this.ip = ip;
        this.nom = nom;
        this.user = user;
        this.password = password;
    }

    public int getPort() {
        return port;
    }
}
