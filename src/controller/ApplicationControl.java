package controller;

import model.Administrator;
import model.TeamManager;
import model.User;

public class ApplicationControl {
    public static User checkLogIn(String usernameInput, String passwordInput) {
        if(usernameInput.equals("admin") && passwordInput.equals("1111")){
            System.out.println("spravne");
            return new Administrator();
        }
        else return new TeamManager();
    }
}
