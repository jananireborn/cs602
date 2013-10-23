

package maze; 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UndoableMazeGame {

  public static void main(String[] args) { 

  }

  static class MazeCommandAction implements ActionListener { 
    
    public MazeCommandAction(Maze maze) { 
      this.maze = maze; 
    }

    public void actionPerformed(ActionEvent event) { 
      maze.undoCommand(); 
    }

    protected Maze maze;
  }

}


