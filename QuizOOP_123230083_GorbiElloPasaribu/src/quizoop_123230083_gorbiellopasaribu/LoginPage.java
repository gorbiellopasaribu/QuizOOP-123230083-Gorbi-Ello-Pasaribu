package quizoop_123230083_gorbiellopasaribu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginPage extends JFrame{
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;
    
    public LoginPage(){
        setTitle("Login Page");
        setSize(720,480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        
        add (new JLabel("Username: "));
        userField = new JTextField();
        add (userField);
        
        add (new JLabel("Password: "));
        passField = new JPasswordField();
        add (passField);
        
        loginButton = new JButton("Login");
        add (loginButton);
        
        loginButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String (passField.getPassword());
            if (username.equals("user") && password.equals("user")){
               new MainMenuPage();
               dispose();
            }else {
                JOptionPane.showMessageDialog(this, "Invalid", "Error", JOptionPane.ERROR_MESSAGE);
            }  
        });
        
        setVisible(true);
    }
    public static void main(String[] args) {
        new LoginPage();
    }
}

