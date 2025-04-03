import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Electricity Consumption Calculator");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(600, 600);

                // Adding the InputPanel
                frame.add(new InputPanel());

                frame.setVisible(true);
            }
        });
    }
}
