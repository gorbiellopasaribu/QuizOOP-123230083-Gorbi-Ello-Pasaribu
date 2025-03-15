package quizoop_123230083_gorbiellopasaribu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenuPage extends JFrame {
    public MainMenuPage() {
        setTitle("Main Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));

        String[] movies = {"The Lost Kingdom", "Echoes of Time", "Skyline Chase", "Frozen Shadows"};

        for (String movie : movies) {
            JButton movieButton = new JButton(movie);
            add(movieButton);
            movieButton.addActionListener(e -> {
                new BookingPage(movie);
                dispose();
            });
        }

        setVisible(true);
    }
}
