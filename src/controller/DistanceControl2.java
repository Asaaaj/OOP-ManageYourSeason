package controller;

import model.Country;
import java.util.ArrayList;

public class DistanceControl2 extends Thread{
    int distance;

    /**
     * Metóda vráti vzdialenosť medzi krajinami.
     * @return vzdialenosť medzi krajinami
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Metóda pre výpočet vzdialenosti medzi dvoma krajinami na základe zoznamu regiónov.
     * @param regions      zoznam regiónov
     * @param prevCountry  predchádzajúca krajina
     * @param nextCountry  nasledujúca krajina
     */
    public void run(ArrayList<String> regions, Country prevCountry, Country nextCountry) {
        for (int i = regions.indexOf(prevCountry.getRegion()); i >= 0; i--) {
            if (nextCountry.getRegion().equals(regions.get(i))) {
                break;
            }
            else {
                distance++;
            }

            if(i == 0) {
                i = regions.size();
            }
        }
    }
}
