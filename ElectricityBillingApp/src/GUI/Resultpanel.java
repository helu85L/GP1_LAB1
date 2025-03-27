import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ResultPanel extends JPanel {
    private JTextArea resultArea;
    private JButton calculateButton;
    private List<Double> consumptions;

    public ResultPanel() {
        setLayout(new BorderLayout());

        resultArea = new JTextArea(10, 40);
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        calculateButton = new JButton("Calculate Bill");
        add(calculateButton, BorderLayout.SOUTH);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateBill();
            }
        });
    }

    private void calculateBill() {
        double totalConsumption = consumptions.stream().mapToDouble(Double::doubleValue).sum();
        double amount = Calculator.calculateBillAmount(totalConsumption);
        double serviceCharge = 42.00; // Fixed service charge in ETB
        double totalBillableAmount = amount + serviceCharge;

        StringBuilder sb = new StringBuilder();
        sb.append("Total Consumption (kWh): ").append(totalConsumption).append("\n");
        sb.append("Amount (ETB): ").append(amount).append("\n");
        sb.append("Service Charge (ETB): ").append(serviceCharge).append("\n");
        sb.append("Total Billable Amount (ETB): ").append(totalBillableAmount).append("\n");

        resultArea.setText(sb.toString());
    }

    public void setConsumptions(List<Double> consumptions) {
        this.consumptions = consumptions;
    }
}
