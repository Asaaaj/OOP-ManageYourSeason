package model;

import javax.swing.*;
import java.awt.*;

public class TeamManager implements User {
    private String name = "manager";
    private String login;
    private String password;

    @Override
    public void displayName() {
        System.out.println(name);
    }

    @Override
    public void logIn() {

    }

    @Override
    public void logOut() {

    }

    public void sendRequest() {
    }

    @Override
    public JPanel panel() {
        JPanel panel = new JPanel();
        JLabel title = new JLabel("Team Manager", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.PLAIN, 40));
        panel.add(title, BorderLayout.CENTER);
        return panel;
    }
}
