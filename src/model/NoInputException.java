package model;

/**
 * Výnimka, ktorá sa vyvoláva v prípade, že nie je zadaný žiadny vstup pre používateľské meno alebo heslo.
 */
public class NoInputException extends Exception{
    /**
     * Konštruktor triedy NoInputException.
     * Vypisuje chybovú správu, že vstup pre používateľské meno alebo heslo je prázdny.
     */
    public NoInputException() {
        System.out.println("Empty Username or Password Input");
    }
}
