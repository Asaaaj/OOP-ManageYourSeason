package model;

import controller.TeamManagerControl;

import javax.swing.*;

public class TeamManager implements User {
    private String teamName;
    private String username = "teammanager";
    private String password = "1111";
    private TeamManagerControl control = new TeamManagerControl();

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

    public void sendRequest() {
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
