package model;

import controller.AdminControl;

import javax.swing.*;

public class Administrator implements User {
    private String name;
    private final String username = "admin";
    private String login;
    private String password = "1111";
    private final AdminControl control = new AdminControl();


    @Override
    public void displayName() {
        System.out.println(username);
    }

    @Override
    public void logIn() {

    }

    @Override
    public void logOut() {

    }

    @Override
    public JPanel control(JPanel logInPanel) {
        return control.panel(logInPanel);
    }

    @Override
    public String controlName() {
        return "Administrator Control Menu";
    }
}
