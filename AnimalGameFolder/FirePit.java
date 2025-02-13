/**
 * Represents a FirePit obstacle in the game. 
 * The FirePit interacts with creatures based on their type.
 * Fire creatures are immune, while others take damage.
 * 
 * @author Frankie Carbone
 */
public class FirePit extends Obstacle {

    /**
     * Constructor for the FirePit class.
     * Initializes the FirePit with a given name.
     * 
     * @param name the name of the FirePit
     */
    public FirePit(String name) {
        super(name);
    }

    /**
     * Applies the effect of the FirePit to a creature.
     * Fire creatures are immune to the effects of the FirePit,
     * while other creatures take damage.
     * 
     * @param creature the creature interacting with the FirePit
     */
    @Override
    public void affectCreature(Creature creature) {
        if (creature instanceof FireCreature) {
            System.out.println(creature.getName() + " is immune to the FirePit!");
        } else {
            System.out.println(creature.getName() + " takes damage from the FirePit!");
            creature.gainPoints(); // Example method to reduce health
        }
    }
}
