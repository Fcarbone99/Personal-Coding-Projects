/**
 * Represents a grass evolution class that will override to its specific evolution
 * based on what creature it is, how many points it gets,
 * and what other creatures it interacts with or plants it interacts with
 * 
 * @author Frankie Carbone
 */
public abstract class GrassEvolution extends PokeEvo {

    /**
     * Constructor for the GrassEvolution class.
     * 
     * @param name           the name of the creature
     * @param x              the x-coordinate of the creature
     * @param y              the y-coordinate of the creature
     * @param size           the fixed size of the creature
     * @param moveRate       the move rate (speed) of the creature
     * @param canCannibalize whether the creature can cannibalize its own type
     */
    public GrassEvolution(String name, int x, int y, int size, int moveRate, boolean canCannibalize, Creature decoratedPokemon) {
        super(name, x, y, size, moveRate, canCannibalize, decoratedPokemon);
    }

    /**
     * Retrieves the description of the Pokemon, with an added description of the grass-type evolution.
     * 
     * @return The description of the Pokemon, including its grass evolution state.
     */
    @Override
    public String getDescription() {
        return decoratedPokemon.getDescription() + " -> Grass Evolution!";
    }

    /**
     * Handles the Pokemon eating a plant and evolving.
     * GrassEvolution can only eat plants, not other Pokemon.
     * 
     * @param plant The plant to be eaten.
     */
    public void eat(Plant plant) {
        System.out.println("Grass Pokémon has evolved after eating a plant! Power increased.");
        // Assuming 'points' is a valid field in the Creature class
        decoratedPokemon.points += 20;
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
            System.out.println("Grass Pokémon evolved by moving a long distance! Power increased.");
            decoratedPokemon.points += 10;
        }
    }
}
