package controller;

import model.TeamManager;

/**
 * Trieda TeamManagerAccount poskytuje metódu na prihlásenie manažéra tímu.
 */
public class TeamManagerAccount {

    /**
     * Metóda na prihlásenie manažéra tímu na základe názvu tímu.
     * @param teamName názov tímu
     * @return inštancia TeamManager pre daný názov tímu, alebo null, ak názov tímu nie je platný
     */
    public static TeamManager logIn(String teamName) {
        switch (teamName) {
            case "ferrari" -> {
                return new TeamManager("Ferrari");
            }
            case "redbull" -> {
                return new TeamManager("Red Bull");
            }
            case "mercedes" -> {
                return new TeamManager("Mercedes");
            }
            case "mclaren" -> {
                return new TeamManager("McLaren");
            }
        }
        return null;
    }
}
