import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Janani
 * 
 */
public class CodeBase extends JApplet implements ActionListener {

	int factorial;
	JLabel label1, label2;
	JTextField text1, text2;
	JTextArea text3;
	String url;
	JButton button;
	JButton button1;
	String msg;
	CodeBase e;

	public void init() {
		e = this;

		Pane p = new Pane();
		getContentPane().add(p);

		button.addActionListener(this);
//		button1.addActionListener(this);
		button.setSize(3,10);
	}

	class Pane extends JPanel {
		public Pane() {

		setBorder(BorderFactory.createEmptyBorder(100,80,100,80));
		setMaximumSize(new Dimension(1, 3));// set maximum size

			setLayout(new GridLayout(3, 2, 180, 20));

			button = new JButton("Get Code/Doc Base");
			
//			button1 = new JButton("Get doc base");

			label1 = new JLabel("Click button to get code and document base");

			text3 = new JTextArea(5,5);
			add(label1);
			add(button);
			add(text3);
//			add(button1);
			
		}
	}

	public void actionPerformed(ActionEvent ae) {
		text3.setText("");
		if (ae.getActionCommand() == button.getActionCommand()) {
			text3.append("Code Base: " + getCodeBase().toString() + "\n" );
			text3.append("Doc  Base: " + getDocumentBase().toString());
  
		} else {

			
		}
	
	}
	

}
