

/**
 * concrete factory for plants 
 * creates plant objects with coordinates
 * 
 * @author Robert Fanzutti
 */
public class PlantFactory implements BoardObjectFactory{

    /**
     * creates a new plant object
     * 
     * @param XCord x coordinate to place the plant
     * @param YCord y coordinate to place the plant
     */
    @Override
    public NormalPlant populate(int XCord, int YCord) {
        return new NormalPlant(XCord,YCord);
    }

}
