

/**
 * decorator so that only water animals can eat them
 * 
 * @author Robert Fanzutti
 */
public class WaterPlantDecorator extends PlantDecorator{

    /**
     * defines what happens to the creature's energy when it eats this plant
     * 
     * @param creaturesPower the energy of the creature that ate the plant
     * @return the new energy of the creature that ate the plant
     */
    @Override
    public int isEaten(int creaturesPower) {
        return plant.isEaten(creaturesPower);
    }

    /**
     * constructor for the decorator defined from parent class
     * 
     * @param plant the plant being decorated 
     */
    public WaterPlantDecorator(Plant plant){
        super(plant);
    }

    /**
     * defines what happens to the object that interacts with the plant
     * @param obj object that is being interacted with
     */
    @Override
    public void interact(Creature obj) {
        if (obj instanceof WaterCreature) {
            obj.setPoints(isEaten(obj.getPoints()));
            System.out.println(obj.getName() + " Ate a Water Plant");
        } else {
            System.out.println("Water Plant is Ignored Because it Doesn't Taste Good");
        }
    }
}
