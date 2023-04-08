package controller;

import model.*;

import java.util.ArrayList;

public class ApplicationControl {
    public static User checkLogIn(String usernameInput, String passwordInput) {
        if(usernameInput.equals("admin") && passwordInput.equals("1111")){
            return Administrator.getInstance();
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

    public static ArrayList<Country> removeAddedCountry(String raceName, ArrayList<Country> countries) {
        int countryPosition = 0;
        for (Country country : countries) {
            if (raceName.equals(country.getName())) {
                break;
            }
            else {
                countryPosition++;
            }
        }
        if (countryPosition < countries.size()) countries.remove(countryPosition);
        return countries;
    }
}
