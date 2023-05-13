package controller;

import model.Country;
import java.util.ArrayList;

/**
 * Trieda DistanceControl1 je vlákno pre výpočet vzdialenosti medzi dvoma krajinami na základe zoznamu regiónov.
 */
public class DistanceControl1 extends Thread{
    private int distance = 0;

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
        for (int i = regions.indexOf(prevCountry.getRegion()); i < regions.size(); i++) {
            if (nextCountry.getRegion().equals(regions.get(i))) {
                break;
            }
            else {
                distance++;
            }

            if(i == regions.size()-1) {
                i = -1;
            }
        }
    }
}
