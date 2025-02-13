

/**
 * factory interface for any object that will be placed on the board
 * 
 * @author Robert Fanzutti
 */
public interface BoardObjectFactory {

    /**
     * abstract method for creating a BoardObject in a specific spot on the board
     * 
     * @param XCord x coordinate of object
     * @param YCord y coordinate of object
     * @return the board object that gets created
     */
    public abstract BoardObject populate(int XCord, int YCord);
}
