import java.awt.*;
import java.applet.*;
public class App1 extends Applet {
    TextField infld1 = new TextField("Type Me");

    public void init() {
        add(infld1);
    }

    public void paint(Graphics g) {
        g.drawString("Hello World!", 20, 150);
        g.drawString("Hello Sofiya!", 20, 180);
    }
}
