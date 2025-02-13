/**
 * Represents a water pond obstacle in the game.
 * Water creatures can move through it effortlessly, while other creatures are slowed down.
 * 
 * @author Frankie Carbone
 */
public class WaterPond extends Obstacle{

    /**
     * Constructor for the WaterPond class.
     * 
     * @param name the name of the water pond obstacle
     */
    public WaterPond(String name) {
        super(name);
    }

    /**
     * Defines the behavior of the water pond when a creature interacts with it.
     * Water creatures swim through effortlessly, while other creatures are slowed down.
     * 
     * @param creature the creature interacting with the water pond
     */
    @Override
    public void affectCreature(Creature creature) {
        if (creature instanceof WaterCreature) {
            System.out.println(creature.getName() + " swims through the WaterPond effortlessly!");
        } else {
            System.out.println(creature.getName() + " is slowed down by the WaterPond!");
        }
    }
}
