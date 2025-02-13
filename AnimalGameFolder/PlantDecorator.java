

/**
 * parent class of all decorators
 * 
 * @author Robert Fanzutti
 */
public abstract class PlantDecorator extends Plant{
    protected Plant plant;//the plant being decorated
    
    /**
     * constructor for decorator
     * @param plant the plant being decorated
     */
    protected PlantDecorator(Plant plant){
        this.plant = plant;
    }
}

