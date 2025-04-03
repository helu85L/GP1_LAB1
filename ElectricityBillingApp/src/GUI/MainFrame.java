import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {
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

        // Create Menu Items with Keyboard Shortcuts
        JMenuItem electricityMenuItem = new JMenuItem("Electricity");
        electricityMenuItem.setMnemonic(KeyEvent.VK_E);
        electricityMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        
        JMenuItem waterMenuItem = new JMenuItem("Water");
        waterMenuItem.setMnemonic(KeyEvent.VK_W);
        waterMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        
        JMenuItem internetMenuItem = new JMenuItem("Internet");
        internetMenuItem.setMnemonic(KeyEvent.VK_I);
        internetMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));

        // Add Menu Items to "Utility"
        utilityMenu.add(electricityMenuItem);
        utilityMenu.add(waterMenuItem);
        utilityMenu.add(internetMenuItem);

        // Create the initial blank panel
        JPanel mainMenuPanel = new JPanel();
        mainMenuPanel.setLayout(new FlowLayout());
        JLabel label = new JLabel("Welcome to the Utility Calculator! Please choose an option from the menu.");
        mainMenuPanel.add(label);

        // Set the initial screen
        currentPanel = mainMenuPanel;
        add(currentPanel, BorderLayout.CENTER);
        
        // Action Listeners for Menu Items
        electricityMenuItem.addActionListener((ActionEvent e) -> {
            switchPanel(new InputPanel());  // Show Electricity Calculator
        });

        waterMenuItem.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, "Water Calculator Coming Soon!");
        });

        internetMenuItem.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, "Internet Calculator Coming Soon!");
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
