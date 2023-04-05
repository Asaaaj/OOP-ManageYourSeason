package model;

public class Country {
    private String name;
    private int summerTemperature;
    private int springTemperature;
    private int autumnTemperature;
    private int distanceFromPreviousRace;

    public Country(String name, int summerTemperature, int springTemperature, int autumnTemperature) {
        this.name = name;
        this.summerTemperature = summerTemperature;
        this.springTemperature = springTemperature;
        this.autumnTemperature = autumnTemperature;
    }

    public int getDistanceFromPreviousRace() {
        return distanceFromPreviousRace;
    }

    public void setDistanceFromPreviousRace(int distanceFromPreviousRace) {
        this.distanceFromPreviousRace = distanceFromPreviousRace;
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
