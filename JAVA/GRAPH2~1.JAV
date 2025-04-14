/**
 * This program displays a frame with exit processing.
 * Copyright John B 07-Sep-1998
 *
 * @author John Braddock
 * @version 1.01
 */
import java.awt.Frame;
import java.awt.Button;
import java.awt.event.*;

public class Graph2 extends Frame implements ActionListener {
    public static void main (String args[]) {
        boolean   sts        = true;
        System.out.println("Johno's Grapher with exit processing");
	new Graph2();

	System.out.println("End Of grapher");

    }

    public Graph2() {
	setTitle ("John's Frame with exit processing");
	setSize(400,500);
	Button but1 = new Button("Exit");
	but1.addActionListener(this);
	add(but1);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
	System.exit(0);
    }

}
//////////////////////////////////////////////////////////////////////////////
