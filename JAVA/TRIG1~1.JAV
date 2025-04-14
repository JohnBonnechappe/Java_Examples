/** Part 1 of Assignment 1 of Java Course.
 * This program calculates a list of Cosine and Sine values.
 * The list is then presented on the screen.
 * Copyright John B 14-Aug-1998
 *
 * This routine expects 1 arg when it is called.
 *	Arg[0] is the step size for the list. If not supplied, it defaults
 *             to 0.1 .
 *
 * @author John Braddock
 * @version 1.01
 */
class Trig1 {
    public static void main (String args[]) {
        boolean   sts        = true;
        SinCosCls sinCosObj  = new SinCosCls();
	float     p1         = 0f;

	Float	  fp1	     = new Float(0);

        System.out.println("Johno's Trigonometrica Version 1.01");

        if ( args.length == 0) {
	    System.out.println("No Param supplied, int set to 0.1");
	    p1 = 0.1f;
            }
        else {
	    System.out.println("Interval from Param=" + args[0]);
	    fp1 = Float.valueOf(args[0]);
	    p1  = fp1.floatValue();
        }

	sinCosObj.doHeading();

	sinCosObj.setStepSize(p1);

	while (sts == true) {
		sts=sinCosObj.calcSinCos();	
		System.out.println(" " + sinCosObj.toString());
	}

	System.out.println("End Of List");

    }
}
class SinCosCls {
	float  xStepSize = 0;
        int    stepNo    = 0;
	float  xIn       = 0;
        float  cosOut    = 0;
        float  sinOut    = 0;

	final float PI   = 3.14159f;

        public void SinCosCls() {
	    xStepSize= 0;
            stepNo   = 0;
	    xIn      = 0;
	    cosOut   = 0;
	    sinOut   = 0;
        }

        public void doHeading() {
	    System.out.println(" x      " + "  Cos(x)      " + "      Sin(x)");
        }

        public void setStepSize(float xStepSize) {
	    this.xStepSize = xStepSize;
        }

        public boolean calcSinCos() {
	    boolean bstat = true;
	    stepNo = stepNo + 1;
	    cosOut = (float) java.lang.Math.cos(xIn);
	    sinOut = (float) java.lang.Math.sin(xIn);
	    xIn	   = xIn + xStepSize;

            if ( xIn >= 2 * PI) {
		bstat = false;
	    }

           return bstat;
        }

        public String toString() {
	    float fIn;
	    fIn = xIn;
            return (fIn + "     " + cosOut + "     " + sinOut);
        }

}
//////////////////////////////////////////////////////////////////////////////
