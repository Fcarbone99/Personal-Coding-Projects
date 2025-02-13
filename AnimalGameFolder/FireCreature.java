/**
 * Represents a FireCreature, specializing in aggressive movements and fiery
 * actions.
 * 
 * @author Kameron Dear
 */
public class FireCreature extends Creature {

    /**
     * Constructs a new FireCreature with initial coordinates and cannibalization
     * ability.
     *
     * @param x              The initial x-coordinate.
     * @param y              The initial y-coordinate.
     * @param canCannibalize Whether the creature can cannibalize others.
     */
    public FireCreature(int x, int y, boolean canCannibalize) {
        super("FireCreature", x, y, 5, 3, true);
    }

    /**
     * Moves the FireCreature to a new position based on its movement rate.
     *
     * @return true if movement is successful.
     */
    @Override
    protected boolean move() {
        int newX = XCord + (int) (Math.random() * moveRate);
        int newY = YCord + (int) (Math.random() * moveRate);
        System.out.println(name + " moves to (" + newX + ", " + newY + ").");
        return true;
    }

    /**
     * Performs the creature's fiery action of breathing fire.
     *
     * @return true if the action is successful.
     */
    @Override
    protected boolean performAction() {
        System.out.println(name + " breathes fire!");
        return true;
    }

    /**
     * Evolves the FireCreature, increasing its movement rate.
     */
    @Override
    protected void evolve() {
        System.out.println(name + " evolves into a FlameDragon!");
        this.moveRate += 2;
    }

    /**
     * Accepts a visitor for operations.
     *
     * @param visitor The visitor instance.
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    /**
     * Interacts with other objects on the board.
     *
     * @param obj The object being interacted with.
     */
    @Override
    public void interact(Creature obj) {
            System.out.println(name + " interacts with " + obj.getName() + "!");
    }
}
