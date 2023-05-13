package controller;

import model.Notification;
import model.Season;
import view.ApplicationFrame;
import view.NotificationView;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TeamManagerControl {
    private Season season;
    public JPanel panel() {
        season = null;
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
                    new Notification(notificationInput.getText());
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
