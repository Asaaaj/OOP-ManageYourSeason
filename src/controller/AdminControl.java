package controller;

import model.Country;
import model.RaceWeek;
import model.Season;
import view.AdminView;
import view.ApplicationFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AdminControl {
    private AdminView adminView = new AdminView();
    private Season season;

    public Season startSeason(){
        return null;

    }

    public RaceWeek addRace() {
        return null;
    }

    public Season cancelRace() {
        return null;
    }

    public RaceWeek changeDate() {
        return null;
    }

    public JPanel panel() {
        JPanel panel = new JPanel(new GridLayout(6, 3));
        JLabel title = new JLabel("Administrator", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.PLAIN, 40));
        JButton addRaceButton = new JButton("Add race");
        JButton startSeasonButton = new JButton("Start season");
        JButton cancelRaceButton = new JButton("Cancel race");
        JButton changeDateButton = new JButton("Change date");
        JButton logOutButton = new JButton("Log out");
        panel.add(title, BorderLayout.CENTER);
        panel.add(addRaceButton, BorderLayout.CENTER);
        panel.add(changeDateButton, BorderLayout.CENTER);
        panel.add(cancelRaceButton, BorderLayout.CENTER);
        panel.add(startSeasonButton, BorderLayout.CENTER);
        panel.add(logOutButton, BorderLayout.CENTER);

        addRaceButton.addActionListener((event) -> {
            System.out.println("Add a Race");
            JFrame frame = new JFrame("MYS | Add a Race");
            JPanel addRacePanel = new JPanel(new GridLayout(50,0));
            JLabel addRaceTitle = new JLabel("Add a Race", SwingConstants.CENTER);
            addRaceTitle.setFont(new Font("Arial", Font.PLAIN, 30));

            addRacePanel.add(addRaceTitle);

            if(season == null) {
                season = new Season();
                JLabel addRaceText = new JLabel("From a list bellow add a 1st Race");
                addRacePanel.add(addRaceText);
            }
            else {
                JLabel addRaceText = new JLabel("Add Race No. " + (season.getRaceWeeks().size() + 1));
                addRacePanel.add(addRaceText);
            }

            JTextField addRaceInput = new JTextField(SwingConstants.CENTER);
            JButton confirmRace = new JButton("Add a Race");
            addRacePanel.add(addRaceInput);
            addRacePanel.add(confirmRace);

            JLabel featuredRaces = new JLabel("Featured races");
            featuredRaces.setFont(new Font("Arial", Font.PLAIN, 20));
            addRacePanel.add(featuredRaces);
            addRacePanel.add(new JLabel(""));
            if (season.getNumberOfRaces() < 8) {
                for(Country country : season.getCountries()) {
                    if (country.getSpringTemperature() >= 21) {
                        JLabel countryName = new JLabel(country.getName(), SwingConstants.CENTER);
                        countryName.setFont(new Font("Arial", Font.PLAIN, 18));
                        JLabel countryInfo = new JLabel("Spring temperature:" + country.getSpringTemperature());
                        addRacePanel.add(countryName);
                        addRacePanel.add(countryInfo);
                    }
                }
            }
            else if(season.getNumberOfRaces() >= 8 && season.getNumberOfRaces() < 17) {
                for(Country country : season.getCountries()) {
                    if (country.getSummerTemperature() >= 25 && country.getSummerTemperature() < 31) {
                        JLabel countryName = new JLabel(country.getName(), SwingConstants.CENTER);
                        countryName.setFont(new Font("Arial", Font.PLAIN, 18));
                        JLabel countryInfo = new JLabel("Summer temperature:" + country.getSummerTemperature());
                        addRacePanel.add(countryName);
                        addRacePanel.add(countryInfo);
                    }
                }
            }
            else if(season.getNumberOfRaces() >= 17 && season.getNumberOfRaces() < 25) {
                for(Country country : season.getCountries()) {
                    if (country.getAutumnTemperature() >= 22 && country.getSummerTemperature() < 31) {
                        JLabel countryName = new JLabel(country.getName(), SwingConstants.CENTER);
                        countryName.setFont(new Font("Arial", Font.PLAIN, 18));
                        JLabel countryInfo = new JLabel("Autumn temperature:" + country.getAutumnTemperature());
                        addRacePanel.add(countryName);
                        addRacePanel.add(countryInfo);
                    }
                }
            }

            JLabel listOfRaces = new JLabel("List of all races");
            listOfRaces.setFont(new Font("Arial", Font.PLAIN, 20));
            addRacePanel.add(listOfRaces);
            addRacePanel.add(new JLabel(""));

            for(Country country : season.getCountries()) {
                JLabel countryName = new JLabel(country.getName(), SwingConstants.CENTER);
                JLabel countryInfo = new JLabel("Summer temp:" + country.getSummerTemperature() + " Spring temp:" + country.getSpringTemperature() + " Autumn temp:" + country.getAutumnTemperature());
                addRacePanel.add(countryName);
                addRacePanel.add(countryInfo);
            }

            frame.add(new JScrollPane(addRacePanel));
            frame.setSize(1000, 600);
            frame.setResizable(false);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            confirmRace.addActionListener((click) -> {
                season.setRaceWeeks(ApplicationControl.checkAddRaceInput(addRaceInput.getText(), season.getRaceWeeks(), season.getCountries()));
                season.setCountries(ApplicationControl.removeAddedCountry(addRaceInput.getText(), season.getCountries()));

                for (RaceWeek raceWeek : season.getRaceWeeks()) {
                    System.out.println("Country: " + raceWeek.getCountry().getName() + " | Temperature: " + raceWeek.getRaceTemperature());
                }
                frame.dispose();
            });
        });

        startSeasonButton.addActionListener((event) -> {
            if(season != null) {
                JFrame frame = new JFrame("MYS | Start a season");
                JPanel startSeasonPanel = new JPanel(new GridLayout(2, 0));
                JLabel seasonStatus;
                JButton seasonStatusButton;
                if (season.isStarted()) {
                    seasonStatus = new JLabel("Season has already started" , SwingConstants.CENTER);
                    seasonStatusButton = new JButton("Ok");
                    seasonStatusButton.addActionListener((action) -> {
                        frame.dispose();
                        System.out.println("Season has already started");
                    });
                } else {
                    seasonStatus = new JLabel("Start the season" , SwingConstants.CENTER);
                    seasonStatusButton = new JButton("Start");

                    seasonStatusButton.addActionListener((action) -> {
                        season.setStarted(true);
                        frame.dispose();
                        System.out.println("Season start");
                    });
                }
                startSeasonPanel.add(seasonStatus);
                startSeasonPanel.add(seasonStatusButton);

                frame.add(startSeasonPanel);
                frame.setSize(400, 250);
                frame.setResizable(false);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
            else {
                System.out.println("No races added");
                JFrame frame = new JFrame("MYS | No Races Added");
                JPanel startSeasonPanel = new JPanel(new GridLayout(2, 0));
                JLabel seasonStatus;
                JButton seasonStatusButton;
                seasonStatus = new JLabel("Add Races at First", SwingConstants.CENTER);
                seasonStatusButton = new JButton("Ok");
                seasonStatusButton.addActionListener((action) -> {
                    frame.dispose();
                    System.out.println("Add Races at First");
                });

                startSeasonPanel.add(seasonStatus);
                startSeasonPanel.add(seasonStatusButton);

                frame.add(startSeasonPanel);
                frame.setSize(400, 250);
                frame.setResizable(false);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
            });

        logOutButton.addActionListener((event) -> {
            for (Window win : Window.getWindows()) {
                win.dispose();
            }
            ApplicationFrame applicationFrame = new ApplicationFrame();
            applicationFrame.start();
        });

        return panel;
    }
}
