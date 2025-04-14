/**
 * This program displays a frame with exit processing.
 * this version also adds a panel and has a different colour.
 * Copyright John B 07-Sep-1998
 *
 * @author John Braddock
 * @version 1.01
 */

import java.awt.*;
import java.awt.event.*;

public class Graph3 extends Frame implements ActionListener {
    public static void main (String args[]) {
        boolean   sts        = true;
        System.out.println("Johno's Grapher with exit processing");
	new Graph3();

	System.out.println("End Of grapher");

    }

    public Graph3() {
	setTitle ("John's Frame with exit processing");
	setSize(400,500);
	setLayout(new FlowLayout() );
	Panel pan1 = new Panel();
	pan1.setLayout(new BorderLayout() );
	pan1.setBackground(Color.blue);
	add(pan1);
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
