/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizoop_123230083_gorbiellopasaribu;

/**
 *
 * @author Lab Informatika
 */
import javax.swing.*;
import java.awt.*;

public class BookingPage extends JFrame {
    private JTextField nameField, dayField, ticketField;
    private JComboBox<String> monthBox, timeBox;
    private JRadioButton creditCard, eWallet, bankTransfer;
    private ButtonGroup paymentGroup;

    public BookingPage(String movieTitle) {
        setTitle("Booking - " + movieTitle);
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 2, 10, 10));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Booking Date:"));
        JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dayField = new JTextField(2);
        monthBox = new JComboBox<>(new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"});
        datePanel.add(dayField);
        datePanel.add(monthBox);
        datePanel.add(new JLabel("2025"));
        add(datePanel);

        add(new JLabel("Showtime:"));
        timeBox = new JComboBox<>(new String[]{"12:00", "15:00", "18:00", "21:00"});
        add(timeBox);

        add(new JLabel("Number of Tickets:"));
        ticketField = new JTextField();
        add(ticketField);

        add(new JLabel("Payment Method:"));
        JPanel paymentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        creditCard = new JRadioButton("Credit Card");
        eWallet = new JRadioButton("E-Wallet");
        bankTransfer = new JRadioButton("Bank Transfer");

        paymentGroup = new ButtonGroup();
        paymentGroup.add(creditCard);
        paymentGroup.add(eWallet);
        paymentGroup.add(bankTransfer);

        paymentPanel.add(creditCard);
        paymentPanel.add(eWallet);
        paymentPanel.add(bankTransfer);
        add(paymentPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        JButton bookButton = new JButton("Book");
        JButton resetButton = new JButton("Reset");
        JButton backButton = new JButton("Back");

        bookButton.addActionListener(e -> bookTicket(movieTitle));
        resetButton.addActionListener(e -> resetForm());
        backButton.addActionListener(e -> {
            new MainMenuPage();
            dispose();
        });

        buttonPanel.add(bookButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(backButton);
        
        add(new JLabel(""));
        add(buttonPanel);

        setVisible(true);
    }

    private void bookTicket(String movieTitle) {
        try {
            String name = nameField.getText();
            int day = Integer.parseInt(dayField.getText());
            int tickets = Integer.parseInt(ticketField.getText());
            String month = (String) monthBox.getSelectedItem();
            String time = (String) timeBox.getSelectedItem();
            String paymentMethod = creditCard.isSelected() ? "Credit Card" :
                                   eWallet.isSelected() ? "E-Wallet" : 
                                   bankTransfer.isSelected() ? "Bank Transfer" : "";

            if (name.isEmpty() || paymentMethod.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int totalPrice = tickets * 20000;
            totalPrice += totalPrice * 0.1;

            String message = String.format(
                "Booking Confirmation:\n\nMovie: %s\nName: %s\nDate: %d %s 2025\nShowtime: %s\nTickets: %d\nPayment: %s\nTotal Price: Rp%d",
                movieTitle, name, day, month, time, tickets, paymentMethod, totalPrice
            );

            JOptionPane.showMessageDialog(this, message, "Booking Successful", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input! Make sure day and number of tickets are numbers.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetForm() {
        nameField.setText("");
        dayField.setText("");
        ticketField.setText("");
        paymentGroup.clearSelection();
    }
}
