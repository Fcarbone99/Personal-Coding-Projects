/**
 * Represents a fire evolution class that will override to its specific evolution
 * based on what creature it is, how many points it gets,
 * and what other creatures it interacts with
 * 
 * @author Frankie Carbone
 */
public abstract class FireEvolution extends PokeEvo {

    /**
     * Constructor for the FireEvolution class.
     * 
     * @param name           the name of the creature
     * @param x              the x-coordinate of the creature
     * @param y              the y-coordinate of the creature
     * @param size           the fixed size of the creature
     * @param moveRate       the move rate (speed) of the creature
     * @param canCannibalize whether the creature can cannibalize its own type
     */
    public FireEvolution(String name, int x, int y, int size, int moveRate, boolean canCannibalize, Creature decoratedPokemon) {
        super(name, x, y, size, moveRate, canCannibalize, decoratedPokemon);
    }

    /**
     * Retrieves the description of the Pokemon, with an added description of the fire-type evolution.
     * 
     * @return The description of the Pokemon, including its fire evolution state.
     */
    @Override
    public String getDescription() {
        return decoratedPokemon.getDescription() + " -> Fire Evolution!";
    }

    /**
     * Handles the Pokemon eating another Pokemon and evolving if the target is a GrassCreature.
     * If the target is not a GrassCreature, the action is denied.
     * 
     * @param target The target Pokemon to be eaten.
     */
    public void eat(Creature target) {
        if (target instanceof GrassCreature) {
            decoratedPokemon.gainPoints(); // Assuming gainPoints is a method in Creature class
            System.out.println("Fire Pokémon has evolved after eating Grass Pokémon! Power increased.");
            decoratedPokemon.points += 20; // Assuming points is a valid field in the Creature class
        } else {
            System.out.println("Fire Pokémon can only eat Grass Pokémon!");
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
            System.out.println("Fire Pokémon evolved by moving a long distance! Power increased.");
            decoratedPokemon.points += 10; // Assuming points is a valid field in the Creature class
        }
    }
}
