package controller;

import model.Country;

import java.util.ArrayList;

public class DistanceControl2 extends Thread{
    int distance;
    public int getDistance() {
        return distance;
    }

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
