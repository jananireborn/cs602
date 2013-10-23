


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class EmailGenerator extends JApplet implements ActionListener {

	String line = null;
	EmailGenerator e;
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
			setMaximumSize(new Dimension(5, 5));// set maximum size

			text1 = new JTextField(5);
			text2 = new JTextArea(10, 10);
			text2.setEditable(false);
			button = new JButton("Generate Email File");
			label1 = new JLabel("Enter Folder name");
			label2 = new JLabel("Factorial ");
			label2.setVisible(false);
			setLayout(new GridLayout(1, 1, 1, 2));
			add(label1);
			add(text1);
			setLayout(new GridLayout(2, 1, 1, 2));
			add(button);
			setLayout(new GridLayout(3, 1, 1, 2));
			add(label2);
			add(text2);
		}
	}

	public void actionPerformed(ActionEvent ae) {

		String fname, lname, ssn, email;
		text2.setText("");
		String Filename = (text1.getText() + "students.txt");

		try {

			BufferedReader br1 = new BufferedReader(new FileReader(Filename));
			FileWriter fout = new FileWriter(text1.getText()
					+ "studentemail.txt");
			BufferedWriter bw = new BufferedWriter(fout);
			try {
				// BufferedWriter bw;
				String args[];
				String Delimiter = ":";

				while ((line = br1.readLine()) != null) {

					args = line.split(Delimiter);
					fname = args[0].substring(0, 1);
					fname = fname.toLowerCase();

					lname = args[1].substring(0, 1);
					lname = lname.toLowerCase();

					ssn = args[2].substring(5, 9);

					email = fname + lname + ssn + "@" + "se.depaul.edu";

					bw.write(email + "\r\n");

				}
				text2.append("Source file: " + Filename + "\n");
				text2.append("Destination File: " + text1.getText()
						+ " studentemail.txt");
				bw.close();
				br1.close();

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
