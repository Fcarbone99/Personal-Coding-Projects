/**
 * Abstract base class for obstacles in the game.
 * Obstacles define specific interactions with creatures that encounter them.
 * 
 * This class can be extended to create different types of obstacles.
 * 
 * @author Frankie Carbone
 */
abstract class Obstacle {
    /**
     * The name of the obstacle.
     */
    protected String name;

    /**
     * Constructor for the Obstacle class.
     * 
     * @param name the name of the obstacle
     */
    public Obstacle(String name) {
        this.name = name;
    }

    /**
     * Abstract method to define how the obstacle interacts with a creature.
     * Subclasses must implement this method to specify the interaction logic.
     * 
     * @param creature the creature interacting with the obstacle
     */
    public abstract void affectCreature(Creature creature);

    /**
     * Retrieves the name of the obstacle.
     * 
     * @return the name of the obstacle
     */
    public String getName() {
        return name;
    }

    /**
     * Optional method to retrieve a composite obstacle group if the obstacle
     * is part of a composite pattern. By default, this method returns null.
     * 
     * Subclasses can override this method to return an actual composite group.
     * 
     * @return an ObstacleGroup if the obstacle is part of a composite, or null otherwise
     */
    public ObstacleGroup getComposite() {
        return null;
    }
}
