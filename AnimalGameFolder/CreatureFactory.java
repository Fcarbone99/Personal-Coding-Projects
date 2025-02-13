/**
 * Concrete factory for creating creature objects.
 * 
 * @author Robert Fanzutti
 */
public class CreatureFactory implements BoardObjectFactory {

    /**
     * Populates the board with a creature object based on type.
     * 
     * @param XCord The X coordinate where the creature will be placed.
     * @param YCord The Y coordinate where the creature will be placed.
     * @return A concrete Creature object.
     */
    @Override
    public Creature populate(int XCord, int YCord) {
        // Use logic to determine the type of creature to create (e.g., random or predefined)
        int randomType = new java.util.Random().nextInt(3); // 0 = Fire, 1 = Grass, 2 = Water

        switch (randomType) {
            case 0:
                return new FireCreature(XCord, YCord, true); // Fire creatures can cannibalize
            case 1:
                return new GrassCreature(XCord, YCord, false); // Grass creatures cannot cannibalize
            case 2:
                return new WaterCreature(XCord, YCord, false); // Water creatures cannot cannibalize
            default:
                throw new IllegalArgumentException("Invalid creature type.");
        }
    }
}
