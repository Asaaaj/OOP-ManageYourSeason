package controller;

import model.Country;

import java.util.ArrayList;

public class DistanceControl1 extends Thread{
    private int distance = 0;

    public int getDistance() {
        return distance;
    }

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
