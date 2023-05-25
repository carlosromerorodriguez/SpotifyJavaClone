package business.entities;

import java.util.UUID;

public class User {
    private UUID id;
    private String user;
    private String email;
    private String password;

    public User(String user, String email, String password) {
        this.user = user;
        this.email = email;
        this.password = password;
    }

    public User(UUID id, String user, String email, String password) {
        this.id = id;
        this.user = user;
        this.email = email;
        this.password = password;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
