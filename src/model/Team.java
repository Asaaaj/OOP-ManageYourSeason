package model;

import java.io.Serializable;

public class Team implements Serializable {
    private String name;
    private String racer1;
    private String racer2;

    public Team(String teamName) {
        name = teamName;
    }
    public String getName() {
        return name;
    }
}
