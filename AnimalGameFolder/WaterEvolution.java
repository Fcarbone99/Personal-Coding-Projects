/**
 * Represents a water evolution class that will override to its specific evolution
 * based on what creature it is, how many points it gets,
 * and what other creatures it interacts with
 * 
 * @author Frankie Carbone
 */
public abstract class WaterEvolution extends PokeEvo {

    /**
     * Constructor for the WaterEvolution class.
     * 
    * @param name           the name of the creature
     * @param x              the x-coordinate of the creature
     * @param y              the y-coordinate of the creature
     * @param size           the fixed size of the creature
     * @param moveRate       the move rate (speed) of the creature
     * @param canCannibalize whether the creature can cannibalize its own type
     */
    public WaterEvolution(String name, int x, int y, int size, int moveRate, boolean canCannibalize, Creature decoratedPokemon) {
        super(name, x, y, size, moveRate, canCannibalize, decoratedPokemon); // Call the Creature constructor
        
    }

    /**
     * Retrieves the description of the Pokemon, with an added description of the water-type evolution.
     * 
     * @return The description of the Pokemon, including its water evolution state.
     */
    @Override
    public String getDescription() {
        return decoratedPokemon.getDescription() + " -> Water Evolution!";
    }

    /**
     * Handles the Pokemon eating another Pokemon and evolving if the target is a FireCreature.
     * If the target is not a FireCreature, the action is denied.
     * 
     * @param target The target Pokemon to be eaten.
     */
    public void eat(Creature target) {
        if (target instanceof FireCreature) {
            decoratedPokemon.eat(); // Assuming eat() is a valid method in the Creature class
            System.out.println("Water Pokémon has evolved after eating Fire Pokémon! Power increased.");
            decoratedPokemon.points += 20; // Assuming points is a valid field in the Creature class
        } else {
            System.out.println("Water Pokémon can only eat Fire Pokémon!");
        }
    }

    /**
     * Handles the Pokemon moving and evolving if it moves more than 5 units.
     * The Pokemon's power increases by 10 if it moves a distance greater than 5 units.
     * 
     * @param distance The distance the Pokemon moves on the game board.
     */
    @Override
    public void move(int distance) {
        super.move(distance);
        if (distance > 5) {
            System.out.println("Water Pokémon evolved by moving a long distance! Power increased.");
            decoratedPokemon.points += 10; // Assuming points is a valid field in the Creature class
        }
    }
}
