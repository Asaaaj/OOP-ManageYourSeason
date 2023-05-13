import view.ApplicationFrame;

/**
 * Hlavna trieda pre spustenie aplikacie.
 * @author Adam Jurčišin
 */
public class StartApplication {
    /**
     * Hlavná metoda, ktora spusta aplikaciu.
     * @param args zoznam argumentov prikazového riadku
     */
    public static void main(String[] args) {
        ApplicationFrame applicationFrame = new ApplicationFrame();
        applicationFrame.start();
    }
}