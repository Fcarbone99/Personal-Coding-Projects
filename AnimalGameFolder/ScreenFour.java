import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;

/**
 * class implementing specifics for the second screen 
 * to be shown within the simulation 
 * overrides and implements the abstract methods
 * found in abstractScreen
 * @author Lauren Cedrone
 */

public class ScreenFour extends abstractFrame {
    public ScreenFour(){
        configureScreen();
    }

    @Override
    protected void configureScreen() {
        label.setText("Yum! When Cliff eats, it helps him grow.");
        label.setFont(new Font("Ariel", Font.BOLD, 20));
        setImage(getImagePath());
    }

    @Override
    protected String getImagePath() {
    return "codespace\\grassGuyBig.png";
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
        if(parent != null && parent.getLayout() instanceof CardLayout) {
            CardLayout layout = (CardLayout) parent.getLayout();
            layout.next(parent);
        }
    }
}

