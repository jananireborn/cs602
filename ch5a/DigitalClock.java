
import java.awt.*;
import java.util.*;

/************************************************************************ 
* Functionality:  1. To display the Time in 12 hour format
*                 2. To display the date as mentioned in the exercise 4.9
*************************************************************************
* Author: Janani Swaminathan ( JS595 )
* 
*/ 

public class DigitalClock extends java.applet.Applet implements Runnable 
{
 // Initiate / assign Thread, Color, and Font.
	protected Thread clockThread = null;
	protected Font font = new Font("Monospaced", Font.BOLD, 48);
	protected Color color =  Color.BLUE;

// Declare global variable
	String Hm;


// Implement the start method 
	public void start()
   {
     if (clockThread == null)
     {
		 clockThread = new Thread(this);
// Start new thread 
		 clockThread.start();
     }
   }

// Implement the Stop method
	public void stop()
   {
    clockThread = null;
   }		

// Implement Run method
	public void run()
   {
    while (Thread.currentThread() == clockThread)
    {
// Call the repaint method which will in turn call the paint menthod
		repaint();
		try
		{
			Thread.currentThread().sleep(1000);
		}
		catch (InterruptedException e){}
    }
   }		
  

// Implement paint method
	public void paint( Graphics g)
   {
// Instantiate the Locale class which will be used later
    Locale local = Locale.ENGLISH;
    Calendar calendar = Calendar.getInstance();

// Fetch Month, Year, Day and Weekday for displaying in the Applet
// Value passed to the method getDisplayName with the following arguments
// ( Int "Fieldname", Int "Style name", Locale )
// Field name and Integer value 
// YEAR = 1, MONTH = 2, DATE  = 5, DAY_OF_WEEK = 7, AM_PM = 9
// Style SHORT = 1, LONG = 2

// Get the Month Name ( Short name )
    String month = calendar.getDisplayName(2, 1, local);
    int year = calendar.get(Calendar.YEAR);
    int day =  calendar.get(Calendar.DAY_OF_MONTH); 

// Get the short name of the weekday
    String WeekDay = calendar.getDisplayName(7,1, local);

// Fetch the Time
// Get the value of AM / PM
	Hm = calendar.getDisplayName(9, 1 , local);
	int hour = calendar.get(Calendar.HOUR);
	int minute = calendar.get(Calendar.MINUTE);
	int second = calendar.get(Calendar.SECOND);

// Set the Font and color
	g.setFont(font);
	g.setColor(color);

// Draw the string 
	g.drawString( hour + ":" + minute / 10 + minute % 10 +
		         ":" + second / 10 + second % 10 + " " + Hm, 10 , 60 );

	g.drawString( day + " " +  month + " " + year + " " + WeekDay , 10 , 120);
   }		

}