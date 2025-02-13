
import java.awt.BorderLayout;
import javax.swing.*;

/**
 * Abstract class used to extend JPanel from swing package
 * used to create basic abstract frame as well as abstract
 * methods implemented within the different screens
 * @author Lauren Cedrone
 */

abstract class abstractFrame extends JPanel {
    protected JLabel label; //displays text on screen about what is going on in that step
    protected JLabel graphicLabel; //displays image that corresponds to what is going on
    protected JButton button; // button to navigate to the next "slide"

/**
 * constructor class to make common layout for the screen classes which fully 
 * implement it 
 */
    public abstractFrame(){
        
        setLayout(new BorderLayout());

        /**
         * general text label implementation
         */
        label = new JLabel("", SwingConstants.CENTER);
        add(label, BorderLayout.NORTH);

        /**
         * general graphic label to place path of image in
         */
        graphicLabel = new JLabel("", SwingConstants.CENTER);
        add(graphicLabel, BorderLayout.CENTER);

        /**
         * general button 
         */
        button = new JButton("Next");
        button.addActionListener(e -> onNextButtonClick());
        add(button, BorderLayout.SOUTH);
         }


         /**
          * templates for abstract methods to be fully defined 
          in screen classes
          */
        protected abstract void configureScreen();
        protected abstract String getImagePath();
        protected abstract void onNextButtonClick();

        /**
         * method used to create the image icon and set the image path 
         * @param imagePath
         */
        protected void setImage(String imagePath){
            ImageIcon icon = new ImageIcon(imagePath);
            graphicLabel.setIcon(icon);
        }

    }

