
/**
 * plants which can be eaten by animals for more power
 * 
 * @author Robert Fanzutti
 */
public abstract class Plant extends BoardObject{

    /**
     * does an operation the creature's power
     * @param creaturesPower the power of the creature that ate the plant
     * @return the new power of the creature that ate this plant
     */
    public abstract int isEaten(int creaturesPower);    

    @Override
    protected void interact(Creature other) {
        other.setPoints(isEaten(other.getPoints()));
    }
}
