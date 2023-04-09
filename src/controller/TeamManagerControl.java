package controller;

import view.ApplicationFrame;

import javax.swing.*;
import java.awt.*;

public class TeamManagerControl {
    public JPanel panel() {
        JPanel panel = new JPanel(new GridLayout(5, 1));
        JLabel title = new JLabel("Team Manager", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.PLAIN, 40));
        JButton button1 = new JButton("Button");
        JButton button2 = new JButton("Button");
        JButton button3 = new JButton("Button");
        JButton logOutButton = new JButton("Log out");
        panel.add(title, BorderLayout.CENTER);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(logOutButton);

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
