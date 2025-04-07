import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ElectricityBillingApp {
    private JFrame frame;
    private JTextField applianceField, wattageField, quantityField;
    private JRadioButton perHourRadio, perDayRadio, perMonthRadio;
    private DefaultListModel<String> applianceListModel;
    private JTextArea resultArea;
    private List<Double> consumptions;

    public ElectricityBillingApp() {
        frame = new JFrame("Electricity Bill Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLayout(new BorderLayout());
        
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        
        inputPanel.add(new JLabel("Appliance:"));
        applianceField = new JTextField();
        inputPanel.add(applianceField);
        
        inputPanel.add(new JLabel("Wattage (W):"));
        wattageField = new JTextField();
        inputPanel.add(wattageField);
        
        inputPanel.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        inputPanel.add(quantityField);
        
        inputPanel.add(new JLabel("Usage Type:"));
        JPanel usagePanel = new JPanel();
        ButtonGroup usageGroup = new ButtonGroup();
        perHourRadio = new JRadioButton("Hour/Day");
        perDayRadio = new JRadioButton("Day");
        perMonthRadio = new JRadioButton("Month");
        usageGroup.add(perHourRadio);
        usageGroup.add(perDayRadio);
        usageGroup.add(perMonthRadio);
        usagePanel.add(perHourRadio);
        usagePanel.add(perDayRadio);
        usagePanel.add(perMonthRadio);
        inputPanel.add(usagePanel);
        
        JButton addButton = new JButton("Add Appliance");
        inputPanel.add(addButton);
        
        applianceListModel = new DefaultListModel<>();
        JList<String> applianceList = new JList<>(applianceListModel);
        JScrollPane listScrollPane = new JScrollPane(applianceList);
        
        JButton calculateButton = new JButton("Calculate Bill");
        
        resultArea = new JTextArea(5, 40);
        resultArea.setEditable(false);
        
        consumptions = new ArrayList<>();
        
        addButton.addActionListener(e -> addAppliance());
        calculateButton.addActionListener(e -> calculateBill());
        
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(listScrollPane, BorderLayout.CENTER);
        bottomPanel.add(calculateButton, BorderLayout.SOUTH);
        
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(bottomPanel, BorderLayout.CENTER);
        frame.add(new JScrollPane(resultArea), BorderLayout.SOUTH);
        
        frame.setVisible(true);
    }

    private void addAppliance() {
        String name = applianceField.getText();
        int wattage = Integer.parseInt(wattageField.getText());
        int quantity = Integer.parseInt(quantityField.getText());

        int usageHours = 0;
        if (perHourRadio.isSelected()) {
            usageHours = Integer.parseInt(JOptionPane.showInputDialog("Enter hours per day:"));
        } else if (perDayRadio.isSelected()) {
            usageHours = 24;
        } else if (perMonthRadio.isSelected()) {
            usageHours = Integer.parseInt(JOptionPane.showInputDialog("Enter days per month:")) * 24;
        }

        double consumption = (wattage * usageHours * quantity * 30) / 1000.0;
        consumptions.add(consumption);
        String entry = name + " | " + wattage + "W | " + usageHours + " hrs/day | " + quantity + " pcs | " + consumption + " kWh/month";
        applianceListModel.addElement(entry);

        applianceField.setText("");
        wattageField.setText("");
        quantityField.setText("");
    }

    private void calculateBill() {
        double totalConsumption = consumptions.stream().mapToDouble(Double::doubleValue).sum();
        double amount = calculateBillAmount(totalConsumption);
        double serviceCharge = 42.00;
        double totalBillableAmount = amount + serviceCharge;

        resultArea.setText("Total Consumption (kWh): " + totalConsumption + "\n" +
                "Amount (ETB): " + amount + "\n" +
                "Service Charge (ETB): " + serviceCharge + "\n" +
                "Total Billable Amount (ETB): " + totalBillableAmount);
    }

    private double calculateBillAmount(double totalConsumption) {
        double[] rates = {0.2730, 0.7340, 1.2650, 2.0000, 2.4410, 2.9160};
        int[] brackets = {50, 100, 200, 300, 400};
        double cost = 0;
        for (int i = 0; i < brackets.length; i++) {
            if (totalConsumption > brackets[i]) {
                cost += brackets[i] * rates[i];
                totalConsumption -= brackets[i];
            } else {
                cost += totalConsumption * rates[i];
                return cost;
            }
        }
        cost += totalConsumption * rates[rates.length - 1];
        return cost;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ElectricityBillingApp::new);
    }
}