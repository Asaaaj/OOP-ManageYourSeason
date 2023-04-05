package model;

import model.RaceWeek;

import java.util.ArrayList;

public class Season {
    private int numberOfRaces;
    ArrayList<RaceWeek> raceWeeks;
    ArrayList<Country> countries;
    private boolean isStarted = false;

    public Season() {
        raceWeeks = new ArrayList<>();
        countries = new ArrayList<>();
        countries = loadCountries();
    }

    public ArrayList<RaceWeek> getRaceWeeks() {
        return raceWeeks;
    }

    public void setRaceWeeks(ArrayList<RaceWeek> raceWeeks) {
        this.raceWeeks = raceWeeks;
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

        loadedArray.add(new Country("Bahrain", 37, 30, 30));
        loadedArray.add(new Country("Saudi Arabia", 37, 30, 30));
        loadedArray.add(new Country("Australia", 37, 30, 30));
        loadedArray.add(new Country("Azerbaijan", 37, 30, 30));
        loadedArray.add(new Country("USA - Miami", 37, 30, 30));
        loadedArray.add(new Country("Italy - Emilia-Romagna", 37, 30, 30));
        loadedArray.add(new Country("Monaco", 37, 30, 30));
        loadedArray.add(new Country("Spain", 37, 30, 30));
        loadedArray.add(new Country("Canada", 37, 30, 30));
        loadedArray.add(new Country("Austria", 37, 30, 30));
        loadedArray.add(new Country("Great Britain", 37, 30, 30));
        loadedArray.add(new Country("Hungary", 37, 30, 30));
        loadedArray.add(new Country("Belgium", 37, 30, 30));
        loadedArray.add(new Country("Netherlands", 37, 30, 30));
        loadedArray.add(new Country("Italy - Monza", 37, 30, 30));
        loadedArray.add(new Country("Singapore", 37, 30, 30));
        loadedArray.add(new Country("Japan", 37, 30, 30));
        loadedArray.add(new Country("Qatar", 37, 30, 30));
        loadedArray.add(new Country("USA - Texas", 37, 30, 30));
        loadedArray.add(new Country("Mexico", 37, 30, 30));
        loadedArray.add(new Country("Brazil", 37, 30, 30));
        loadedArray.add(new Country("USA - Las Vegas", 37, 30, 30));
        loadedArray.add(new Country("Abu Dhabi", 37, 30, 30));

        return loadedArray;
    }
}
