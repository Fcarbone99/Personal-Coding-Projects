/**
 * A point strategy that awards a fixed number of points for a creature
 * consuming another creature.
 * @author Kameron Dear
 */
public class CreaturePointStrategy implements PointStrategy {

    /**
     * Calculates points for a creature based on consuming another creature.
     * 
     * @param creature The creature earning points.
     * @return A fixed number of points (10).
     */
    @Override
    public int calculatePoints(Creature creature) {
        return 10; // Points for eating another creature
    }
}
