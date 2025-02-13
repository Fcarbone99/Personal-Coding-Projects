/**
 * A point strategy that awards a fixed number of points for a creature
 * consuming a plant.
 * 
 * @author Kameron Dear
 */
public class GrassPointStrategy implements PointStrategy {

    /**
     * Calculates points for a creature based on consuming a plant.
     * 
     * @param creature The creature earning points.
     * @return A fixed number of points (5).
     */
    @Override
    public int calculatePoints(Creature creature) {
        return 5; // Gains 5 points for consuming a plant
    }
}
