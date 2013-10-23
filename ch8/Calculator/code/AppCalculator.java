import java.applet.Applet;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import javax.swing.*;

/**
 * @author Janani Swaminathan
 * @version 1.0
 * @since 11/08/2012
 */

@SuppressWarnings({ "serial", "unused" })
public class AppCalculator extends JApplet implements ActionListener,
		KeyListener {

	protected String operator = null;
	protected String Operand1 = null;
	protected String Operand2 = null;
	protected String firstOperand2 = null;

	protected Boolean isCalculated = false;
	static DecimalFormat numFormat = new DecimalFormat("###.##############");
	protected JTextField OutText;

	protected JButton Jbut1, Jbut2, Jbut3, Jbut4, Jbut5, Jbut6, Jbut7, Jbut8,
			Jbut9, Jbut10, Jbut11, Jbut12, Jbut13, Jbut14, Jbut15, Jbut16,
			Jbut17, Jbut18, Jbut19, Jbut20;

	/**
	 * Called by the browser or applet viewer to inform this applet that it has
	 * been loaded into the system. It is always called before the first time
	 * that the <code>start</code> method is called.
	 * <p>
	 * A subclass of <code>Applet</code> should override this method if it has
	 * initialization to perform. For example, an applet with threads would use
	 * the <code>init</code> method to create the threads and the
	 * <code>destroy</code> method to kill them.
	 * <p>
	 * The implementation of this method provided by the <code>Applet</code>
	 * class does nothing.
	 * 
	 * @see java.applet.Applet#destroy()
	 * @see java.applet.Applet#start()
	 * @see java.applet.Applet#stop()
	 */
	public void init() {

		Pane p = new Pane();
		getContentPane().add(p);

		Jbut1.addActionListener(this);
		Jbut2.addActionListener(this);
		Jbut3.addActionListener(this);
		Jbut5.addActionListener(this);
		Jbut6.addActionListener(this);
		Jbut7.addActionListener(this);
		Jbut8.addActionListener(this);
		Jbut9.addActionListener(this);
		Jbut10.addActionListener(this);
		Jbut11.addActionListener(this);
		Jbut12.addActionListener(this);
		Jbut13.addActionListener(this);
		Jbut14.addActionListener(this);
		Jbut15.addActionListener(this);
		Jbut16.addActionListener(this);
		Jbut17.addActionListener(this);
		Jbut18.addActionListener(this);
		Jbut19.addActionListener(this);
		Jbut20.addActionListener(this);
		OutText.addActionListener(this);
		OutText.addKeyListener(this);

	}

	class Pane extends JPanel {

		/**
		 * Pane Override method is for setting the grid and the layout property
		 * 
		 */
		public Pane() {
			setBackground(Color.lightGray);
			setLayout(new GridBagLayout());
			GridBagConstraints GrBagCon = new GridBagConstraints();

			OutText = new JTextField("");
			OutText.setFont(new Font("", Font.PLAIN, 22));

			OutText.setHorizontalAlignment(JTextField.RIGHT);
			// OutText.setEditable(true);

			GrBagCon.gridwidth = 5;
			GrBagCon.gridy = 1;
			GrBagCon.insets = new Insets(3, 3, 3, 3);
			GrBagCon.fill = GridBagConstraints.BOTH;
			((GridBagLayout) getLayout()).setConstraints(OutText, GrBagCon);
			add(OutText);

			Jbut1 = new JButton("<-");
			GrBagCon.gridheight = 1;
			GrBagCon.gridwidth = 1;
			GrBagCon.gridy = 1 / 5 + 2;
			GrBagCon.fill = GridBagConstraints.BOTH;
			((GridBagLayout) getLayout()).setConstraints(Jbut1, GrBagCon);
			Jbut1.setFont(new Font("", Font.BOLD, 18));
			add(Jbut1);

			Jbut2 = new JButton("C");
			GrBagCon.gridheight = 1;
			GrBagCon.gridwidth = 1;
			GrBagCon.gridy = 2 / 5 + 2;
			GrBagCon.fill = GridBagConstraints.BOTH;
			((GridBagLayout) getLayout()).setConstraints(Jbut2, GrBagCon);
			Jbut2.setFont(new Font("", Font.BOLD, 18));
			add(Jbut2);

			Jbut3 = new JButton("+/-");
			GrBagCon.gridheight = 1;
			GrBagCon.gridwidth = 1;
			GrBagCon.gridy = 3 / 5 + 2;
			GrBagCon.fill = GridBagConstraints.BOTH;
			((GridBagLayout) getLayout()).setConstraints(Jbut3, GrBagCon);
			Jbut3.setFont(new Font("", Font.BOLD, 18));
			add(Jbut3);

			Jbut8 = new JButton("/");
			GrBagCon.gridheight = 1;
			GrBagCon.gridwidth = 1;
			GrBagCon.gridy = 4 / 5 + 2;
			GrBagCon.fill = GridBagConstraints.BOTH;
			((GridBagLayout) getLayout()).setConstraints(Jbut8, GrBagCon);
			Jbut8.setFont(new Font("", Font.BOLD, 18));
			add(Jbut8);

			Jbut5 = new JButton("7");
			GrBagCon.gridheight = 1;
			GrBagCon.gridwidth = 1;
			GrBagCon.gridy = 5 / 5 + 2;
			GrBagCon.fill = GridBagConstraints.BOTH;
			((GridBagLayout) getLayout()).setConstraints(Jbut5, GrBagCon);
			Jbut5.setFont(new Font("", Font.BOLD, 18));
			add(Jbut5);

			Jbut6 = new JButton("8");
			GrBagCon.gridheight = 1;
			GrBagCon.gridwidth = 1;
			GrBagCon.gridy = 6 / 5 + 2;
			GrBagCon.fill = GridBagConstraints.BOTH;
			((GridBagLayout) getLayout()).setConstraints(Jbut6, GrBagCon);
			Jbut6.setFont(new Font("", Font.BOLD, 18));
			add(Jbut6);

			Jbut7 = new JButton("9");
			GrBagCon.gridheight = 1;
			GrBagCon.gridwidth = 1;
			GrBagCon.gridy = 7 / 5 + 2;
			GrBagCon.fill = GridBagConstraints.BOTH;
			((GridBagLayout) getLayout()).setConstraints(Jbut7, GrBagCon);
			Jbut7.setFont(new Font("", Font.BOLD, 18));
			add(Jbut7);

			Jbut12 = new JButton("*");
			GrBagCon.gridheight = 1;
			GrBagCon.gridwidth = 1;
			GrBagCon.gridy = 8 / 5 + 2;
			GrBagCon.fill = GridBagConstraints.BOTH;
			((GridBagLayout) getLayout()).setConstraints(Jbut12, GrBagCon);
			Jbut12.setFont(new Font("", Font.BOLD, 18));
			add(Jbut12);

			Jbut9 = new JButton("4");
			GrBagCon.gridheight = 1;
			GrBagCon.gridwidth = 1;
			GrBagCon.gridy = 9 / 4 + 2;
			GrBagCon.fill = GridBagConstraints.BOTH;
			((GridBagLayout) getLayout()).setConstraints(Jbut9, GrBagCon);
			Jbut9.setFont(new Font("", Font.BOLD, 18));
			add(Jbut9);

			Jbut10 = new JButton("5");
			GrBagCon.gridheight = 1;
			GrBagCon.gridwidth = 1;
			GrBagCon.gridy = 10 / 4 + 2;
			GrBagCon.fill = GridBagConstraints.BOTH;
			((GridBagLayout) getLayout()).setConstraints(Jbut10, GrBagCon);
			Jbut10.setFont(new Font("", Font.BOLD, 18));
			add(Jbut10);

			Jbut11 = new JButton("6");
			GrBagCon.gridheight = 1;
			GrBagCon.gridwidth = 1;
			GrBagCon.gridy = 11 / 4 + 2;
			GrBagCon.fill = GridBagConstraints.BOTH;
			((GridBagLayout) getLayout()).setConstraints(Jbut11, GrBagCon);
			Jbut11.setFont(new Font("", Font.BOLD, 18));
			add(Jbut11);

			Jbut18 = new JButton(".");
			GrBagCon.gridheight = 1;
			GrBagCon.gridwidth = 1;
			GrBagCon.gridy = 12 / 5 + 2;
			GrBagCon.fill = GridBagConstraints.BOTH;
			((GridBagLayout) getLayout()).setConstraints(Jbut18, GrBagCon);
			Jbut18.setFont(new Font("", Font.BOLD, 18));
			add(Jbut18);

			Jbut13 = new JButton("1");
			GrBagCon.gridheight = 1;
			GrBagCon.gridwidth = 1;
			GrBagCon.gridy = 13 / 4 + 2;
			GrBagCon.fill = GridBagConstraints.BOTH;
			((GridBagLayout) getLayout()).setConstraints(Jbut13, GrBagCon);
			Jbut13.setFont(new Font("", Font.BOLD, 18));
			add(Jbut13);

			Jbut14 = new JButton("2");
			GrBagCon.gridheight = 1;
			GrBagCon.gridwidth = 1;
			GrBagCon.gridy = 14 / 4 + 2;
			GrBagCon.fill = GridBagConstraints.BOTH;
			((GridBagLayout) getLayout()).setConstraints(Jbut14, GrBagCon);
			Jbut14.setFont(new Font("", Font.BOLD, 18));
			add(Jbut14);

			Jbut15 = new JButton("3");
			GrBagCon.gridheight = 1;
			GrBagCon.gridwidth = 1;
			GrBagCon.gridy = 15 / 4 + 2;
			GrBagCon.fill = GridBagConstraints.BOTH;
			((GridBagLayout) getLayout()).setConstraints(Jbut15, GrBagCon);
			Jbut15.setFont(new Font("", Font.BOLD, 18));
			add(Jbut15);

			Jbut16 = new JButton("-");
			GrBagCon.gridheight = 1;
			GrBagCon.gridwidth = 1;
			GrBagCon.gridy = 16 / 5 + 2;
			GrBagCon.fill = GridBagConstraints.BOTH;
			((GridBagLayout) getLayout()).setConstraints(Jbut16, GrBagCon);
			Jbut16.setFont(new Font("", Font.BOLD, 18));
			add(Jbut16);

			Jbut17 = new JButton("0");
			GrBagCon.gridheight = 1;
			GrBagCon.gridwidth = 1;
			GrBagCon.gridy = 17 / 4 + 2;
			GrBagCon.fill = GridBagConstraints.BOTH;
			((GridBagLayout) getLayout()).setConstraints(Jbut17, GrBagCon);
			Jbut17.setFont(new Font("", Font.BOLD, 18));
			add(Jbut17);

			Jbut19 = new JButton("+");
			GrBagCon.gridheight = 1;
			GrBagCon.gridwidth = 1;
			GrBagCon.gridy = 19 / 4 + 2;
			GrBagCon.fill = GridBagConstraints.BOTH;
			((GridBagLayout) getLayout()).setConstraints(Jbut19, GrBagCon);
			Jbut19.setFont(new Font("", Font.BOLD, 18));
			add(Jbut19);

			Jbut20 = new JButton("=");
			GrBagCon.gridheight = 1;
			GrBagCon.gridwidth = 2;
			GrBagCon.gridy = 20 / 5 + 2;
			GrBagCon.fill = GridBagConstraints.BOTH;
			((GridBagLayout) getLayout()).setConstraints(Jbut20, GrBagCon);
			Jbut20.setFont(new Font("", Font.BOLD, 18));
			add(Jbut20);

		}
	}

	
	/**
	 * Method to handle the events and display the results in the text area
	 * Invoked when an action occurs.
	 */
	@Override	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		if (cmd.equals("<-")) {
			String txt = OutText.getText();
			int l = txt.length();
			if (l > 0) {
				txt = txt.substring(0, l - 1);
				OutText.setText(txt);
			}
		} else if (cmd.equals("C")) {
			operator = null;
			Operand1 = null;
			Operand2 = null;
			firstOperand2 = null;
			OutText.setText("0");
		} else if (cmd.equals("CE")) {
			OutText.setText("0");
		} else if (cmd.equals("0") || cmd.equals("1") || cmd.equals("2")
				|| cmd.equals("3") || cmd.equals("4") || cmd.equals("5")
				|| cmd.equals("6") || cmd.equals("7") || cmd.equals("8")
				|| cmd.equals("9")) {
			if (OutText.getText().length() < 24) {
				if (OutText.getText().equals("0")
						|| OutText.getText().equals("Invalid result")
						|| isCalculated == true) {
					OutText.setText(cmd);
					isCalculated = false;
				} else {
					OutText.setText(OutText.getText() + cmd);
				}
			}
		} else if (cmd.equals(".")) {
			if (!OutText.getText().contains(".")) {
				OutText.setText(OutText.getText() + cmd);
			}
		} else if (cmd.equals("+/-")) {
			if (OutText.getText().compareTo("0") >= 0) {
				OutText.setText("-" + OutText.getText());
			} else {
				OutText.setText(OutText.getText().substring(1));
			}
		} else if (cmd.equals("+") || cmd.equals("-") || cmd.equals("*")
				|| cmd.equals("/")) {
			Operand1 = OutText.getText();
			firstOperand2 = null;
			operator = cmd;
			OutText.setText("0");
		} else if (cmd.equals("=")) {
			if (operator != null && Operand1 != null) {
				if (firstOperand2 == null) {
					firstOperand2 = OutText.getText();
					Operand2 = OutText.getText();
				} else {
					Operand1 = OutText.getText();
					Operand2 = firstOperand2;
				}
				OutText.setText(calculate(Operand1, operator, Operand2));
			}
		}
	}

/**
 * Method to perform the actual calculation for the calculator
 * @param Operand1 holds the value entered before the arithmetic operation chosen
 * @param operator holds the Arithmetic operator chosen
 * @param Operand2 holds the value entered after the arithmetic operation chosen
 * @return
 */
	
	public String calculate(String Operand1, String operator, String Operand2) {
		if (!OutText.getText().equals("Invalid result")) {
			Double leftDouble = Double.parseDouble(Operand1);
			Double rightDouble = Double.parseDouble(Operand2);
			String result;
			if (operator == "+") {
				result = numFormat.format(leftDouble + rightDouble) + "";
			} else if (operator == "-") {
				result = numFormat.format(leftDouble - rightDouble) + "";
			} else if (operator == "*") {
				result = numFormat.format(leftDouble * rightDouble) + "";
			} else if (operator == "/") {
				result = numFormat.format(leftDouble / rightDouble) + "";
			} else {
				result = "0";
			}
			isCalculated = true;
			if (result.length() <= 24) {
				return result;
			} else {
				return "Invalid result";
			}
		} else {
			return "0";
		}
	}
/**
 * Method to capture the key stroke performed 
 */
	@Override
	public void keyPressed(KeyEvent KP) {
		// TODO Auto-generated method stub
		if (Character.isDigit(KP.getKeyChar()) == false) {
			OutText.setText("");
		}
	}

	@Override
	public void keyReleased(KeyEvent KR) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent KT) {
		// TODO Auto-generated method stub

	}
}
