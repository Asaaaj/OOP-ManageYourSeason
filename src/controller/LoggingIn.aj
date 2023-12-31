package controller;

public aspect LoggingIn {
	before(): execution(* ApplicationControl.checkLoggingIn(String, String)) {
        System.out.println("Checking logging in");
    }
    after(): execution(* ApplicationControl.checkLogIn(String, String)) {
        System.out.println("Logged in");
    }
    after(): execution(* ApplicationControl.checkAddRaceInput(String, ArrayList<RaceWeek>, ArrayList<Country>)) {
        System.out.println("Checking Adding Race");
    }
}
