package model;

import controller.TeamManagerControl;

import javax.swing.*;
import java.io.Serializable;

public class TeamManager implements User, Serializable {
    private Team team;
    private String username = "teammanager";
    private TeamManagerControl control = new TeamManagerControl(this);

    public TeamManager(String teamName) {
        this.team = new Team(teamName);
    }

    @Override
    public void displayName() {
        System.out.println(username);
    }
    @Override
    public JPanel control() {
        return control.panel();
    }

    @Override
    public String controlName() {
        return "Team Manager Control Menu";
    }

    public Team getTeam() {
        return team;
    }
}
