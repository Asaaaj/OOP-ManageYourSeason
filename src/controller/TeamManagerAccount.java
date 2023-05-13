package controller;

import model.TeamManager;

public class TeamManagerAccount {
    public static TeamManager logIn(String teamName) {
        switch (teamName) {
            case "ferrari" -> {
                return new TeamManager("Ferrari");
            }
            case "redbull" -> {
                return new TeamManager("Red Bull");
            }
            case "mercedes" -> {
                return new TeamManager("Mercedes");
            }
            case "mclaren" -> {
                return new TeamManager("McLaren");
            }
        }
        return null;
    }
}
