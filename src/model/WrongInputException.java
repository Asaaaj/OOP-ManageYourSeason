package model;

/**
 * Výnimka, ktorá sa vyvoláva v prípade, že je zadaný nesprávny vstup pre používateľské meno alebo heslo.
 */
public class WrongInputException extends Exception{
    /**
     * Konštruktor triedy WrongInputException.
     * Vypisuje chybovú správu, že vstup pre používateľské meno alebo heslo je nesprávny.
     */
    public WrongInputException() {
        System.out.println("Wrong Username or Password");
    }
}
