package DataLayer;

import java.io.Serializable;

public class User implements Serializable {
    private Roles role;
    private String username;
    private String password;

    public User (Roles role, String username, String password){
        this.role = role;
        this.username = username;
        this.password = password;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {this.username = username;}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
