import javax.swing.SwingUtilities;

/**
 * The entry point of the creature simulation game, handling both the GUI and
 * simulation logic.
 * <p>
 * This class initializes the game board, creates creatures and obstacles, and
 * runs the simulation
 * in a separate thread while launching the GUI on the Event Dispatch Thread
 * (EDT).
 * </p>
 * 
 * @author Kameron Dear
 */
public class Main {

    /**
     * The main method to start the simulation.
     *
     * @param args Command-line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        // Start the GUI on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            myFrame frame = new myFrame(); // Launch the frame
        });

        // Run the simulation logic on a separate thread
        Thread simulationThread = new Thread(() -> {
            // Initialize the board (singleton instance)
            Board board = Board.getBoard(50); // Create a 50x50 board

            // Create specific PointStrategy implementations
            PointStrategy creaturePointStrategy = new CreaturePointStrategy(); // For creatures like FireCreature
            PointStrategy grassPointStrategy = new GrassPointStrategy(); // For creatures like GrassCreature

            // Create instances of different creature types with their respective strategies
            Creature fireCreature = new FireCreature(0, 0, false); // Ensure FireCreature is concrete
            fireCreature.setPointStrategy(creaturePointStrategy);

            Creature grassCreature = new GrassCreature(0, 0, false); // Ensure GrassCreature is concrete
            grassCreature.setPointStrategy(grassPointStrategy);

            Creature waterCreature = new WaterCreature(0, 0, false); // Ensure WaterCreature is concrete
            waterCreature.setPointStrategy(creaturePointStrategy);

            // Add creatures to the board via a public method
            board.getCreatures().add(fireCreature);
            board.getCreatures().add(grassCreature);
            board.getCreatures().add(waterCreature);

            // Display initial information about all creatures
            System.out.println("Initial Creature Information:");
            for (Creature creature : board.getCreatures()) {
                creature.displayInfo();
            }
            System.out.println(); // Add a blank line for better readability

            // Create the StatisticsVisitor
            StatisticsVisitor statsVisitor = new StatisticsVisitor();

            // Create obstacles
            Obstacle rock1 = new Rock("Rock");
            Obstacle waterpond1 = new WaterPond("WaterPond");
            Obstacle firepit1 = new FirePit("FirePit");

            // Add obstacles to the board
            board.addObstacle(rock1);
            board.addObstacle(waterpond1);
            board.addObstacle(firepit1);

            // Start the simulation
            System.out.println("Starting simulation...\n");
            board.runSimulation(2); // Run the simulation for 2 cycles (adjustable)

            // Print final statistics
            System.out.println("Simulation complete.\n");
            System.out.println("Final Statistics:");
            statsVisitor.printSummary();
        });

        // Start the simulation thread
        simulationThread.start();
    }
}
