package model;

import java.io.Serializable;

public class Country implements Serializable {
    private String name;
    private int summerTemperature;
    private int springTemperature;
    private int autumnTemperature;
    private String distanceFromPreviousRace;
    private int distanceFromPreviousRaceInteger;
    private final String region;

    public Country(String name, int summerTemperature, int springTemperature, int autumnTemperature, String region) {
        this.name = name;
        this.summerTemperature = summerTemperature;
        this.springTemperature = springTemperature;
        this.autumnTemperature = autumnTemperature;
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public String getDistanceFromPreviousRace() {
        return distanceFromPreviousRace;
    }

    public void setDistanceFromPreviousRace(String distanceFromPreviousRace) {
        this.distanceFromPreviousRace = distanceFromPreviousRace;
    }

    public void setDistanceFromPreviousRace(int distanceFromPreviousRaceInteger) {
        this.distanceFromPreviousRaceInteger = distanceFromPreviousRaceInteger;
    }

    public int getDistanceFromPreviousRaceInteger(){
        return distanceFromPreviousRaceInteger;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSummerTemperature() {
        return summerTemperature;
    }

    public void setSummerTemperature(int summerTemperature) {
        this.summerTemperature = summerTemperature;
    }

    public int getSpringTemperature() {
        return springTemperature;
    }

    public void setSpringTemperature(int springTemperature) {
        this.springTemperature = springTemperature;
    }

    public int getAutumnTemperature() {
        return autumnTemperature;
    }

    public void setAutumnTemperature(int autumnTemperature) {
        this.autumnTemperature = autumnTemperature;
    }
}
