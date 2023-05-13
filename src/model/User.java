package model;

import javax.swing.*;

/**
 * Rozhranie pre používateľa.
 */
public interface User {

     /**
      * Metóda na zobrazenie používateľského mena.
      */
     void displayName();

     /**
      * Metóda na získanie ovládacieho panelu pre používateľa.
      * @return Ovládací panel používateľa
      */
     JPanel control();

     /**
      * Metóda na získanie názvu ovládacieho panelu pre používateľa.
      * @return Názov ovládacieho panelu
      */
     String controlName();
}
