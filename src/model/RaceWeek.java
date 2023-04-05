package model;

import model.Country;

public class RaceWeek {
    private Country country;
    private int raceTemperature;
    private int idealRaceTemperature;

    public RaceWeek(Country country, int raceTemperature) {
        this.country = country;
        this.raceTemperature = raceTemperature;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public int getRaceTemperature() {
        return raceTemperature;
    }

    public void setRaceTemperature(int raceTemperature) {
        this.raceTemperature = raceTemperature;
    }

    public int getIdealRaceTemperature() {
        return idealRaceTemperature;
    }

    public void setIdealRaceTemperature(int idealRaceTemperature) {
        this.idealRaceTemperature = idealRaceTemperature;
    }
}
