package model;

import model.RaceWeek;

import java.io.Serializable;
import java.util.ArrayList;

public class Season implements Serializable {
    private int numberOfRaces;
    ArrayList<RaceWeek> raceWeeks;
    ArrayList<Country> countries;
    private boolean isStarted = false;
    private int currentRace;

    public Season() {
        currentRace = 1;
        raceWeeks = new ArrayList<>();
        countries = new ArrayList<>();
        countries = loadCountries();
    }

    public int getCurrentRace() {
        return currentRace;
    }

    public void setCurrentRace(int currentRace) {
        this.currentRace = currentRace;
    }

    public int getNumberOfRaces() {
        return numberOfRaces;
    }

    public ArrayList<RaceWeek> getRaceWeeks() {
        return raceWeeks;
    }

    public void setRaceWeeks(ArrayList<RaceWeek> raceWeeks) {
        this.raceWeeks = raceWeeks;
        numberOfRaces = raceWeeks.size();
    }

    public ArrayList<Country> getCountries() {
        return countries;
    }

    public void setCountries(ArrayList<Country> countries) {
        this.countries = countries;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }

    public ArrayList<Country> loadCountries() {
        ArrayList<Country> loadedArray = new ArrayList<>();

        loadedArray.add(new Country("Australia", 15, 25, 23, "Australia"));
        loadedArray.add(new Country("Japan", 23, 10, 14, "EastAsia"));
        loadedArray.add(new Country("Singapore", 28, 28, 28, "WestAsia"));
        loadedArray.add(new Country("Abu Dhabi", 36, 28, 29, "WestAsia"));
        loadedArray.add(new Country("Qatar", 37, 27, 30, "WestAsia"));
        loadedArray.add(new Country("Bahrain", 36, 27, 30, "WestAsia"));
        loadedArray.add(new Country("Saudi Arabia", 33, 29, 30, "WestAsia"));
        loadedArray.add(new Country("Azerbaijan", 26, 13, 17, "WestAsia"));
        loadedArray.add(new Country("Hungary", 22, 12, 12, "Europe"));
        loadedArray.add(new Country("Austria", 17, 12, 8, "Europe"));
        loadedArray.add(new Country("Italy - Emilia-Romagna", 24, 14, 15, "Europe"));
        loadedArray.add(new Country("Italy - Monza", 24, 14, 15, "Europe"));
        loadedArray.add(new Country("Monaco", 22, 15, 15, "Europe"));
        loadedArray.add(new Country("Spain", 23, 12, 15, "Europe"));
        loadedArray.add(new Country("Belgium", 19, 10, 11, "Europe"));
        loadedArray.add(new Country("Netherlands", 19, 10, 11, "Europe"));
        loadedArray.add(new Country("Great Britain", 16, 8, 10, "Europe"));
        loadedArray.add(new Country("Canada", 13, 0, 6, "NorthAmerica"));
        loadedArray.add(new Country("USA - Las Vegas", 33, 21, 23, "NorthAmerica"));
        loadedArray.add(new Country("USA - Texas", 26, 15, 15, "NorthAmerica"));
        loadedArray.add(new Country("USA - Miami", 29, 25, 26, "NorthAmerica"));
        loadedArray.add(new Country("Mexico", 26, 22, 22, "NorthAmerica"));
        loadedArray.add(new Country("Brazil", 24, 26, 27, "SouthAmerica"));

        return loadedArray;
    }

    public void addCountry(Country country) {
        countries.add(country);
    }
}
