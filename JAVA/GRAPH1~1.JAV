/** 
 * This program displays a frame.
 * Copyright John B 07-Sep-1998
 *
 * @author John Braddock
 * @version 1.01
 */
import java.awt.Frame;

public class Graph1 extends Frame {
    public static void main (String args[]) {
        boolean   sts        = true;
        System.out.println("Johno's Grapher");
	new Graph1();

	System.out.println("End Of grapher");

    }

    public Graph1() {
	setTitle ("John's Frame");
	setSize(200,200);
        setVisible(true);
        }

}
//////////////////////////////////////////////////////////////////////////////
