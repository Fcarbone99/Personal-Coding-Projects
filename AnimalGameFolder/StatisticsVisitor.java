/**
 * A visitor implementation that collects statistics about different types of creatures
 * in a simulation/game. It counts the number of creatures of each type (Fire, Water, Grass)
 * and prints their respective size and speed attributes when visited.
 */
public class StatisticsVisitor implements Visitor {

    /** Counter for the number of FireCreature instances. */
    private int fireCreatureCount = 0;

    /** Counter for the number of GrassCreature instances. */
    private int grassCreatureCount = 0;

    /** Counter for the number of WaterCreature instances. */
    private int waterCreatureCount = 0;

    /**
     * Visits a FireCreature instance, increments the counter for FireCreatures,
     * and prints the size and speed of the FireCreature.
     *
     * @param fireCreature the FireCreature instance being visited
     */
    @Override
    public void visit(FireCreature fireCreature) {
        fireCreatureCount++;
        System.out.println("FireCreature: Size = " + fireCreature.getSize() + ", Speed = " + fireCreature.getMoveRate());
    }

    /**
     * Visits a WaterCreature instance, increments the counter for WaterCreatures,
     * and prints the size and speed of the WaterCreature.
     *
     * @param waterCreature the WaterCreature instance being visited
     */
    @Override
    public void visit(WaterCreature waterCreature) {
        waterCreatureCount++;
        System.out.println("WaterCreature: Size = " + waterCreature.getSize() + ", Speed = " + waterCreature.getMoveRate());
    }

    /**
     * Visits a GrassCreature instance, increments the counter for GrassCreatures,
     * and prints the size and speed of the GrassCreature.
     *
     * @param grassCreature the GrassCreature instance being visited
     */
    @Override
    public void visit(GrassCreature grassCreature) {
        grassCreatureCount++;
        System.out.println("GrassCreature: Size = " + grassCreature.getSize() + ", Speed = " + grassCreature.getMoveRate());
    }

    /**
     * Prints a summary of the collected statistics, including the number of each
     * type of creature (Fire, Water, Grass) encountered during the visitations.
     */
    public void printSummary() {
        System.out.println("Fire Creatures: " + fireCreatureCount);
        System.out.println("Water Creatures: " + waterCreatureCount);
        System.out.println("Grass Creatures: " + grassCreatureCount);
    }
}
