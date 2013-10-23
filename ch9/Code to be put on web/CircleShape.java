

package draw1; 

import java.awt.*; 
/**	
 * 
 * @author Janani Swaminathan
 * @version 1
 * @since 11/12/2012
 */

@SuppressWarnings("serial")
public class CircleShape extends TwoEndsShape {

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
    g.drawRoundRect(x, y, w, h, 10, 10);
  }

  /**
   * Method to draw outline of Round Rectangle shape on the drawing pad
   * @param g Graphic container object	
   */
  
  public void drawOutline(Graphics g, int x1, int y1, int x2, int y2) {
    int x = Math.min(x1, x2); 
    int y = Math.min(y1, y2); 
    int w = Math.abs(x1 - x2) + 1; 
    int h = Math.abs(y1 - y2) + 1;     
    g.drawRoundRect(x, y, w, h, 10, 10);
  }

}


