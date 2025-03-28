import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JPanel mainPanel; // Main menu panel
    private JPanel currentPanel; // The panel currently displayed

    public MainFrame() {
        setTitle("Utility Calculator");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create Menu Bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Create "Utility" Menu
        JMenu utilityMenu = new JMenu("Utility");
        menuBar.add(utilityMenu);

        // Create "Help" Menu
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);

        // Create Menu Items
        JMenuItem electricityMenuItem = new JMenuItem("Electricity");
        JMenuItem waterMenuItem = new JMenuItem("Water");
        JMenuItem internetMenuItem = new JMenuItem("Internet");

        // Add Menu Items to "Utility"
        utilityMenu.add(electricityMenuItem);
        utilityMenu.add(waterMenuItem);
        utilityMenu.add(internetMenuItem);

        // Create the main menu panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        JLabel label = new JLabel("Welcome to the Utility Calculator! Please choose an option from the menu.");
        mainPanel.add(label);
        
        // Set the initial panel
        currentPanel = mainPanel;
        add(currentPanel, BorderLayout.CENTER);

        // Action Listeners for Menu Items
        electricityMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanel(new InputPanel());  // Show Electricity Calculator
            }
        });

        // Placeholder actions for Water and Internet
        waterMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Water Calculator Coming Soon!");
            }
        });

        internetMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Internet Calculator Coming Soon!");
            }
        });

        setVisible(true);
    }

    private void switchPanel(JPanel newPanel) {
        getContentPane().remove(currentPanel);
        currentPanel = newPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
