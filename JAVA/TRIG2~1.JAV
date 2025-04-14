/** Part 2 of Assignment 1 of Java Course.
 * This program calculates a list of Cosine and Sine values.
 * A graph is then drawn of the calculated values.
 * Copyright John B 07-Sep-1998
 *
 * This routine expects 1 arg when it is called.
 *	Arg[0] is the step size for the list. If not supplied, it defaults
 *             to 0.1 .
 *
 * @author John Braddock
 * @version 1.01
 */
import java.awt.*;
import java.awt.event.*;

class Trig2 extends Frame implements ActionListener {
       boolean   sts        = true;

    float  xIn       = 0;
    float  xStepSize = 0;
    float  cosOut    = 0;
    float  sinOut    = 0;
    final  float PI  = 3.14159f;
    float  p1        = 0f;

    public static void main (String args[]) {
	Float	  fp1	     = new Float(0);

        System.out.println("Johno's Trigonometrica Version 1.01");
        Trig2 trig2 = new Trig2();

        if ( args.length == 0) {
	    System.out.println("No Param supplied, int set to 0.1");
	    trig2.p1 = 0.1f;
            }
        else {
	    System.out.println("Interval from Param=" + args[0]);
	    fp1 = Float.valueOf(args[0]);
	    trig2.p1  = fp1.floatValue();
        }

        trig2.trigit2(trig2.p1);
    }
    public void Trig2() {
        System.out.println("At T2");
    }

    public void trigit2(float p1) {
	xStepSize= p1;
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
	while (sts == true) {
	    sts=calcSinCos();	
	    int xPlot = (int) (100 * xIn);
	    int ycPlot = (int) (200 * ((cosOut * -1) + 1)+50);
	    int ysPlot = (int) (200 * ((sinOut * -1) + 1)+50);
	    g.setColor(Color.magenta);
	    g.fillOval(xPlot,ycPlot,03,03);
//	    System.out.println("calc=" + sinOut + " -- " + ysPlot);
	    g.setColor(Color.orange);
	    g.fillOval(xPlot,ysPlot,03,03);
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
