package controller;

import javax.swing.*;
import java.awt.*;

public class TeamManagerControl {
    public JPanel panel(JPanel logInPanel) {
        JPanel panel = new JPanel();
        JLabel title = new JLabel("Team Manager", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.PLAIN, 40));
        panel.add(title, BorderLayout.CENTER);
        return panel;
    }
}
