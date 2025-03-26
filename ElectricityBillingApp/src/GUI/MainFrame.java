package GUI;

import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Electricity Billing System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new InputPanel());
    }
}
