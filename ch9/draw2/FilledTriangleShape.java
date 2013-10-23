

package draw2; 

import java.awt.*; 

import draw1.*;

/**	
 * 
 * @author Janani Swaminathan
 * @version 1
 * @since 11/12/2012
 */


@SuppressWarnings("serial")
public class FilledTriangleShape extends TriangleShape {


/**
 * Method to redraw the triangle shape on the drawing pad
 * @param g Graphic container object	
 */
	
	
  public void draw(Graphics g) {


    if (color != null) {
      g.setColor(color);
    }
    
    
    int h = Math.abs(x1 - x2) ; 

    
    Point p1 = new Point(x1, y1);
	Point p2 = new Point(x2, y2);
	Point p3 = new Point(h,y2);
    
    int[] xs = { p1.x, p2.x, p3.x };
	int[] ys = { p1.y, p2.y, p3.y };
	Polygon triangle = new Polygon(xs, ys, xs.length);
	g.fillPolygon(triangle);
    

  }

  
}


