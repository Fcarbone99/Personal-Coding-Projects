

/**
 * this plant is has doubles the creaures energy
 * 
 * @author Robert Fanzutti
 */
public class SuperPlant extends Plant{

    /**
     * doubles the creature's energy
     * 
     * @param creaturesPower the energy of the creature that ate the plant
     * @return the new energy of the creature that ate the plant
     */
    @Override
    public int isEaten(int creaturesPower){
        return creaturesPower*2;
    }

    /**
     * constructor for the plant
     * 
     * @param XCord horizontal cord of the plant
     * @param YCord vertical cord of the plant
     */
    public SuperPlant(int XCord, int YCord){
        this.XCord = XCord;
        this.YCord = YCord;
    }
    
}
