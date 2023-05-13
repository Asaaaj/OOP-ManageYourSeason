package controller;

import model.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Tato trieda obsahuje metody na riadenie aplikacie.
 */
public class ApplicationControl {
    /**
     * Metoda overujuca prihlasovacie udaje
     * @param usernameInput prihlasovacie meno
     * @param passwordInput heslo
     * @return vrati prihlaseneho uzivatela, ak je prihlasenie uspesne
     * @throws NoInputException    vynimka, ak chyba vstupne meno alebo heslo
     * @throws WrongInputException vynimka, ak su zadane nespravne údaje
     */
    public static User checkLoggingIn(String usernameInput, String passwordInput) throws NoInputException, WrongInputException {
        if (usernameInput.equals("") || passwordInput.equals("")) throw new NoInputException();
        else {
            if(usernameInput.equals("admin") && passwordInput.equals("1111")){
                return Administrator.getInstance();
            }
            else if(usernameInput.equals("ferrari") && passwordInput.equals("1111") ) return TeamManagerAccount.logIn("ferrari");
            else if(usernameInput.equals("redbull") && passwordInput.equals("1111") ) return TeamManagerAccount.logIn("redbull");
            else if(usernameInput.equals("mercedes") && passwordInput.equals("1111") ) return TeamManagerAccount.logIn("mercedes");
            else if(usernameInput.equals("mclaren") && passwordInput.equals("1111") ) return TeamManagerAccount.logIn("mclaren");
            else throw new WrongInputException();
        }
    }

    /**
     * Skontroluje a prida novy pretek do sezony.
     * @param raceName  nazov krajiny
     * @param season    aktualna sezona
     * @param countries zoznam dostupnych krajin
     * @return aktualizovana sezona pretekov s pridanym pretekom
     */
    public static ArrayList<RaceWeek> checkAddRaceInput(String raceName, ArrayList<RaceWeek> season, ArrayList<Country> countries) {
        RaceWeek newRace;
        for (Country country : countries) {
            if (raceName.equals(country.getName())) {
                if (season.size() < 8) {
                    newRace = new RaceWeek(country, country.getSpringTemperature());
                }
                else if (season.size() < 17) {
                    newRace = new RaceWeek(country, country.getSummerTemperature());
                }
                else {
                    newRace = new RaceWeek(country, country.getAutumnTemperature());
                }
                season.add(newRace);
                break;
            }
        }
        return season;
    }

    /**
     * Odstrani pridanu krajinu zo zoznamu krajin.
     * @param raceName  nazov krajiny
     * @param countries zoznam krajin
     * @return aktualizovany zoznam krajin
     */
    public static ArrayList<Country> removeAddedCountry(String raceName, ArrayList<Country> countries) {
        int countryPosition = 0;
        for (Country country : countries) {
            if (raceName.equals(country.getName())) {
                break;
            }
            else {
                countryPosition++;
            }
        }
        if (countryPosition < countries.size()) countries.remove(countryPosition);
        return countries;
    }

    /**
     * Vypocita vzdialenost medzi dvoma krajinami na zaklade predchadzajucej krajiny.
     * @param prevCountry predchadzajuca krajina
     * @param nextCountry nasledujuca krajina
     * @return vzdialenost medzi krajinami
     */
    public static int distanceFromPreviousRace(Country prevCountry, Country nextCountry) {
        if(prevCountry == null) return 0;
        ArrayList<String> regions = new ArrayList<>();
        regions.add("Australia");
        regions.add("EastAsia");
        regions.add("WestAsia");
        regions.add("Europe");
        regions.add("NorthAmerica");
        regions.add("SouthAmerica");

        //THREADS TO GET DISTANCE BETWEEN COUNTRIES
        DistanceControl1 thread1 = new DistanceControl1();
        DistanceControl2 thread2 = new DistanceControl2();

        thread1.run(regions, prevCountry, nextCountry);
        thread2.run(regions, prevCountry, nextCountry);

        return Math.min(thread1.getDistance(), thread2.getDistance());
    }

    /**
     * Odstrani pretek zo sezony na zaklade nazvu krajiny.
     * @param season        aktualna sezona
     * @param removeCountry nazov krajiny na odstranenie
     * @return aktualizovana sezona pretekov
     */
    public static ArrayList<RaceWeek> removeRace(Season season, String removeCountry) {
        int index = 0;
        for (RaceWeek raceWeek : season.getRaceWeeks()) {
            if (Objects.equals(removeCountry, raceWeek.getCountry().getName()) && season.getCurrentRace()-1 <= season.getRaceWeeks().indexOf(raceWeek)) {
                season.getRaceWeeks().remove(index);
                return season.getRaceWeeks();
            }
            index++;
        }
        return season.getRaceWeeks();
    }
}
