/**
 * Abstract base class for all creatures in the simulation. 
 * Represents common attributes and behaviors of creatures 
 * such as movement, actions, evolution, and interaction with points.
 * Implements the Template Method design pattern for defining 
 * a creature's turn sequence.
 * @author Kameron Dear
 */

public abstract class Creature extends BoardObject {
    protected String name; // Name of the creature type
    protected int points = 0; // Current points
    protected int evolutionThreshold = 20; // Points needed for evolution
    protected int moveRate; // Number of moves per turn
    protected boolean canCannibalize; // Ability to cannibalize creatures of the same type
    protected int size; // Fixed size of the creature
    protected PointStrategy pointStrategy;


 // Getter for points
    public int getPoints() {
        return points;
    }

    // Setter for points
    public void setPoints(int points) {
        this.points = points;
    }
    /**
     * Constructor for the Creature class.
     * Initializes all common attributes for a creature.
     *
     * @param name           the name of the creature
     * @param x              the x-coordinate of the creature
     * @param y              the y-coordinate of the creature
     * @param size           the fixed size of the creature
     * @param moveRate       the move rate (speed) of the creature
     * @param canCannibalize whether the creature can cannibalize its own type
     */
    public Creature(String name, int x, int y, int size, int moveRate, boolean canCannibalize) {
        this.name = name;
        this.XCord = x;
        this.YCord = y;
        this.size = size;
        this.moveRate = moveRate;
        this.canCannibalize = canCannibalize;
    }

    /**
     * Executes the full cycle for a creature's turn, following the template pattern.
     * The sequence involves movement, performing an action, checking for evolution,
     * and displaying the creature's information.
     *
     * @return true if the creature successfully performed its action, false otherwise
     */
    public boolean takeTurn() {
        if (move()) {
            boolean result = performAction();
            gainPoints();
            displayInfo();
            return result;
        }
        return false;
    }

    /**
     * Defines the movement behavior of the creature.
     * This method must be implemented by subclasses.
     *
     * @return true if the movement was successful, false otherwise
     */
    protected abstract boolean move();

    /**
     * Defines the primary action performed by the creature.
     * This method must be implemented by subclasses.
     *
     * @return true if the action was successfully executed, false otherwise
     */
    protected abstract boolean performAction();

    /**
     * Handles the evolution behavior of the creature.
     * This method must be implemented by subclasses to define specific evolution logic.
     */
    protected abstract void evolve();

    /**
     * Gains points based on the assigned PointStrategy.
     * Checks if the creature has enough points to evolve after gaining points.
     */
    protected void gainPoints() {
        if (pointStrategy != null) {
            int earnedPoints = pointStrategy.calculatePoints(this);
            points += earnedPoints;
            System.out.println(name + " earned " + earnedPoints + " points.");

            if (points >= evolutionThreshold) {
                evolve();
                points = 0; // Reset points after evolution
            }
        }
    }

    /**
     * Displays the current state of the creature, including its name,
     * move rate, and cannibalization ability.
     */
    public void displayInfo() {
        System.out.println(
            "Name: " + name +
            ", Move Rate: " + moveRate +
            ", Can Cannibalize: " + canCannibalize);
    }

    /**
     * Sets the PointStrategy for this creature, allowing it to calculate points
     * in a specific way depending on its strategy.
     *
     * @param pointStrategy the PointStrategy to use for point calculation
     */
    public void setPointStrategy(PointStrategy pointStrategy) {
        this.pointStrategy = pointStrategy;
    }

    /**
     * Getter for the fixed size of the creature.
     *
     * @return the size of the creature
     */
    public int getSize() {
        return size;
    }

    /**
     * Getter for the move rate (speed) of the creature.
     *
     * @return the move rate of the creature
     */
    public int getMoveRate() {
        return moveRate;
    }

    /**
     * Abstract method to accept a visitor.
     * Must be implemented by subclasses to allow interaction with visitors.
     *
     * @param visitor the visitor object
     */
    public abstract void accept(Visitor visitor);

    /**
     * Gets the name of the creature.
     *
     * @return the name of the creature
     */
    public String getName() {
        return name;
    }
    /**
 * Defines the eating behavior of the creature.
 * Subclasses can override this method to provide specific eating behavior.
 */
    protected void eat() {
    System.out.println(name + " is eating.");
    }


    /**
     * Throws an UnsupportedOperationException for description.
     * This can be overridden by subclasses if needed.
     *
     * @return the description of the creature
     */
    public String getDescription() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
