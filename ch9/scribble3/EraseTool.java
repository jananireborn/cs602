package scribble3;
import java.awt.*; 

/**	
 * 
 * @author Janani Swaminathan
 * @version 1
 * @since 11/12/2012
 */

public class EraseTool extends AbstractTool {
	
	 public EraseTool(ScribbleCanvas canvas, String name) {
		    super(canvas, name);

		  }
	 
/* 
 * Method to start the Shape for scribbling 
 * 
 * @param	P Coordinate of the Shape's Origin  
 */
	  public void startShape(Point p) {
		    curStroke = new Stroke(Color.WHITE); 

		    curStroke.removePoint(p); 
		  }	
	  
	  
  /* 
   * Method to add the point to the array
   * 
   * @param	P Coordinate of the Shape's Origin  
   */
	  public void addPointToShape(Point p) {
	    if (curStroke != null) { 
		    curStroke.removePoint(p); 
	      Graphics g = canvas.getGraphics();
	      g.setColor(Color.WHITE);
	      
	      g.fillRect(canvas.x, canvas.y, p.x, p.y); 
	    }
	  }
  /* 
   * Method to add the point to the array
   * 
   * @param	P Coordinate of the Shape's Origin  
   */
	  public void endShape(Point p) {
	    if (curStroke != null) { 
		    curStroke.removePoint(p); 
	      canvas.addShape(curStroke); 
	      curStroke = null; 
	    }
	  }

	  protected Stroke curStroke = null; 
	  
	  
}