import javax.swing.*;
import java.awt.*;

public class ApplicationFrame extends JFrame {
    JFrame frame;

    public void start() {
        frame = new JFrame("MYS");
        JPanel panel = new JPanel();

        panel.setSize(frame.getWidth(), frame.getHeight());
        panel.setLayout(new GridLayout(8,1,0, 20));

        frame.add(panel);
        JLabel title = new JLabel("MYS", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.PLAIN, 40));
        JLabel underTitle = new JLabel("Manage your season", SwingConstants.CENTER);
        JLabel username = new JLabel("Username:");
        JTextField usernameInput = new JTextField(SwingConstants.CENTER);
        JLabel password = new JLabel("Password:");
        JTextField passwordInput = new JPasswordField();
        JButton logIn = new JButton("Log in");
        JButton exitButton = new JButton("End");


        exitButton.addActionListener((event) -> System.exit(0));

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
        frame.setVisible(true);
    }
}
