package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import Logic.Calculator;
import Logic.Validator;

public class InputPanel extends JPanel {
    private JTextField unitsField;
    private JLabel resultLabel;

    public InputPanel() {
        setLayout(new GridLayout(3, 2));

        JLabel unitsLabel = new JLabel("Enter units:");
        unitsField = new JTextField();
        JButton calculateButton = new JButton("Calculate");
        resultLabel = new JLabel("Total Bill: 0.00 ETB");

        calculateButton.addActionListener((ActionEvent e) -> {
            String input = unitsField.getText();
            if (Validator.isValidNumber(input)) {
                double units = Double.parseDouble(input);
                double bill = Calculator.calculateBill(units);
                resultLabel.setText("Total Bill: " + bill + " ETB");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Input! Enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(unitsLabel);
        add(unitsField);
        add(calculateButton);
        add(resultLabel);
    }
}
