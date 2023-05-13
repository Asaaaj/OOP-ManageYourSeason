package model;

import controller.AdminControl;
import javax.swing.*;

/**
 * Trieda Administrator reprezentuje administrátora aplikácie.
 */
public class Administrator implements User {
    private static Administrator administrator = null;
    private final String username = "admin";
    private final AdminControl control = new AdminControl();

    /**
     * Vytvorenie inštancie Administrátora.
     * Používa sa návrhový vzor Singleton.
     * @return inštancia Administrátora
     */
    public static Administrator getInstance() {
        if (administrator == null) {
            administrator = new Administrator();
        }
        return administrator;
    }

    /**
     * Metóda, ktorá zobrazuje meno administrátora.
     */
    @Override
    public void displayName() {
        System.out.println(username);
    }

    /**
     * Metóda, ktorá vytvára a vracia panel pre ovládanie administrátorského menu.
     * @return panel pre ovládanie administrátorského menu
     */
    @Override
    public JPanel control() {
        return control.panel();
    }

    /**
     * Metóda, ktorá vracia názov administrátorského menu.
     * @return názov administrátorského menu
     */
    @Override
    public String controlName() {
        return "Administrator Control Menu";
    }
}
