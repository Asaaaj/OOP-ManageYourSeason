package view;


/**
 * Rozhranie Application definuje spoločné metódy pre aplikáciu.
 */
public interface Application {

    /**
     * Metóda start inicializuje aplikáciu.
     */
    default void start() {
        Object frame = logInFrame();   
    }

    /**
     * Metóda logInFrame vytvára a vracia JFrame pre prihlásenie.
     * @return objekt frame pre prihlásenie
     */
    Object logInFrame();
}
