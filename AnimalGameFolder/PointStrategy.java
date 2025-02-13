/**
 * Defines a strategy for calculating points earned by a creature.
 * Different implementations can specify unique point calculations
 * based on the creature's actions or characteristics.
 * @author Kameron Dear
 */
public interface PointStrategy {

    /**
     * Calculates the points earned by the specified creature.
     * 
     * @param creature The creature for which points are calculated.
     * @return The points earned by the creature.
     */
    int calculatePoints(Creature creature);
}
