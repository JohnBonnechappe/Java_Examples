import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class App2 extends Applet implements ActionListener {
    TextField infld1 = new TextField("Type Me");

    public void init() {
	setLayout (new FlowLayout() );
        add(infld1);

	Button but1 = new Button("Exit");
	but1.addActionListener(this);
	add(but1);
    }

      public void actionPerformed(ActionEvent event) {
	infld1.setText("new text");
      }

    public void paint(Graphics g) {
        g.drawString("Hello World!", 20, 150);
        g.drawString("Hello Sofiya!", 20, 180);
    }
}
