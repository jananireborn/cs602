
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class FileAverage extends JApplet implements ActionListener {

	// TODO Auto-generated method stub
	String line = null;
	FileAverage e;
	JLabel label1, label2;
	JTextField text1;
	JTextArea text2;
	JButton button;
	String msg;

	public void init() {
		e = this;
		Pane p = new Pane();
		getContentPane().add(p);
		
		button.addActionListener(this);
	}

	class Pane extends JPanel {
		public Pane() {

			setBorder(BorderFactory.createEmptyBorder(200, 80, 200, 80));
			setMaximumSize(new Dimension(10, 10));// set maximum size

	

			text1 = new JTextField(5);
			text2 = new JTextArea(10,10);
			text2.setEditable(false);
			button = new JButton("Calculate Average");
			label1 = new JLabel("Enter File name");
			label2 = new JLabel("Factorial ");
            label2.setVisible(false);
    		setLayout(new GridLayout(1, 1, 10, 5));            
			add(label1);
			add(text1);
			setLayout(new GridLayout(2, 1, 10, 5));
			add(button);
			setLayout(new GridLayout(3, 1, 10, 10));
			add(label2);
			add(text2);

			

		}
	}

	public void actionPerformed(ActionEvent ae) {
		String strID = ae.getActionCommand();
		text2.setText("");
		String Filename = text1.getText();

		try {
			BufferedReader br1 = new BufferedReader(new FileReader(Filename));

			try {

				int total = 0;
				int value;
				int TotalNeg = 0;
				int TotVal = 0;

				while ((line = br1.readLine()) != null) {
					try {

						value = Integer.parseInt(line);

						if (value < 9) {

							TotVal = TotVal + value;

							total++;
						}

						else {
							TotalNeg++;
						}

					}

					catch (Exception m) {
						System.out.println(m);
						text2.append ("Invalid Value in the File " + "'" + line + "'\n");
					}

				}
				float Average = TotVal / total;
				String a = Float.toString(Average);
				text2.append("Average is " + a + "\n");
				
				br1.close();
				// System.out.println( "Average is " + Average );

				// System.out.println( "No. of Records Processed " + total );
				// System.out.println( "No. of Records Neglected " + TotalNeg );
			} catch (NumberFormatException e) {
				System.out.println("Value" + line + " is not a valid input\n");
			}
		} catch (Exception f) {
			text2.append("Invalid File path / name \n");
			
			System.out.println(f);
		}
		
	}
	// }
	// }
	// }

}
