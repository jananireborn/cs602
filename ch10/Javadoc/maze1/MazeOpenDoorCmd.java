

package maze;

public class MazeOpenDoorCmd implements UndoableCommand { 

  public MazeOpenDoorCmd(Maze maze, Direction direction) { 
    this.maze = maze;
    this.direction = direction; 
  }


  public void execute() {
      Door door = null;
      // open all doors
      Direction d = Direction.first();
      while (d != null)
      {
          MapSite m = maze.getCurrentRoom().getSide(d);
          if (m instanceof Door)
          {
            door = ((Door) m);
            if (door.isOpen() == false){
              door.setOpen(!door.isOpen());
          }
          }

          d = d.next();
      }

      if( maze.view != null ) maze.view.repaint();

    
  }

  public void undo() {
    maze.move(direction.opposite()); 
  }

  protected Maze maze; 
  protected Direction direction; 

}


