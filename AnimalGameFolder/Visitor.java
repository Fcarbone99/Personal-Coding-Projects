/**
 * Interface defining the Visitor pattern for handling operations
 * Concrete implementationsn of this interface define specific
 * actions for each type of creature.
 */
public interface Visitor {
    public void visit(FireCreature fireCreature);
    public void visit(WaterCreature waterCreature);
    public void visit(GrassCreature grassCreature);
}
