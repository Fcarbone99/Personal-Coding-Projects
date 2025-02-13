

/**
 * this plant is has no speacial abilities it just gives 10 engery when eaten
 * 
 * @author Robert Fanzutti
 */
public class NormalPlant extends Plant{
     /**
     * adds 10 points to the creature's energy
     * 
     * @param creaturesPower the energy of the creature that ate the plant
     * @return the new energy of the creature that ate the plant
     */
    @Override
    public int isEaten(int creaturesPower){
        return creaturesPower+10;
    }

    /**
     * constructor for the plant
     * 
     * @param XCord horizontal cord of the plant
     * @param YCord vertical cord of the plant
     */
    public NormalPlant(int XCord, int YCord){
        this.XCord = XCord;
        this.YCord = YCord;
    } 
}
