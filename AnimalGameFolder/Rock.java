/**
 * Represents a rock obstacle in the game.
 * This obstacle prevents creatures from moving through it.
 * 
 * @author Frankie Carbone
 */
public class Rock extends Obstacle {

    /**
     * Constructor for the Rock class.
     * 
     * @param name the name of the rock obstacle
     */
    public Rock(String name) {
        super(name);
    }

    /**
     * Defines the behavior of the rock when a creature interacts with it.
     * Creatures cannot move through a rock.
     * 
     * @param creature the creature interacting with the rock
     */
    @Override
    public void affectCreature(Creature creature) {
        System.out.println(creature.getName() + " can't move through a Rock!");
    }
}
