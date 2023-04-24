package view;

import javax.swing.*;
import java.awt.*;
import controller.*;
import model.Administrator;
import model.User;


public class ApplicationFrame extends JFrame implements Application{
    JFrame frame;

    public void start() {
        frame = logInFrame();
    }

    private JFrame logInFrame() {
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
            User user = ApplicationControl.checkLogIn(usernameInput.getText(), passwordInput.getText());
            frame.remove(panel);
            frame.add(user.control());
            frame.setTitle("MYS | " + user.controlName());
            frame.setSize(900, 600);
            if(user instanceof Administrator) {
                System.out.println("user is administrator");
            }
        });
        return frame;
    }
}
