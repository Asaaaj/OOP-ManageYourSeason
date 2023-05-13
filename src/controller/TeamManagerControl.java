package controller;

import model.Season;
import model.TeamManager;
import view.ApplicationFrame;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class TeamManagerControl implements Serializable{
    private TeamManager teamManager;
    private Season season;
    private NotificationHandler handler;

    public TeamManagerControl(TeamManager teamManager) {
        this.teamManager = teamManager;
    }

    public JPanel panel() {
        season = null;
        handler = null;
        JPanel panel = new JPanel();
        JButton logOutButton = new JButton("Log out");
        //DESERIALIZATION
        try {
            FileInputStream fileIn = new FileInputStream("season.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            season = (Season) in.readObject();
            in.close();
            fileIn.close();
        } catch(IOException i) {
            i.printStackTrace();
        } catch(ClassNotFoundException c) {
            System.out.println("Season class not found");
            c.printStackTrace();
        }
        //DESERIALIZATION
        try {
            FileInputStream fileIn = new FileInputStream("notificationHandler.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            handler = (NotificationHandler) in.readObject();
            in.close();
            fileIn.close();
        } catch(IOException i) {
            i.printStackTrace();
        } catch(ClassNotFoundException c) {
            System.out.println("NotificationHandler class not found");
            c.printStackTrace();
        }

        if (season == null) {
            panel.setLayout(new GridLayout(0, 1));
            JLabel title = new JLabel("Team Manager", SwingConstants.CENTER);
            JLabel seasonStatus = new JLabel("Season has not started yet!", SwingConstants.CENTER);
            seasonStatus.setFont(new Font("Arial", Font.PLAIN, 50));
            panel.add(title);
            panel.add(seasonStatus);
            panel.add(logOutButton);
        } else  {

            panel.setLayout(new GridLayout(5, 1));
            JLabel title = new JLabel("Team Manager", SwingConstants.CENTER);
            title.setFont(new Font("Arial", Font.PLAIN, 40));
            JLabel currentRace = new JLabel("Next race: " + season.getRaceWeeks().get(season.getCurrentRace() - 1).getCountry().getName() + " " + season.getCurrentRace() + "/" + season.getNumberOfRaces(), SwingConstants.CENTER);
            currentRace.setFont(new Font("Arial", Font.PLAIN, 30));
            JButton confirmParticipationButton = new JButton("Confirm participation");
            JButton sendNotification = new JButton("Send notification");
            panel.add(title, BorderLayout.CENTER);
            panel.add(currentRace, BorderLayout.CENTER);
            panel.add(confirmParticipationButton);
            panel.add(sendNotification);
            panel.add(logOutButton);

            sendNotification.addActionListener(e -> {
                if (handler == null) handler = new NotificationHandler();
                JFrame notificationFrame = new JFrame("MYS | New notification");
                JPanel notificationPanel = new JPanel(new GridLayout(0, 1));

                JLabel notificationTitle = new JLabel("Notification", SwingConstants.CENTER);
                notificationTitle.setFont(new Font("Arial", Font.PLAIN, 30));
                JTextField notificationInput = new JTextField(SwingConstants.CENTER);
                JButton notificationConfirm = new JButton("Send notification");
                notificationPanel.add(notificationTitle);
                notificationPanel.add(notificationInput);
                notificationPanel.add(notificationConfirm);
                notificationFrame.add(notificationPanel);

                notificationFrame.setSize(500,500);
                notificationFrame.setResizable(false);
                notificationFrame.setVisible(true);
                notificationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                notificationConfirm.addActionListener(action -> {
                    handler.add(notificationInput.getText(), teamManager);
                    //SERIALIZATION
                    try {
                        FileOutputStream fileOut = new FileOutputStream("notificationHandler.ser");
                        ObjectOutputStream out = new ObjectOutputStream(fileOut);
                        out.writeObject(handler);
                        out.close();
                        fileOut.close();
                        System.out.println("NotificationHandler serialized and saved to season.ser");
                    } catch(IOException i) {
                        i.printStackTrace();
                    }
                    notificationFrame.dispose();
                });
            });

        }

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
