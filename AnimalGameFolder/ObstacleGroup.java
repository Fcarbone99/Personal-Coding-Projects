import java.util.ArrayList;
import java.util.List;

/**
 * Composite class representing a group of obstacles in the game.
 * This class allows multiple obstacles to be treated as a single composite object,
 * following the Composite design pattern.
 * 
 * @author Frankie Carbone
 */
class ObstacleGroup extends Obstacle {
    /**
     * A list of obstacles contained in this obstacle group.
     */
    private final List<Obstacle> obstacles = new ArrayList<>();

    /**
     * Constructor for the ObstacleGroup class.
     * 
     * @param name the name of the obstacle group
     */
    public ObstacleGroup(String name) {
        super(name);
    }

    /**
     * Adds an obstacle to the obstacle group.
     * 
     * @param obstacle the obstacle to be added to the group
     */
    public void addObstacle(Obstacle obstacle) {
        obstacles.add(obstacle);
    }

    /**
     * Removes an obstacle from the obstacle group.
     * 
     * @param obstacle the obstacle to be removed from the group
     */
    public void removeObstacle(Obstacle obstacle) {
        obstacles.remove(obstacle);
    }

    /**
     * Applies the effects of all obstacles in the group to the specified creature.
     * 
     * @param creature the creature interacting with the obstacle group
     */
    @Override
    public void affectCreature(Creature creature) {
        System.out.println("Creature encounters the obstacle group: " + name);
        for (Obstacle obstacle : obstacles) {
            obstacle.affectCreature(creature); // Apply effects of each obstacle in the group
        }
    }

    /**
     * Retrieves the composite obstacle group itself.
     * Since this class represents a composite, it returns itself.
     * 
     * @return this obstacle group instance
     */
    @Override
    public ObstacleGroup getComposite() {
        return this; // Returns itself since it's already a composite
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }
}
