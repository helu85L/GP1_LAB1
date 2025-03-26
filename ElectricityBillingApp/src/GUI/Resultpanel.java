package GUI;

import javax.swing.*;
import java.awt.*;

public class ResultPanel extends JPanel {
    private JLabel resultLabel;

    public ResultPanel() {
        setLayout(new BorderLayout());
        resultLabel = new JLabel("Total Bill: 0.00 ETB", SwingConstants.CENTER);
        add(resultLabel, BorderLayout.CENTER);
    }

    public void updateBill(double bill) {
        resultLabel.setText("Total Bill: " + bill + " ETB");
    }
}
