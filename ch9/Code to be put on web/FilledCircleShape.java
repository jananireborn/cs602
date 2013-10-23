

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
class FilledCircleShape extends CircleShape {

	
/**
 * Method to redraw the Round Rectangle shape on the drawing pad
 * @param g Graphic container object	
 */
  public void draw(Graphics g) {
    int x = Math.min(x1, x2); 
    int y = Math.min(y1, y2); 
    int w = Math.abs(x1 - x2) + 1; 
    int h = Math.abs(y1 - y2) + 1;     
    if (color != null) {
      g.setColor(color);
    }
    g.fillRoundRect(x, y, w, h, 10, 10);
  }


}


