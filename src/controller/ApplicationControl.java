package controller;

import model.*;

import java.util.ArrayList;

public class ApplicationControl {
    public static User checkLogIn(String usernameInput, String passwordInput) {
        if(usernameInput.equals("admin") && passwordInput.equals("1111")){
            return new Administrator();
        }
        else return new TeamManager();
    }

    public static ArrayList<RaceWeek> checkAddRaceInput(String raceName, ArrayList<RaceWeek> season, ArrayList<Country> countries) {
        for (Country country : countries) {
            if (raceName.equals(country.getName())) {
                RaceWeek newRace = new RaceWeek(country, country.getSummerTemperature());
                season.add(newRace);
                break;
            }
        }
        return season;
    }
}
