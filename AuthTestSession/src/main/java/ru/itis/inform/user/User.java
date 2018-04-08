package ru.itis.inform.user;

/**
 * Created by artur on 13.11.16.
 */
public class User {

    private String username = "admin";
    private String password = "qwerty";

    public boolean identify(String username, String password) {
        return (username.equals(this.username) && password.equals(this.password));
    }
}
