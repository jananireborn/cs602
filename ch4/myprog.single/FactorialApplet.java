import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * 
 */

/**
 * @author Janani
 *
 */
public class FactorialApplet extends JApplet implements ActionListener{

	/**
	 * @param args
	 */
	int factorial;
	JLabel label1, label2;
	JTextField text1, text2;
	JButton button;
	String msg;
	FactorialApplet e;
	public void init()
	{	e=this;

Pane p=new Pane();
getContentPane().add(p);

		button.addActionListener(this);
 
	}


class Pane extends JPanel
{
public Pane()
{

setBorder(BorderFactory.createEmptyBorder(200,80,200,80));
setMaximumSize(new Dimension(10,10));//set maximum size

setLayout(new GridLayout(3,2,10,5));

		 text1=new JTextField(5);
		 text2=new JTextField(10);
		button=new JButton("Calculate Factorial");
		label1=new JLabel("Enter Number");
		label2=new JLabel("Factorial ");

    	add(label1);	
		add(text1);
	
		add(label2);
    	add(text2);
	
		add(button);


}
}
	public void actionPerformed(ActionEvent ae)
	{
		String str=text1.getText();
		if(str!="")
		{
		int number=Integer.parseInt(str);
		int fact = 1;
		if ( number == 0 )
	        {
			fact = 1;
	        }
		else 
	        {


	        // return  fact * fact(parseInt - 1);
			while ( number != 0 )
			{
				fact = fact * number;
				number--;
				
			}
		msg=" " +fact;
		text2.setText(msg);
		fact=1;
		}
 
	}

	
}
}
