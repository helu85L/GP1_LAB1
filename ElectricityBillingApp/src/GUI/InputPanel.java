import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class InputPanel extends JPanel {
    private JTextField applianceField, wattageField, usageField, quantityField, timeField;
    private JButton addButton, calculateButton;
    private JTable applianceTable;
    private DefaultTableModel tableModel;
    private JTextArea resultArea;
    private JRadioButton dayRadioButton, monthRadioButton;
    private ButtonGroup usageGroup;

    private double totalConsumption = 0; // Variable to keep track of total consumption

    public InputPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Input Box - Appliance, Wattage, Usage, Quantity
        JPanel inputBox = new JPanel();
        inputBox.setLayout(new GridLayout(7, 2));  // Adjusted grid layout to accommodate new field
        inputBox.setBorder(BorderFactory.createTitledBorder("Enter Appliance Details"));

        inputBox.add(new JLabel("Appliance:"));
        applianceField = new JTextField();
        inputBox.add(applianceField);

        inputBox.add(new JLabel("Wattage (W):"));
        wattageField = new JTextField();
        inputBox.add(wattageField);

        inputBox.add(new JLabel("Usage (hours):"));
        timeField = new JTextField();  // New field to input usage time (in hours)
        inputBox.add(timeField);

        inputBox.add(new JLabel("UsageType:"));
        JPanel usagePanel = new JPanel();
        dayRadioButton = new JRadioButton("Day", true);  // Default selection
        monthRadioButton = new JRadioButton("Month");
        usageGroup = new ButtonGroup();
        usageGroup.add(dayRadioButton);
        usageGroup.add(monthRadioButton);
        usagePanel.add(dayRadioButton);
        usagePanel.add(monthRadioButton);
        inputBox.add(usagePanel);

        inputBox.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        inputBox.add(quantityField);

        add(inputBox);

        // Add Button Box
        JPanel addButtonBox = new JPanel();
        addButton = new JButton("Add Appliance");
        addButtonBox.add(addButton);
        add(addButtonBox);

        // Table Box - Displays appliance list
        JPanel tableBox = new JPanel();
        tableBox.setLayout(new BorderLayout());
        tableBox.setBorder(BorderFactory.createTitledBorder("Appliance List"));

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Appliance");
        tableModel.addColumn("Wattage");
        tableModel.addColumn("Usage Time (hrs)");
        tableModel.addColumn("Usage (Day/Month)");
        tableModel.addColumn("Quantity");
        tableModel.addColumn("Consumption (kWh/month)");

        applianceTable = new JTable(tableModel);
        JScrollPane tableScroll = new JScrollPane(applianceTable);
        tableBox.add(tableScroll, BorderLayout.CENTER);

        add(tableBox);

        // Calculation Box - Total Consumption, Amount, Service Charge, Total Bill
        JPanel resultBox = new JPanel();
        resultBox.setLayout(new BorderLayout());
        resultBox.setBorder(BorderFactory.createTitledBorder("Calculation Results"));

        resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);
        JScrollPane resultScroll = new JScrollPane(resultArea);
        resultBox.add(resultScroll, BorderLayout.CENTER);

        calculateButton = new JButton("Calculate Bill");
        resultBox.add(calculateButton, BorderLayout.SOUTH);

        add(resultBox);

        // Button Actions
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addApplianceToTable();
            }
        });

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateBill();
            }
        });
    }

    private void addApplianceToTable() {
        String name = applianceField.getText();
        int wattage = Integer.parseInt(wattageField.getText());
        int quantity = Integer.parseInt(quantityField.getText());
        int time = Integer.parseInt(timeField.getText());

        // Adjust usage based on whether it's "Day" or "Month"
        boolean isDay = dayRadioButton.isSelected();
        String usageType = isDay ? "Day" : "Month";
        int usage = isDay ? time * 1 : time * 30;  // Convert to daily or monthly usage (assuming 30 days in a month)

        double consumption = calculateConsumption(wattage, usage, quantity, usageType);
        tableModel.addRow(new Object[]{name, wattage, usageType, quantity, time, consumption});

        // Update total consumption
        totalConsumption += consumption;

        // Clear input fields
        applianceField.setText("");
        wattageField.setText("");
        timeField.setText("");
        quantityField.setText("");
    }

    private void calculateBill() {
        // Calculate amount (ETB) based on total consumption (kWh/month)
        double amount = Calculator.calculateBillAmount(totalConsumption);

        // Calculate service charge (ETB)
        double serviceCharge = Calculator.calculateServiceCharge(amount);

        // Calculate total billable amount (ETB)
        double totalBillableAmount = Calculator.calculateTotalBill(amount, serviceCharge);

        // Display the results without cursor
        resultArea.setText(String.format("Total Consumption: %.2f kWh/month\n", totalConsumption));
        resultArea.append(String.format("Amount: %.2f ETB\n", amount));
        resultArea.append(String.format("Service Charge: %.2f ETB\n", serviceCharge));
        resultArea.append(String.format("Total Billable Amount: %.2f ETB\n", totalBillableAmount));
    }
}
