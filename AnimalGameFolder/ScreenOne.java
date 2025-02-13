
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;

/**
 * class implementing specifics for the first screen 
 * to be shown within the simulation 
 * overrides and implements the abstract methods
 * found in abstractScreen
 * @author Lauren Cedrone
 */

public class ScreenOne extends abstractFrame{

    public ScreenOne(){
        configureScreen();
    }

    @Override
    protected void configureScreen() {
        label.setText("Welcome to Animal Simulation!");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        setImage(getImagePath());
    }

    @Override
    protected String getImagePath() {
    return "codespace\\frog.png";
    }

    /**
     * helps track which screen it will be going to next 
     * and allows for the simulation to be ran continuously 
     * if desired, can only be closed if you 'x' out of the 
     * screen pop up itself
     */
    @Override
    protected void onNextButtonClick() {
        Container parent = getParent();
        if(parent.getLayout() instanceof CardLayout) {
            CardLayout layout = (CardLayout) parent.getLayout();
            layout.next(parent);
        }
    }

}
