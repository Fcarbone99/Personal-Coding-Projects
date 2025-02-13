import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private final int size;
    private final List<Creature> creatures;
    private final Creature[][] grid;
    private Random random = new Random();
    private static Board instance = null;
    private List<Obstacle> obstacles = new ArrayList<>();
    private BoardObjectSubject BOS = new BoardObjectSubject();

    private Board(int size) {
        this.size = size;
        this.grid = new Creature[size][size];
        this.creatures = new ArrayList<>();
        this.obstacles = new ArrayList<>();
    }

    public static Board getBoard(int size) {
        if (instance == null) {
            instance = new Board(size);
        }
        return instance;
    }

    public List<Creature> getCreatures() {
        return creatures;
    }

    public void populateCreatures() {
        // Example creature initialization
        Creature fireCreature = new FireCreature(0, 0, true);
        Creature grassCreature = new GrassCreature(0, 0, false);
        Creature waterCreature = new WaterCreature(0, 0, false);

        FirePlantDecorator firePlant = new FirePlantDecorator(new SuperPlant(0, 0));
       // FirePlantDecorator firePlant2 = new FirePlantDecorator(new PoisonPlant(0, 0));
        WaterPlantDecorator waterPlant = new WaterPlantDecorator(new SuperPlant(0, 0));
      //  WaterPlantDecorator waterPlant2 = new WaterPlantDecorator(new NormalPlant(0, 0));
        GrassPlantDecorator grassPlant = new GrassPlantDecorator(new PoisonPlant(0, 0));
      //  GrassPlantDecorator grassPlant2 = new GrassPlantDecorator(new SuperPlant(0, 0));

        BOS.addBoardObject(fireCreature);
        BOS.addBoardObject(waterCreature);
        BOS.addBoardObject(grassCreature);
       // BOS.addBoardObject(grassPlant2);
        BOS.addBoardObject(grassPlant);
     //   BOS.addBoardObject(waterPlant2);
        BOS.addBoardObject(waterPlant);
      //  BOS.addBoardObject(firePlant2);
        BOS.addBoardObject(firePlant);


     //   creatures.add(fireCreature);
     //   creatures.add(grassCreature);
      //  creatures.add(waterCreature);

        // Place creatures on the grid
        for (Creature creature : creatures) {
            int x = random.nextInt(size);
            int y = random.nextInt(size);
            if (grid[x][y] == null) {
                grid[x][y] = creature;
            }
        }
    }

    public void updateCreature(Creature oldCreature, Creature newCreature) {
        creatures.remove(oldCreature);
        creatures.add(newCreature);
    }

    public void addObstacle(Obstacle obstacle) {
        if (obstacle != null) {
            obstacles.add(obstacle);
            System.out.println("Obstacle added: " + obstacle.getName());
        } else {
            throw new IllegalArgumentException("Cannot add a null obstacle.");
        }
    }

    // Simulate creature interaction with obstacles
    public void interactWithObstacles(Creature creature) {
        for (Obstacle obstacle : obstacles) {
            obstacle.affectCreature(creature);
        }
    }


    public void update() {
        for (Creature creature : creatures) {
            creature.move();
            BOS.notify(creature);
            creature.performAction();
        }
    }

    public void runSimulation(int cycles) {
        populateCreatures();
        for (int cycle = 1; cycle <= cycles; cycle++) {
            System.out.println("Cycle " + cycle);
            for (Creature creature : creatures) {
            interactWithObstacles(creature);
            update();
        }
    }

    }
}
    