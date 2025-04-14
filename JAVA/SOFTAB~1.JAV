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
public class TrigTable3 extends Applet {
         String paramString  = " " ;
         static double increment = 0.0d;
         int scaleFactor = 0;
         double xval     = 0.0d;
         double cosval     = 0d;
         double sinval     = 0d;
         final   double TWOPI     = 2 * 3.14159d;
         boolean status    = true;

    public void init() {
        paramString = getParameter("param1");
        Double dincrement = new Double(0);

        if (paramString == " ") {
        
             increment = 0.1d;
            }
         else {
            
            dincrement = Double.valueOf(paramString);
            increment = dincrement.doubleValue();
            
         }      
           
     }
      public void start() {                
 
	  // Add the Label objects for the key
	  setLayout(new FlowLayout());
	  Label sinlabl = new Label("Sine");
	  sinlabl.setForeground(Color.green);
	  add(sinlabl);

	  setLayout(new FlowLayout());
	  Label coslabl = new Label("Cosine");
	  coslabl.setForeground(Color.green);
	  add(coslabl);


          Double dincrement = new Double(0);

 
//        TrigTable3 trigtable = new TrigTable3();
          trigtable3(increment);                  


     }
    
    public void trigtable3(double increment) {
        xval = increment;
        setLayout(new FlowLayout() );
//        setVisible(true);

     }            

    

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(0,60,800,60);
        g.drawLine(0,200,800,200);
        g.drawLine(0,350,800,350);
        while (status == true) {
              status = GetSinCos() ;
              int xPoint = (int) (120 * xval);
              int yCosPoint = (int) (150 * ((cosval * -1) + 1) + 50);
              int ySinPoint = (int) (150 * ((sinval * -1) + 1) + 50);
        g.setColor(Color.red);
        g.fillOval(xPoint,yCosPoint,03,03);

        g.setColor(Color.blue);
        g.fillOval(xPoint,ySinPoint,03,03);


      }

    }
      public boolean GetSinCos() {
             boolean stat = true;
             sinval = (double) java.lang.Math.sin(xval);
             cosval = (double) java.lang.Math.cos(xval);
             xval = xval + increment ;
             if (xval >= TWOPI) {
                 stat = false;
             }
             return stat;

      }


}








 
