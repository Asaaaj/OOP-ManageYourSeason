package model;

import java.io.Serializable;

/**
 * Trieda predstavujúca týždeň pretekov.
 * Obsahuje informácie o krajine a teplote pretekov.
 */
public class RaceWeek implements Serializable {
    private Country country;
    private int raceTemperature;

    /**
     * Konštruktor pre triedu RaceWeek.
     * @param country Krajina, v ktorej sa preteky konajú
     * @param raceTemperature Teplota pretekov
     */
    public RaceWeek(Country country, int raceTemperature) {
        this.country = country;
        this.raceTemperature = raceTemperature;
    }

    /**
     * Metóda na získanie krajiny, v ktorej sa preteky konajú.
     * @return Krajina pretekov
     */
    public Country getCountry() {
        return country;
    }

    /**
     * Metóda na získanie teploty pretekov v danom týždni.
     * @return Teplota pretekov
     */
    public int getRaceTemperature() {
        return raceTemperature;
    }
}
