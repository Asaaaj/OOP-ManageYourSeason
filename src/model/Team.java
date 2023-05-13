package model;

import java.io.Serializable;

/**
 Trieda reprezentujúca tím.
 */
public class Team implements Serializable {
    private String name;

    /**
     Konštruktor pre vytvorenie tímu s daným názvom.
     @param teamName Názov tímu
     */
    public Team(String teamName) {
        name = teamName;
    }

    /**
     * Metóda na získanie názvu tímu.
     * @return Názov tímu
     */
    public String getName() {
        return name;
    }
}
