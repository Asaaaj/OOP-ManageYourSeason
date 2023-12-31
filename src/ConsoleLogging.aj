import java.util.ArrayList;

import controller.*;
import model.*;
import view.*;

aspect ConsoleLogging {
	before(): execution(* ApplicationControl.checkLoggingIn(String, String)) {
        System.out.println("Checking logging in");
    }
    after(): execution(* ApplicationControl.checkLoggingIn(String, String)) {
        System.out.println("Logged in");
    }
    after(): execution(* ApplicationControl.checkAddRaceInput(String, ArrayList<RaceWeek>, ArrayList<Country>)) {
        System.out.println("Checking Adding Race");
    }
    before() : execution(void StartApplication.main(String[])) && within(StartApplication) {
        System.out.println("Starting application");
      }
}
