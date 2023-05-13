package controller;

import model.TeamManager;

import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class NotificationHandler implements Serializable {
    private ArrayList<Notification> notifications;

    public NotificationHandler() {
        notifications = new ArrayList<>();
    }

    private class Notification implements Serializable{
        private TeamManager teamManager;
        private String message;

        private Notification(String message, TeamManager teamManager) {
            this.message = message;
            this.teamManager = teamManager;
        }
    }

    public void add(String message, TeamManager teamManager) {
        notifications.add(new Notification(message, teamManager));
    }

    public String getFirstNotificationTeamManager() {
        return notifications.get(0).teamManager.getTeam().getName();
    }

    public String getFirstNotificationMessage() {
        return notifications.get(0).message;
    }

    public void update() {
        if(notifications.size() > 0) {
            JFrame notificationFrame = new JFrame("MYS | Notification");
            JPanel notificationPanel = new JPanel(new GridLayout(0, 1));

            JLabel notificationTitle = new JLabel("Notification", SwingConstants.CENTER);
            notificationTitle.setFont(new Font("Arial", Font.PLAIN, 25));
            JLabel notificationTeam = new JLabel("From: " + getFirstNotificationTeamManager(), SwingConstants.LEFT);
            notificationTeam.setFont(new Font("Arial", Font.BOLD, 20));
            JLabel notificationMessage = new JLabel(getFirstNotificationMessage(), SwingConstants.CENTER);
            notificationTeam.setFont(new Font("Arial", Font.ITALIC, 20));

            notificationPanel.add(notificationTitle);
            notificationPanel.add(notificationTeam);
            notificationPanel.add(notificationMessage);

            JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
            JButton doneButton = new JButton("Let's do it");
            JButton closeButton = new JButton("Another time");
            buttonPanel.add(doneButton);
            buttonPanel.add(closeButton);

            notificationPanel.add(buttonPanel);

            notificationFrame.add(notificationPanel);
            notificationFrame.setSize(500, 500);
            notificationFrame.setResizable(false);
            notificationFrame.setVisible(true);
            notificationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            doneButton.addActionListener(x -> {
                notifications.remove(0);
                notificationFrame.dispose();
                //SERIALIZATION
                try {
                    FileOutputStream fileOut = new FileOutputStream("notificationHandler.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(this);
                    out.close();
                    fileOut.close();
                    System.out.println("NotificationHandler serialized and saved to season.ser");
                } catch(IOException i) {
                    i.printStackTrace();
                }
            });

            closeButton.addActionListener(x -> notificationFrame.dispose());
        }
    }
}
