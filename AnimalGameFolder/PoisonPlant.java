
/**
 * this plant harms the animal that eats it
 * 
 * @author Robert Fanzutti
 */
public class PoisonPlant extends Plant{

    /**
     * takes away 5 points from the creature's energy
     * 
     * @param creaturesPower the energy of the creature that ate the plant
     * @return the new energy of the creature that ate the plant
     */
    @Override
    public int isEaten(int creaturesPower){
        return creaturesPower-5;
    }

    /**
     * constructor for the plant
     * 
     * @param XCord horizontal cord of the plant
     * @param YCord vertical cord of the plant
     */
    public PoisonPlant(int XCord, int YCord){
        this.XCord = XCord;
        this.YCord = YCord;
    }
}
