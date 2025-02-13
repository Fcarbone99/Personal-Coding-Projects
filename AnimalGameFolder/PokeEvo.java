/**
 * The abstract Decorator class that evolves the Pokemon.
 * This class allows dynamic addition of evolution-related behavior
 * to any existing Pokemon type. It wraps an existing Pokemon object 
 * and extends its behavior without modifying the original class.
 * 
 * This is based off a pokemon(creature) class Kam will create
 * /*
    * 
    * @author Frankie Carbone
    */
    
 
    public abstract class PokeEvo extends Creature {
    
        /**
         * The Pokemon instance being decorated (wrapped).
         * This will hold the current state of the Pokemon, and any
         * additional evolution behaviors will be added to it.
         */
        protected Creature decoratedPokemon;
    
        /**
         * Constructor to initialize the decorated Pokemon object.
         * 
         * @param decoratedPokemon The Pokemon object that will be decorated with evolution features.
         */
        public PokeEvo(String name, int x, int y, int size, int moveRate, boolean canCannibalize, Creature decoratedPokemon) {
            super(name, x, y, size, moveRate, canCannibalize); // Call the Creature constructor
            this.decoratedPokemon = decoratedPokemon;
        }
    
        

        /**
         * Retrieves the description of the Pokemon, including any evolutions.
         * This method will delegate to the wrapped Pokemon's getDescription method.
         * 
         * @return The description of the Pokemon, including evolution details if any.
         */
        public String getDescription() {
            return decoratedPokemon.getDescription();
        }
    
        /**
         * Handles the movement of the Pokemon.
         * This method will delegate to the wrapped Pokemon's move method.
         * This method may be made into another class that decides movement based
         * on type of pokemon it is
         * 
         * @param distance The distance the Pokemon moves on the game board.
         */
        public void move(int distance) {
            decoratedPokemon.move();
        }
    
        /**
         * Handles the eating action of the Pokemon.
         * This method will delegate to the wrapped Pokemon's eat method.
         * This method will be unique to whatever pokemon uses it
         */
        public void eat() {
            decoratedPokemon.eat();
        }
    }