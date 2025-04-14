/**
 * This program displays a frame with exit processing.
 * this version also adds a panel and has a different colour.
 * Plus some graph points plotted.
 * Copyright John B 07-Sep-1998
 *
 * @author John Braddock
 * @version 1.01
 */

import java.awt.*;
import java.awt.event.*;

public class Graph4 extends Frame implements ActionListener {
    int x_coord = 0;
    int y_coord = 0;

    public static void main (String args[]) {
        boolean   sts        = true;
        System.out.println("Johno's Grapher with exit processing");
	new Graph4();

	System.out.println("End Of grapher");

    }

    public Graph4() {
	setTitle ("John's Frame with exit processing");
	x_coord=120; y_coord=250;
	setSize(800,500);
	setLayout(new FlowLayout() );
	Panel pan1 = new Panel();
	x_coord=220; y_coord=350;
	pan1.setLayout(new BorderLayout() );
	pan1.setBackground(Color.blue);
	add(pan1);
	Button but1 = new Button("Exit");
	but1.addActionListener(this);
	x_coord=420; y_coord=450;
	add(but1);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
	System.exit(0);
    }

    public void paint(Graphics g) {
	g.setColor(Color.blue);
	g.drawString("Java Graphics Illustration",80,40);
	g.drawString("Graph of Sine and Cosine",550,40);
	g.setColor(Color.pink);
	g.drawLine(0, 60,800, 60);
	g.drawLine(0,250,800,250);
	g.drawLine(0,450,800,450);
	g.setColor(Color.orange);
	g.fillOval(x_coord,y_coord,03,03);
    }

}
//////////////////////////////////////////////////////////////////////////////
