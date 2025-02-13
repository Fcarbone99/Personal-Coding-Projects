/**
 * A decorator for Fire Plants that adds special behavior.
 * Fire Plants interact with other BoardObjects and apply unique effects.
 */
public class FirePlantDecorator extends PlantDecorator{
    @SuppressWarnings("unused")
    private BoardObject decoratedPlant;

    /**
     * Constructor for the FirePlantDecorator.
     * 
     * @param decoratedPlant The plant being decorated.
     */
    public FirePlantDecorator(Plant decoratedPlant) {
        super(decoratedPlant);
    }

    /**
     * defines what happens to the object that interacts with the plant
     * @param obj object that is being interacted with
     */
    @Override
    public void interact(Creature obj) {
        if (obj instanceof FireCreature) {
            obj.setPoints(isEaten(obj.getPoints()));
            System.out.println(obj.getName() + " Ate a Fire Plant");
        } else {
            System.out.println("Fire Plant is Ignored Because it Doesn't Taste Good");
        }
    }

    @Override
    public int isEaten(int creaturesPower) {
        return plant.isEaten(creaturesPower);
        
    }
}
