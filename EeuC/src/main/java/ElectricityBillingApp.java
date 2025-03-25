/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
// ElectricityBillingApp - Java Swing UI Template

// ElectricityBillingApp - Java Swing UI Template with Menu Bar

// Electricity Billing System with Quantity, Appliance Table & Tiered Rate Calculation

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Appliance {
    String name;
    double power;
    double hours;
    int quantity;

    public Appliance(String name, double power, double hours, int quantity) {
        this.name = name;
        this.power = power;
        this.hours = hours;
        this.quantity = quantity;
    }

    public double getMonthlyConsumption() {
        return (power * hours * quantity * 30) / 1000.0; // kWh
    }
}

public class ElectricityBillingApp {
    private JFrame frame;
    private JTextField nameField, powerField, hoursField, quantityField;
    private JTable applianceTable;
    private DefaultTableModel tableModel;
    private JLabel totalConsumptionLabel, totalBillLabel;
    private ArrayList<Appliance> appliances;

    public ElectricityBillingApp() {
        appliances = new ArrayList<>();
        frame = new JFrame("Electricity Billing Calculator");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // --- Menu Bar ---
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");
        JMenu utilityMenu = new JMenu("Utility");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        menuBar.add(utilityMenu);
        frame.setJMenuBar(menuBar);

        // --- Input Panel ---
        JLabel nameLabel = new JLabel("Appliance Name:");
        JLabel powerLabel = new JLabel("Power (Watts):");
        JLabel hoursLabel = new JLabel("Hours per Day:");
        JLabel quantityLabel = new JLabel("Quantity:");

        nameField = new JTextField(10);
        powerField = new JTextField(10);
        hoursField = new JTextField(10);
        quantityField = new JTextField(10);

        JButton addButton = new JButton("Add Appliance");
        JButton removeButton = new JButton("Remove Selected");
        JButton calculateButton = new JButton("Calculate Bill");
        JButton clearButton = new JButton("Clear All");

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(powerLabel);
        inputPanel.add(powerField);
        inputPanel.add(hoursLabel);
        inputPanel.add(hoursField);
        inputPanel.add(quantityLabel);
        inputPanel.add(quantityField);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        // --- Table for Appliance List ---
        String[] columnNames = {"Name", "Power (W)", "Hours/Day", "Quantity", "Monthly kWh"};
        tableModel = new DefaultTableModel(columnNames, 0);
        applianceTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(applianceTable);

        // --- Output Area ---
        totalConsumptionLabel = new JLabel("Total Consumption: 0.00 kWh");
        totalBillLabel = new JLabel("Total Bill: 0.00 ETB");

        JPanel outputPanel = new JPanel(new GridLayout(3, 1));
        outputPanel.add(totalConsumptionLabel);
        outputPanel.add(totalBillLabel);
        outputPanel.add(calculateButton);
        outputPanel.add(clearButton);

        // --- Main Layout ---
        frame.setLayout(new BorderLayout());
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(tableScrollPane, BorderLayout.CENTER);
        frame.add(outputPanel, BorderLayout.SOUTH);

        // --- Button Actions ---
        addButton.addActionListener(e -> addAppliance());
        removeButton.addActionListener(e -> removeSelectedAppliance());
        calculateButton.addActionListener(e -> calculateBill());
        clearButton.addActionListener(e -> clearAll());

        frame.setVisible(true);
    }

    private void addAppliance() {
        try {
            String name = nameField.getText().trim();
            double power = Double.parseDouble(powerField.getText().trim());
            double hours = Double.parseDouble(hoursField.getText().trim());
            int quantity = Integer.parseInt(quantityField.getText().trim());

            if (name.isEmpty() || power <= 0 || hours < 0 || hours > 24 || quantity <= 0) {
                JOptionPane.showMessageDialog(frame, "Please enter valid appliance details.");
                return;
            }

            Appliance app = new Appliance(name, power, hours, quantity);
            appliances.add(app);
            tableModel.addRow(new Object[]{name, power, hours, quantity, String.format("%.2f", app.getMonthlyConsumption())});

            nameField.setText("");
            powerField.setText("");
            hoursField.setText("");
            quantityField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter numeric values for power, hours and quantity.");
        }
    }

    private void removeSelectedAppliance() {
        int row = applianceTable.getSelectedRow();
        if (row >= 0) {
            appliances.remove(row);
            tableModel.removeRow(row);
        } else {
            JOptionPane.showMessageDialog(frame, "Please select a row to remove.");
        }
    }

    private void calculateBill() {
        double totalConsumption = 0;
        for (Appliance app : appliances) {
            totalConsumption += app.getMonthlyConsumption();
        }

        double totalBill = calculateTieredBill(totalConsumption);
        totalConsumptionLabel.setText("Total Consumption: " + String.format("%.2f", totalConsumption) + " kWh");
        totalBillLabel.setText("Total Bill: " + String.format("%.2f", totalBill) + " ETB");
    }

    private double calculateTieredBill(double consumption) {
        double bill = 0;
        if (consumption <= 50) bill = consumption * 0.5;
        else if (consumption <= 100) bill = 50 * 0.5 + (consumption - 50) * 0.75;
        else if (consumption <= 200) bill = 50 * 0.5 + 50 * 0.75 + (consumption - 100) * 1.2;
        else if (consumption <= 300) bill = 50 * 0.5 + 50 * 0.75 + 100 * 1.2 + (consumption - 200) * 1.5;
        else bill = 50 * 0.5 + 50 * 0.75 + 100 * 1.2 + 100 * 1.5 + (consumption - 300) * 2.0;
        return bill;
    }

    private void clearAll() {
        appliances.clear();
        tableModel.setRowCount(0);
        totalConsumptionLabel.setText("Total Consumption: 0.00 kWh");
        totalBillLabel.setText("Total Bill: 0.00 ETB");
    }

    public static void main(String[] args) {
        new ElectricityBillingApp();
    }
}
