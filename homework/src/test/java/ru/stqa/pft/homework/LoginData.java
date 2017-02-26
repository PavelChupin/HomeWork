package ru.stqa.pft.homework;

public class LoginData {
    private final String password;
    private final String username;

    public LoginData(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}