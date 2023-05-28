package business.entities;

import java.util.UUID;

public class User {
    private UUID id;
    private String user;
    private String email;
    private String password;

    /**
     * Constructor
     * @param user user of the user
     * @param email email of the user
     * @param password password of the user
     */
    public User(String user, String email, String password) {
        this.user = user;
        this.email = email;
        this.password = password;
    }

    /**
     * Constructor
     * @param id id of the user
     * @param user user of the user
     * @param email email of the user
     * @param password password of the user
     */
    public User(UUID id, String user, String email, String password) {
        this.id = id;
        this.user = user;
        this.email = email;
        this.password = password;
    }

    /**
     * Constructor
     * @param user user of the user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Get user of the user
     * @return user of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set password of the user
     * @param password password of the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get user
     * @return user name
     */
    public String getUser() {
        return user;
    }

    /**
     * Get password of the user
     * @return password of the user
     */
    public String getPassword() {
        return password;
    }
}
