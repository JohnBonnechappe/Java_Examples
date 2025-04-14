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

public class Graph6 extends Frame implements ActionListener {
    int x_coord = 0;
    int y_coord = 0;
    int paint_action = 0;

    public static void main (String args[]) {
        boolean   sts        = true;
        System.out.println("Johno's Grapher with exit processing");
	new Graph6();

	System.out.println("End Of grapher");

    }

    public Graph6() {
	paint_action = 0;
	setTitle ("John's Frame with exit processing");
	setSize(800,500);
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

    public void paint(Graphics g) {
	g.setColor(Color.blue);
	g.drawString("Java Graphics Illustration",80,40);
	g.drawString("Graph of Sine and Cosine",550,40);
	g.setColor(Color.pink);
	g.drawLine(0, 60,800, 60);
	g.drawLine(0,250,800,250);
	g.drawLine(0,450,800,450);
	g.setColor(Color.orange);
	while (sts == true) {
	    sts=calcSinCos();	
	    int xPlot = (int) (800 * xIn);
	    int ycPlot = (int) (200 * cosOut);
	    g.fillOval(xPlot,ycPlot,03,03);
	}
    }
    public boolean calcSinCos() {
	    boolean bstat = true;	
	    cosOut = (float) java.lang.Math.cos(xIn);
	    sinOut = (float) java.lang.Math.sin(xIn);
	    xIn	   = xIn + xStepSize;

            if ( xIn >= 2 * PI) {
		bstat = false;
	    }

           return bstat;
    }
}
//////////////////////////////////////////////////////////////////////////////
