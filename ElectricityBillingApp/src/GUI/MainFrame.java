import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Electricity Billing App");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        InputPanel inputPanel = new InputPanel();
        ResultPanel resultPanel = new ResultPanel();

        add(inputPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}
