
import java.io.*;
import java.awt.*;
import java.applet.Applet;
public class HelloWorld_Assign extends Applet {
	public void paint (Graphics g)
	{
		Dimension d = getSize();
		g.setColor(Color.white);
		g.fillRect(0, 0, d.width, d.height);
		Font f = new Font("Courier-New",Font.BOLD, 18);
		g.setFont(f);
		Color c = new Color(0,150,200);
		g.setColor(c);
		g.drawString("Hello World!!", 40, 40);
		Image i= getImage(getCodeBase(), "hello_world.jpg");
		g.drawImage(i, 20, 60, this);
		
	}
	
}


