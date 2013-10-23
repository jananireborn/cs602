

package draw1; 

import java.awt.*; 

/**	
 * 
 * @author Janani Swaminathan
 * @version 1
 * @since 11/12/2012
 */

@SuppressWarnings("serial")
public class TriangleShape extends TwoEndsShape {

	

/**
 * Method to redraw the Triangles shape on the drawing pad
 * @param g Graphic container object	
 */
	
  public void draw(Graphics g) {

	    int h = Math.abs(x1 - x2) ;  
   
    if (color != null) {
      g.setColor(color);
    }
    
    
    Point p1 = new Point(x1, y1);
	Point p2 = new Point(x2, y2);
	Point p3 = new Point(h,y2);
    
    int[] xs = { p1.x, p2.x, p3.x };
	int[] ys = { p1.y, p2.y, p3.y };
	Polygon triangle = new Polygon(xs, ys, xs.length);
	g.drawPolygon(triangle);
    

  }

 /**
  * Method to draw outline of Triangle shape on the drawing pad
  * @param g Graphic container object	
  */
  
  public void drawOutline(Graphics g, int x1, int y1, int x2, int y2) {

    int h = Math.abs(x1 - x2) ; 

    
    Point p1 = new Point(x1, y1);
	Point p2 = new Point(x2, y2);
	Point p3 = new Point(h,y2);
    
    int[] xs = { p1.x, p2.x, p3.x };
	int[] ys = { p1.y, p2.y, p3.y };
	Polygon triangle = new Polygon(xs, ys, xs.length);
	g.drawPolygon(triangle);
  }

}


