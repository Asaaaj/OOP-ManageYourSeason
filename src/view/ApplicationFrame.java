package view;

import javax.swing.*;
import java.awt.*;
import controller.*;
import model.NoInputException;
import model.WrongInputException;
import model.User;


public class ApplicationFrame extends JFrame implements Application{

    public JFrame logInFrame() {
        JFrame frame = new JFrame("MYS | Log In");
        JPanel panel = new JPanel();

        panel.setSize(frame.getWidth(), frame.getHeight());
        panel.setLayout(new GridLayout(8,1,0, 0));

        frame.add(panel);
        JLabel title = new JLabel("MYS", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.PLAIN, 40));
        JLabel underTitle = new JLabel("Manage your season", SwingConstants.CENTER);
        JLabel username = new JLabel("Username:");
        JTextField usernameInput = new JTextField(SwingConstants.CENTER);
        JLabel password = new JLabel("Password:");
        JTextField passwordInput = new JPasswordField();
        JButton logIn = new JButton("Log in");
        JButton exitButton = new JButton("Exit");

        panel.add(title, BorderLayout.CENTER);
        panel.add(underTitle);
        panel.add(username);
        panel.add(usernameInput);
        panel.add(password);
        panel.add(passwordInput);
        panel.add(logIn);
        panel.add(exitButton);

        frame.add(panel);
        frame.setSize(400, 600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        exitButton.addActionListener((event) -> System.exit(0));
        logIn.addActionListener((event) -> {
            try {
                User user = ApplicationControl.checkLoggingIn(usernameInput.getText(), passwordInput.getText());
                frame.setContentPane(user.control());
                frame.setTitle("MYS | " + user.controlName());
                frame.setSize(900, 600);
            } catch (NoInputException exception) {
                //CUSTOM EXCEPTION
                JPanel exceptionPanel = new JPanel();
                JLabel exceptionLabel = new JLabel("FILL THE TEXT FIELDS!", SwingConstants.CENTER);
                exceptionPanel.setSize(frame.getWidth(), frame.getHeight());
                exceptionPanel.setLayout(new GridLayout(10,1,0, 0));
                exceptionPanel.add(title, BorderLayout.CENTER);
                exceptionPanel.add(underTitle);
                exceptionPanel.add(exceptionLabel);
                exceptionPanel.add(username);
                exceptionPanel.add(usernameInput);
                exceptionPanel.add(password);
                exceptionPanel.add(passwordInput);
                exceptionPanel.add(logIn);
                exceptionPanel.add(exitButton);
                frame.setContentPane(exceptionPanel);
            } catch (WrongInputException exception) {
                JPanel exceptionPanel = new JPanel();
                JLabel exceptionLabel = new JLabel("WRONG USERNAME OR PASSWORD!", SwingConstants.CENTER);
                exceptionPanel.setSize(frame.getWidth(), frame.getHeight());
                exceptionPanel.setLayout(new GridLayout(10,1,0, 0));
                exceptionPanel.add(title, BorderLayout.CENTER);
                exceptionPanel.add(underTitle);
                exceptionPanel.add(exceptionLabel);
                exceptionPanel.add(username);
                exceptionPanel.add(usernameInput);
                exceptionPanel.add(password);
                exceptionPanel.add(passwordInput);
                exceptionPanel.add(logIn);
                exceptionPanel.add(exitButton);
                frame.setContentPane(exceptionPanel);
            }
        });
        return frame;
    }
}
