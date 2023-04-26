package model;

import javax.swing.*;

public interface User {
     void displayName();
     void logIn();
     void logOut();
     JPanel control();
     String controlName();
}
