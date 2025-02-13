import java.util.ArrayList;
import java.util.List;

/**
 * notifies each board object when a creature moves
 * 
 * @author Robert Fanzutti
 */
public class BoardObjectSubject {

     // List of BoardObjects on the board
    private List<BoardObject> boardObjects;

    /**
     * constructor for boardObjects arrayList
     */
    public BoardObjectSubject() {
        this.boardObjects = new ArrayList<>();
    }

    /**
     * subscribes a new creature to the simulation
     * @param newCreature the creature being added to the simulation
     */
    public void addBoardObject(BoardObject newBoardObject){
        boardObjects.add(newBoardObject);
    }

    /**
     * unsubscribes a creature from the simulation
     * @param deadCreature creature being removed
     */
    public void removeBoardObject(BoardObject oldBoardObject){
        int index = boardObjects.indexOf(oldBoardObject);
        boardObjects.remove(index);
    }

    /**
     * notifies each board object that a creature has moved
     * @param creature the creature that moved
     */
    public void notify(Creature creature){
        for (BoardObject bo : boardObjects){
            bo.checkInteraction(creature);
        }
    }


}
