package model;

import controller.TeamManagerControl;
import javax.swing.*;
import java.io.Serializable;

/**
 * Trieda reprezentujúca manažéra tímu.
 */
public class TeamManager implements User, Serializable {
    private Team team;
    private String username = "teammanager";
    private TeamManagerControl control = new TeamManagerControl(this);

    /**
     * Konštruktor pre vytvorenie manažéra tímu s daným názvom tímu.
     * @param teamName Názov tímu
     */
    public TeamManager(String teamName) {
        this.team = new Team(teamName);
    }

    /**
     * Metóda na zobrazenie používateľského mena manažéra tímu.
     */
    @Override
    public void displayName() {
        System.out.println(username);
    }

    /**
     * Metóda na získanie ovládacieho panelu pre manažéra tímu.
     * @return Ovládací panel manažéra tímu
     */
    @Override
    public JPanel control() {
        return control.panel();
    }

    /**
     * Metóda na získanie názvu ovládacieho panelu pre manažéra tímu.
     * @return Názov ovládacieho panelu
     */
    @Override
    public String controlName() {
        return "Team Manager Control Menu";
    }

    /**
     * Metóda na získanie tímu.
     * @return Tím
     */
    public Team getTeam() {
        return team;
    }
}
