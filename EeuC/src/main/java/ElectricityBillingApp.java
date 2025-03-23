/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
// ElectricityBillingApp - Java Swing UI Template

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Appliance {
    String name;
    double power;
    double hours;

    public Appliance(String name, double power, double hours) {
        this.name = name;
        this.power = power;
        this.hours = hours;
    }

    public double getMonthlyBill(double rate) {
        double dailyEnergy = (power * hours) / 1000.0;
        double monthlyEnergy = dailyEnergy * 30;
        return monthlyEnergy * rate;
    }
}

public class ElectricityBillingApp {
    private JFrame frame;
    private JTextField nameField, powerField, hoursField;
    private JTextArea resultArea;
    private ArrayList<Appliance> appliances;
    private final double RATE_PER_KWH = 2.5;

    public ElectricityBillingApp() {
        appliances = new ArrayList<>();
        frame = new JFrame("Electricity Billing Calculator");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel nameLabel = new JLabel("Appliance Name:");
        JLabel powerLabel = new JLabel("Power (Watts):");
        JLabel hoursLabel = new JLabel("Hours per Day:");

        nameField = new JTextField(15);
        powerField = new JTextField(10);
        hoursField = new JTextField(10);

        JButton addButton = new JButton("Add Appliance");
        JButton calculateButton = new JButton("Calculate Bill");

        resultArea = new JTextArea(10, 40);
        resultArea.setEditable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10));
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(powerLabel);
        panel.add(powerField);
        panel.add(hoursLabel);
        panel.add(hoursField);
        panel.add(addButton);
        panel.add(calculateButton);

        JScrollPane scrollPane = new JScrollPane(resultArea);

        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addAppliance();
            }
        });

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateTotalBill();
            }
        });

        frame.setVisible(true);
    }

    private void addAppliance() {
        try {
            String name = nameField.getText().trim();
            double power = Double.parseDouble(powerField.getText().trim());
            double hours = Double.parseDouble(hoursField.getText().trim());

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter appliance name.");
                return;
            }
            if (power <= 0 || hours < 0 || hours > 24) {
                JOptionPane.showMessageDialog(frame, "Please enter valid power and hours per day (0-24).");
                return;
            }

            appliances.add(new Appliance(name, power, hours));
            JOptionPane.showMessageDialog(frame, "Appliance added successfully!");

            nameField.setText("");
            powerField.setText("");
            hoursField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter numeric values for power and hours.");
        }
    }

    private void calculateTotalBill() {
        double totalBill = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- Appliance Bill Summary ---\n");

        for (Appliance app : appliances) {
            double bill = app.getMonthlyBill(RATE_PER_KWH);
            totalBill += bill;
            sb.append(app.name + " - Monthly Bill: " + String.format("%.2f", bill) + " Birr\n");
        }

        sb.append("\nTotal Monthly Bill: " + String.format("%.2f", totalBill) + " Birr\n");
        resultArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        new ElectricityBillingApp();
    }
}
