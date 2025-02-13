import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class myFrame extends JFrame {
    /**
     * Main panel for managing multiple screens (cards) within the frame.
     */
    private JPanel cardPanel;
    private CardLayout cardLayout;

    /**
     * Sets general information for the JFrame, including the title, image icon, 
     * size, background color, and disabling resizing.
     */
    public myFrame() {
        super("Animal Simulation"); // Set the title for the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500, 500);

        // Set an icon for the frame
        ImageIcon icon = new ImageIcon("codespace\\Graphics\\frog.png");
        setIconImage(icon.getImage());

        // Set background color
        getContentPane().setBackground(new Color(235, 230, 250));

        /**
         * Sets up cardLayout for managing multiple screens (cards).
         */
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        /**
         * Adding screens to the card panel. Additional screens can be added here.
         */
        cardPanel.add(new ScreenOne(), "Screen 1");
        cardPanel.add(new ScreenTwo(), "Screen 2");
        cardPanel.add(new ScreenThree(), "Screen 3");
        cardPanel.add(new ScreenFour(), "Screen 4");
        cardPanel.add(new ScreenFive(), "Screen 5");
        cardPanel.add(new ScreenSix(), "Screen 6");
        cardPanel.add(new ScreenSeven(), "Screen 7");
        cardPanel.add(new ScreenEight(), "Screen 8");
        cardPanel.add(new ScreenNine(), "Screen 9");



        /**
         * Add the card panel to the frame.
         */
        add(cardPanel);

        /**
         * Makes the frame visible.
         */
        setVisible(true);
    }

    /**
     * Exposes the ability to switch between cards.
     * 
     * @param cardName The name of the card to display.
     */
    public void showCard(String cardName) {
        cardLayout.show(cardPanel, cardName);
    }

    /**
     * Main method to create an instance of the frame and ensure thread safety.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(myFrame::new);
    }
}
