/**
 * Represents a GrassCreature, specializing in absorbing sunlight and evolving
 * into stronger forms.
 * 
 * @author Kameron Dear
 */
public class GrassCreature extends Creature {

    /**
     * Constructs a new GrassCreature with initial coordinates and cannibalization
     * ability.
     *
     * @param x              The initial x-coordinate.
     * @param y              The initial y-coordinate.
     * @param canCannibalize Whether the creature can cannibalize others.
     */
    public GrassCreature(int x, int y, boolean canCannibalize) {
        super("Grass Creature", x, y, 5, 7, false);
    }

    /**
     * Moves the GrassCreature to a new position based on movement rate.
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
     * Performs the creature's action of absorbing sunlight.
     *
     * @return true if the action is successful.
     */
    @Override
    protected boolean performAction() {
        System.out.println(name + " absorbs sunlight!");
        return true;
    }

    /**
     * Evolves the GrassCreature, increasing its movement rate.
     */
    @Override
    protected void evolve() {
        System.out.println(name + " evolves into a ForestGuardian!");
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
            System.out.println(name + " interacts with another creature!");
    }
}
