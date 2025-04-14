/** Part 4 of Assignment 1 of Java Course.
 * This program calculates a list of Cosine and Sine values.
 * A graph is then drawn on an Applet of the calculated values.
 * Copyright John B 26-Oct-1998
 *
 * This Applet expects 1 parameter when it is called.
 *	Param1 is the step size for the list. If not supplied, it defaults
 *             to 0.1 .
 *
 * When the applet appears, it is possible to enter a new step size, then
 * redraw the graph by pressing the "Redraw" button.
 * The coordinates of the mouse position are continuously displayed.
 * 
 * Issues:
 * This program works well in IE4 but has not been tested in Netscape. 
 *
 * @author John Braddock
 * @version 1.01
 */
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

class TrigTable4 extends Applet implements ActionListener, MouseMotionListener {
       boolean   sts        = true;
    TextField infld1 = new TextField("Step size",10);
    TextField infld2 = new TextField(" ",12);
    TextField infld3 = new TextField(" ",12);
    TextField infld4 = new TextField(" ",12);
    float  xIn       = 0;
    float  xStepSize = 0;
    float  cosOut    = 0;
    float  sinOut    = 0;
    final  float TWOPI  = 2 * 3.14159f;
    float  p1        = 0f;

    int    paintOpt	=1;

    int    xCoor	=0;
    int    yCoor	=0;


    public void init () {
	Float	  fp1	     = new Float(0);

	String prm1 = getParameter("prm1");

        if ( prm1 == "" || prm1 == null) {
	    infld2.setText("0.1 (dflt)");
	    p1 = 0.1f;
            }
        else {
	    infld2.setText(prm1);
	    fp1 = Float.valueOf(prm1);
	    p1  = fp1.floatValue();
        }
	xStepSize = p1;

	setLayout (new FlowLayout() );

//					goes better without a panel
//	Panel panel1	= new Panel();
//	panel1.setBackground(Color.red);
//	add(panel1);

//				field for entry of the new step size.
        add(infld1);

	Button but1 = new Button("Redraw");
	but1.addActionListener(this);
	add(but1);

	addMouseMotionListener(this);

//				this is to try to get the coordinates
//				to display even when over the button.
	but1.addMouseMotionListener(this);


//				field to show the new step size.
        add(infld2);
//				fields to display the mouse coordinates
        add(infld3);
        add(infld4);
    }

      public void actionPerformed(ActionEvent event) {
	Float	  fp1	     = new Float(0);
	String ws=infld1.getText();

	p1 = 0;

	if (ws == "" || ws == " ") {
	    p1 = 0;
	}
	else {
	    fp1 = Float.valueOf(ws);
	    p1  = fp1.floatValue();
	}

	if (p1 < 0.0001 ) {
	    xStepSize = 0.0001f;
	    infld2.setText("0.0001 (min)");
	    }
	else {
	    xStepSize = p1;
	    infld2.setText(ws);
	    }
	paintOpt=1;
	repaint();
      }

    public void mouseDragged(MouseEvent evt) {
    }

    public void mouseMoved(MouseEvent evt) {	
	String strC = " ";

	xCoor = evt.getX();
	strC = "X=" + strC.valueOf(xCoor);
	infld3.setText(strC);

	yCoor = evt.getY();
	strC = "Y=" + strC.valueOf(yCoor);
	infld4.setText(strC);


	paintOpt=0;
	repaint();
    }

    public void paint(Graphics g) {
//	if (paintOpt == 1 ) {
	    g.setColor(Color.blue);
	    g.drawString("Java Graphics Illustration",10,40);
	    g.drawString("Graph of Sine and Cosine",450,40);
	    g.setColor(Color.pink);
	    g.drawLine(0, 50,650, 50);
	    g.drawLine(0,150,650,150);
	    g.drawLine(0,250,650,250);
	    sts = true;
	    xIn = 0;
	    while (sts == true) {
	        sts=calcSinCos();	
	        int xPlot = (int) (100 * xIn);
	        int ycPlot = (int) (100 * ((cosOut * -1) + 1)+50);
	        int ysPlot = (int) (100 * ((sinOut * -1) + 1)+50);
	        g.setColor(Color.magenta);
	        g.fillOval(xPlot,ycPlot,03,03);
	        g.setColor(Color.orange);
	        g.fillOval(xPlot,ysPlot,03,03);
	    }
//	}
//	else {
//	}
    }

        public boolean calcSinCos() {
	    boolean bstat = true;
	    cosOut = (float) java.lang.Math.cos(xIn);
	    sinOut = (float) java.lang.Math.sin(xIn);
	    xIn	   = xIn + xStepSize;

            if ( xIn >= TWOPI) {
		bstat = false;
	    }

           return bstat;
        }

    
}
//////////////////////////////////////////////////////////////////////////////
