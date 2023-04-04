package model;

import controller.AdminControl;
import model.User;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Administrator implements User {
    private String name;
    private final String username = "admin";
    private String login;
    private String password = "1111";
    private AdminControl control;


    @Override
    public void displayName() {
        System.out.println(username);
    }

    @Override
    public void logIn() {

    }

    @Override
    public void logOut() {

    }

    @Override
    public JPanel panel() {
        JPanel panel = new JPanel();
        JLabel title = new JLabel("Administrator", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.PLAIN, 40));
        panel.add(title, BorderLayout.CENTER);
        return panel;
    }


}
