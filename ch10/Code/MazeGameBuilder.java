package maze;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 *  Build a Maze game. 
 *
 *  This implmentation uses Builder and Abstract Factory design patterns. 
 *
 *  Run the program as follows:
 *   java maze.MazeGameBuilder Harry
 *         -- uses the FactoryMazeBuilder with the HarryPotterMazeFactory
 *   java maze.MazeGameBuilder Snow
 *         -- uses the FactoryMazeBuilder with the SnowWhiteMazeFactory
 *   java maze.MazeGameBuilder Simple
 *         -- uses the FactoryMazeBuilder with the default MazeFactory
 *   java maze.MazeGameBuilder
 *         -- uses the SimpleMazeBuilder, which does not use a factory
 *
 */
public class MazeGameBuilder extends JApplet implements ActionListener {

	Choice selectrows = null;
	Choice selectCols = null;
	Choice theme = null;

	JLabel Cols, ThemeL, Rows;
	JButton btncreatemaze;

	protected JPanel gamePanel = null;
	protected Maze maze = null;

	public static Maze createMaze(MazeBuilder builder, int NoRoom, int rows,
			int cols) {
		builder.newMaze();

		for (int i = 1; i <= NoRoom; i++) {
			builder.buildRoom(i);
		}

		for (int i = 1; i <= NoRoom; i++) {

			int f = (i % cols);
			int j = i % 3;
			int k = i % 5;
			if (f != 0) {
				if (k != 0 ) {
					builder.buildDoor(i, i + 1, Direction.WEST, false);
				} else if ( j != 0) {
					builder.buildDoor(i, i + 1, Direction.WEST, true);
				}

			}
			if (j != 0) {
				builder.buildDoor(i, i + cols, Direction.NORTH, true);
			} else {
				builder.buildDoor(i, i + cols, Direction.NORTH, false);
			}

		}
		return builder.getMaze();
	}

	/**
	 * Initialize method
	 */
	public void init() {

		Pane p = new Pane();
		getContentPane().add(p);

		btncreatemaze.addActionListener(this);
	}

	/**
	 * Action Performed method
	 * 
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		launch();
	}

	/**
	 * Launch method for initializing the Maze factory
	 */
	private void launch() {

		MazeBuilder builder;
		MazeFactory factory = null;
		int rows = Integer.valueOf(selectrows.getSelectedItem());
		int cols = Integer.valueOf(selectCols.getSelectedItem());
		int intNumOfRooms = rows * cols;
		if (theme.getSelectedItem().equals("HARRY")) {
			factory = new HarryPotterMazeFactory();
		} else if (theme.getSelectedItem().equals("SNOW")) {
			factory = new SnowWhiteMazeFactory();
		} else {
			factory = new MazeFactory();
		}

		builder = new FactoryMazeBuilder(factory);
		maze = createMaze(builder, intNumOfRooms, rows, cols);
		maze.setCurrentRoom(1);

		JFrame frame;
		frame = new JFrame("Maze -- Builder");
		frame.setContentPane(new Maze.MazePanel(maze));
		frame.pack();

		Dimension frameDim = frame.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(screenSize.width / 2 - frameDim.width / 2,
				screenSize.height / 2 - frameDim.height / 2);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	class Pane extends JPanel {

		/**
		 * Pane Override method is for setting the grid and the layout property
		 * 
		 */
		public Pane() {
			setLayout(new GridBagLayout());
			GridBagConstraints GrBagCon = new GridBagConstraints();

			selectrows = new Choice();
			theme = new Choice();
			selectCols = new Choice();

			selectrows.add("4");
			selectrows.add("8");
			selectrows.add("12");
			selectrows.add("16");
			selectrows.add("20");

			selectCols.add("4");
			selectCols.add("8");
			selectCols.add("12");
			selectCols.add("16");
			selectCols.add("20");

			theme.add("HARRY");
			theme.add("SNOW");

			btncreatemaze = new JButton("Generate");
			Rows = new JLabel("Select Rows");
			Cols = new JLabel("Select Colums");
			ThemeL = new JLabel("Select Theme");

			GrBagCon.gridwidth = 5;
			GrBagCon.insets = new Insets(3, 3, 3, 3);
			GrBagCon.fill = GridBagConstraints.BOTH;

			GrBagCon.gridheight = 1;
			GrBagCon.gridwidth = 1;
			GrBagCon.gridy = 1;
			((GridBagLayout) getLayout()).setConstraints(Rows, GrBagCon);
			add(Rows);

			GrBagCon.gridwidth = 1;
			GrBagCon.gridheight = 1;
			GrBagCon.gridy = 3 / 2;
			((GridBagLayout) getLayout()).setConstraints(selectrows, GrBagCon);
			add(selectrows);

			GrBagCon.gridwidth = 1;
			GrBagCon.gridheight = 1;
			GrBagCon.gridy = 3;

			((GridBagLayout) getLayout()).setConstraints(Cols, GrBagCon);
			add(Cols);

			GrBagCon.gridwidth = 1;
			GrBagCon.gridheight = 1;
			GrBagCon.gridy = 7 / 2;

			((GridBagLayout) getLayout()).setConstraints(selectCols, GrBagCon);
			add(selectCols);

			GrBagCon.gridwidth = 1;
			GrBagCon.gridheight = 1;
			GrBagCon.gridy = 9 / 2;
			((GridBagLayout) getLayout()).setConstraints(ThemeL, GrBagCon);
			add(ThemeL);

			GrBagCon.gridwidth = 1;
			GrBagCon.gridheight = 1;
			GrBagCon.gridy = 9 / 2;
			((GridBagLayout) getLayout()).setConstraints(theme, GrBagCon);
			add(theme);

			GrBagCon.gridwidth = 1;
			GrBagCon.gridheight = 1;
			GrBagCon.gridy = 5;

		    ((GridBagLayout) getLayout()).setConstraints(btncreatemaze,	GrBagCon);
			add(btncreatemaze);
		}
	}
}
