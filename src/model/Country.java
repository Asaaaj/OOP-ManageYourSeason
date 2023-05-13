package model;

import java.io.Serializable;

/**
 * Trieda Country predstavuje krajinu pretekov.
 */
public class Country implements Serializable {
    private String name;
    private int summerTemperature;
    private int springTemperature;
    private int autumnTemperature;
    private String distanceFromPreviousRace;
    private int distanceFromPreviousRaceInteger;
    private final String region;

    /**
     * Konštruktor pre vytvorenie inštancie krajiny.
     * @param name              názov krajiny
     * @param summerTemperature letná teplota krajiny
     * @param springTemperature jarová teplota krajiny
     * @param autumnTemperature jeseňná teplota krajiny
     * @param region            región, v ktorom sa krajina nachádza
     */
    public Country(String name, int summerTemperature, int springTemperature, int autumnTemperature, String region) {
        this.name = name;
        this.summerTemperature = summerTemperature;
        this.springTemperature = springTemperature;
        this.autumnTemperature = autumnTemperature;
        this.region = region;
    }

    /**
     * Metóda, ktorá vracia región, v ktorom sa krajina nachádza.
     * @return región krajiny
     */
    public String getRegion() {
        return region;
    }

    /**
     * Metóda, ktorá vracia vzdialenosť od predchádzajúceho preteku.
     * @return vzdialenosť od predchádzajúceho preteku
     */
    public String getDistanceFromPreviousRace() {
        return distanceFromPreviousRace;
    }


    /**
     * Metóda, ktorá nastavuje vzdialenosť od predchádzajúcého preteku.
     * @param distanceFromPreviousRace vzdialenosť od predchádzajúcého preteku
     */
    public void setDistanceFromPreviousRace(String distanceFromPreviousRace) {
        this.distanceFromPreviousRace = distanceFromPreviousRace;
    }

    /**
     * Metóda, ktorá nastavuje vzdialenosť od predchádzajúcého preteku ako celé číslo.
     * @param distanceFromPreviousRaceInteger vzdialenosť od predchádzajúcého preteku dátového typu Integer
     */
    public void setDistanceFromPreviousRace(int distanceFromPreviousRaceInteger) {
        this.distanceFromPreviousRaceInteger = distanceFromPreviousRaceInteger;
    }

    /**
     * Metóda, ktorá vracia vzdialenosť od predchádzajúcej preteky ako celé číslo.
     * @return vzdialenosť od predchádzajúcej preteky dátového typu Integer
     */
    public int getDistanceFromPreviousRaceInteger(){
        return distanceFromPreviousRaceInteger;
    }

    /**
     * Metóda, ktorá vracia názov krajiny.
     * @return názov krajiny
     */
    public String getName() {
        return name;
    }

    /**
     * Metóda, ktorá vracia letnú teplotu v krajine.
     * @return letná teplota v krajine
     */
    public int getSummerTemperature() {
        return summerTemperature;
    }

    /**
     * Metóda, ktorá vracia jarnú teplotu v krajine.
     * @return jarná teplota v krajine
     */
    public int getSpringTemperature() {
        return springTemperature;
    }

    /**
     * Metóda, ktorá vracia jesennú teplotu v krajine.
     * @return jesenná teplota v krajine
     */
    public int getAutumnTemperature() {
        return autumnTemperature;
    }
}
