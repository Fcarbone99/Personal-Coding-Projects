

/**
 * the BoardObject class is the parent class for anything that can placed on the board
 * and does something during the simulation. Its location is represented by x and y
 * coordinates.
 * 
 * @author Robert Fanzutti
 */
public abstract class BoardObject {
    /**
     * represents horizontal position on the board
     */
    protected int XCord;

    /**
     * represents vertical position on the board
     */
    protected int YCord;

    /**
     * abstract method that defines what happens when a creature lands on the same coords as this Board Object
     * @param other
     */
    protected abstract void interact(Creature other);

    /**
     * checks if the creature has moved to the same spot as it
     * @param other creature that has moved
     */
    public void checkInteraction(Creature other){
        if(other.getXCord()==XCord&&other.getYCord()==YCord){
            interact(other);
        }
    }

    /**
     * gets x coordinate
     * @return x cord
     */
    public int getXCord() {
        return XCord;
    }

    /**
     * gets y coordinate
     * @return y cord
     */
    public int getYCord() {
        return YCord;
    }

}
