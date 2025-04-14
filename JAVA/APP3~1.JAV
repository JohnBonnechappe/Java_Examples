import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class App3 extends Applet implements ActionListener {
    TextField infld1 = new TextField("Type Me",10);
    TextField infld2 = new TextField(" ",10);

    public void init() {
	setLayout (new FlowLayout() );
        add(infld1);

	Button but1 = new Button("Press Me");
	but1.addActionListener(this);
	add(but1);

        add(infld2);
    }

      public void actionPerformed(ActionEvent event) {
	String ws=infld1.getText();
	infld1.setText("see next");
	infld2.setText(ws);
      }

    public void paint(Graphics g) {
        g.drawString("Hello World!", 20, 150);
        g.drawString("Hello Sofiya!", 20, 180);
    }
}
