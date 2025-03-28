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

    private double totalConsumption = 0;

    public InputPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        
        JPanel inputBox = new JPanel();
        inputBox.setLayout(new GridLayout(7, 2));  
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
        try {
            String name = applianceField.getText().trim();
            String wattageText = wattageField.getText().trim();
            String timeText = timeField.getText().trim();
            String quantityText = quantityField.getText().trim();

         
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Appliance name cannot be empty!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (wattageText.isEmpty() || timeText.isEmpty() || quantityText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

           
            int wattage = Integer.parseInt(wattageText);
            int time = Integer.parseInt(timeText);
            int quantity = Integer.parseInt(quantityText);

           
            if (wattage <= 0 || time <= 0 || quantity <= 0) {
                JOptionPane.showMessageDialog(this, "Wattage, Usage Time, and Quantity must be positive numbers!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

           
            boolean isDay = dayRadioButton.isSelected();
            String usageType = isDay ? "Day" : "Month";

            
            int adjustedUsage = isDay ? (time * 30) : time;  

     
            double consumption = Calculator.calculateConsumption(wattage, adjustedUsage, quantity);

         
            tableModel.addRow(new Object[]{name, wattage, time, usageType, quantity, consumption});

           
            totalConsumption += consumption;

           
            applianceField.setText("");
            wattageField.setText("");
            timeField.setText("");
            quantityField.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values for Wattage, Usage, and Quantity.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calculateBill() {
        
        double amount = Calculator.calculateBillAmount(totalConsumption);

       
        double serviceCharge = Calculator.calculateServiceCharge(amount);

       
        double totalBillableAmount = Calculator.calculateTotalBill(amount, serviceCharge);

       
        resultArea.setText(String.format("Total Consumption: %.2f kWh/month\n", totalConsumption));
        resultArea.append(String.format("Amount: %.2f ETB\n", amount));
        resultArea.append(String.format("Service Charge: %.2f ETB\n", serviceCharge));
        resultArea.append(String.format("Total Billable Amount: %.2f ETB\n", totalBillableAmount));
    }
}
