package draw3;
import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class DrawingPadApplet extends JApplet {
    
	public void init(){
		
	    JFrame frame = new draw3.DrawingPad("Drawing Pad");
	    frame.setSize(500, 500);
	    frame.setVisible(true);	
	}

}
