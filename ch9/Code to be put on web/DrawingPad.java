

package draw1; 

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*; 
import scribble3.*;

public class DrawingPad extends Scribble { 
	
  public DrawingPad(String title) {
    super(title); 
    initTools();
    ActionListener toolListener = new ActionListener() { 
	public void actionPerformed(ActionEvent event) { 
	  Object source = event.getSource();
	  if (source instanceof AbstractButton) {
	    AbstractButton button = (AbstractButton) source; 
	    Tool tool = toolkit.setSelectedTool(button.getText());
	    drawingCanvas.setTool(tool);
	    if (event.getActionCommand() == "Erase"){
	    	Cursor normalCursor = new Cursor(Cursor.HAND_CURSOR);
	    	setCursor(normalCursor);

	    	//Get the default toolkit  
	    	Toolkit toolkit = Toolkit.getDefaultToolkit();  
	    	  
	    	//Load an image for the cursor  
	    	Image image;
			URL url = getClass().getResource("eraser.gif");

			image = toolkit.getImage(url);
			Point hotSpot = new Point(0,0); 
			Cursor cursor = toolkit.createCustomCursor(image, hotSpot, "images");  
				setCursor(cursor);


	    	
	    	//Create the hotspot for the cursor  


	    	
	    }else{
	    	Cursor normalCursor1 = new Cursor(Cursor.DEFAULT_CURSOR);
	    	setCursor(normalCursor1);	    	
	    }
	    	
	  }
	}
      };
    JComponent toolbar = createToolBar(toolListener); 
    getContentPane().add(toolbar, BorderLayout.WEST);
    JMenu menu = createToolMenu(toolListener); 
    menuBar.add(menu, 1); // insert at index position 1 
  }

  public Tool getSelectedTool() { 
    return toolkit.getSelectedTool(); 
  }

  protected void initTools() { 
    toolkit = new ToolKit(); 
    toolkit.addTool(new ScribbleTool(canvas, "Scribble")); 
    toolkit.addTool(new TwoEndsTool(canvas, "Line", TwoEndsTool.LINE)); 
    toolkit.addTool(new TwoEndsTool(canvas, "Oval", TwoEndsTool.OVAL)); 
    toolkit.addTool(new TwoEndsTool(canvas, "Rectangle", TwoEndsTool.RECT)); 
    toolkit.addTool(new TwoEndsTool(canvas, "Circle", TwoEndsTool.CIRC));
    toolkit.addTool(new TwoEndsTool(canvas, "Triangle", TwoEndsTool.TRIG));
    drawingCanvas.setTool(toolkit.getTool(0));
  }

  // factory method 
  protected ScribbleCanvas makeCanvas() {
    return (drawingCanvas = new DrawingCanvas()); 
  }

  protected JComponent createToolBar(ActionListener toolListener) { 
    JPanel toolbar = new JPanel(new GridLayout(0, 1));
    int n = toolkit.getToolCount(); 
    for (int i = 0; i < n; i++) {
      Tool tool = toolkit.getTool(i); 
      if (tool != null) { 
	JButton button = new JButton(tool.getName()); 
	button.addActionListener(toolListener); 
	toolbar.add(button); 
      }
    }    
    return toolbar; 
  }

  protected JMenu createToolMenu(ActionListener toolListener) { 
    JMenu menu = new JMenu("Tools"); 
    int n = toolkit.getToolCount(); 
    for (int i = 0; i < n; i++) {
      Tool tool = toolkit.getTool(i); 
      if (tool != null) { 
	JMenuItem menuitem = new JMenuItem(tool.getName());
	menuitem.addActionListener(toolListener); 
	menu.add(menuitem);
      }
    }
    return menu; 
  }

  protected ToolKit toolkit;
  protected DrawingCanvas drawingCanvas;

  public static void main(String[] args) {
	  JFrame frame;
     frame = new DrawingPad("Drawing Pad");
    frame.setSize(width, height);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setLocation(screenSize.width/2 - width/2,
		      screenSize.height/2 - height/2);
    frame.show();
  }

}


