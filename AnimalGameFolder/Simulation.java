import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Singleton class to run the Pokémon simulation.
 * This class handles the main simulation loop, where creatures move,
 * perform actions, and have a chance to evolve or clone during each cycle.
 * 
 * @author Frankie Carbone
 */
public class Simulation {

    // Singleton instance
    private static Simulation instance;

    // List of creatures (Pokémon) on the board
    private List<Creature> creatures;

    // The board where creatures are located (now actively used)
    private Board board;

    // Number of cycles the simulation will run for
    private int cycles;
    private final Random random;

    /**
     * Private constructor for Singleton pattern.
     * Initializes the creature list and random number generator.
     * 
     * @param board The board object that will hold the creatures.
     * @param cycles The number of simulation cycles to run.
     */
    private Simulation(Board board, int cycles) {
        if (board == null) {
            throw new IllegalArgumentException("Board cannot be null.");
        }
        this.board = board; // Actively use the board
        this.cycles = cycles;
        this.creatures = new ArrayList<>();
        this.random = new Random();
    }

    /**
     * Returns the singleton instance of the Simulation class.
     * 
     * @param board The board object that will hold the creatures.
     * @param cycles The number of cycles to run.
     * @return The singleton instance of the Simulation class.
     */
    public static synchronized Simulation getInstance(Board board, int cycles) {
        if (instance == null) {
            instance = new Simulation(board, cycles);
        }
        return instance;
    }

    /**
     * Starts the simulation by running through each cycle.
     */
    public void runSimulation() {
        for (int cycle = 0; cycle < cycles; cycle++) {
            System.out.println("Cycle " + (cycle + 1) + "--------------------------------------");
            updateCreatures();
            performActions();
        }
    }

    /**
     * Updates the creatures by having them take a turn to move.
     */
    private void updateCreatures() {
        if (random.nextInt(5) == 0) { // Example: Add obstacle every 5 turns
            Obstacle obstacle = createRandomObstacle();
            board.addObstacle(obstacle); // Assuming `Board` has an `addObstacle` method
            System.out.println("Obstacle added: " + obstacle.getName());
        }

        for (Creature creature : creatures) {
            boolean moved = creature.move();
            if (moved) {
                System.out.println(creature.getName() + " moved.");
            } else {
                System.out.println(creature.getName() + " could not move.");
            }
        }
    }

    /**
     * Creates a random obstacle for the simulation.
     * 
     * @return A new random obstacle.
     */
    private Obstacle createRandomObstacle() {
        int type = random.nextInt(3); // Assuming 3 types of obstacles

        switch (type) {
            case 0:
                return new Rock("Rock");
            case 1:
                return new WaterPond("WaterPond");
            case 2:
                return new FirePit("FirePit");
            default:
                throw new IllegalStateException("Unexpected obstacle type: " + type);
        }
    }

    /**
     * Have each creature perform its action, such as attacking, eating, or defending.
     */
    private void performActions() {
        for (Creature creature : creatures) {
            boolean actionSuccess = creature.takeTurn();
            if (actionSuccess) {
                System.out.println(creature.getName() + " completed its action.");
            } else {
                System.out.println(creature.getName() + " could not complete its action.");
            }
        }
    }

    /**
     * Gets the list of creatures currently in the simulation.
     * 
     * @return List of creatures.
     */
    public List<Creature> getCreatures() {
        return creatures;
    }

    /**
     * Adds a creature to the simulation.
     * 
     * @param creature The creature to add.
     */
    public void addCreature(Creature creature) {
        if (creature != null) {
            creatures.add(creature);
            System.out.println(creature.getName() + " added to the simulation.");
        }
    }
}
