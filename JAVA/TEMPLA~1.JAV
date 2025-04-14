import java.awt.*;
import java.applet.Applet;

/**
  * Skeleton for trigonometry table printer class.<br>
  *
  * WHAT DOES IT DO?
  *
  * @author 
  * @version 
  */
public class TrigTable extends Applet {

    public void init() {
	  // Add the Label objects for the key
	  setLayout(new FlowLayout());
	  Label ... = new Label(...);
	  ... .setForeground(Color. ...);
	  add(...);

    }

    /**
      * Exits the system when the WINDOW_DESTROY event is received.
      * Only applicable to running through the Appletviewer.
      *
      * @param
      */
    public boolean handleEvent(Event evt) {
	...
    }

    /**
      * The default <code>paint</code> method inherited from <code>Component</code>.
      * <p>
      * WHAT DOES THIS ONE DO?
      *
      * @param 
      */
    public void paint(Graphics g) {
	  for (...) {
		// should we use wrapper classes for comparison here???
		g.setColor(...);
		g.fillOval(...);
	    }

	  // Draw 3 horizontal lines at positions -1, 0 and 1 (scaled of course)
	  g.setColor(...);
	  g.drawLine(...);

    }
}
