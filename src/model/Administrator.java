package model;

import controller.AdminControl;

import javax.swing.*;

public class Administrator implements User {
    private static Administrator administrator = null;
    private String name;
    private final String username = "admin";
    private String login;
    private String password = "1111";
    private final AdminControl control = new AdminControl();

    //SINGLETON
    public static Administrator getInstance() {
        if (administrator == null) {
            administrator = new Administrator();
        }
        return administrator;
    }

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
    public JPanel control() {
        return control.panel();
    }

    @Override
    public String controlName() {
        return "Administrator Control Menu";
    }
}
