import java.awt.*;


/**
 * @author      Janani Swaminathan 
 * @version     1.0                                   
 * @since       10/23/2012  
 */
public class BarSortDisplay1 implements SortDisplay {

/**
Method to define the size of the array
@param d Dimensions of the applet
*/
  public int getArraySize(Dimension d) {
    return d.width / 3; 
  }

/**
Method to display the Sorting items, a real time graphic update with delay set in the 
main program

@param a Integer array to be sorted 
@param g Type graphics for display the array output
@param d Define and dimensions of the rectangle 

*/
  public void display(int a[], Graphics g, Dimension d) {
    g.setColor(Color.white);
    g.fillRect(0, 0, d.width, d.height);
    double f = d.height / (double) a.length;    
    double cf = 255.0 / (double) a.length;

    int x = d.width - 3;
    for (int i = a.length; --i >= 0; x -= 3) {
      g.setColor(new Color(1, (int)(a[i] * cf / 1.5), (int)(a[i] * cf)));
      g.fillRect(x, 3 , d.height - (int)(a[i] * f), (int)(a[i] * f));
    }
  }   
}


