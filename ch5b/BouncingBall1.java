
/* 
 * Copyright (c) 1999-2002, Xiaoping Jia.  
 * All Rights Reserved. 
 */

import java.awt.*;

/**
 * @author      Janani Swaminathan 
 * @version     1.0                                   
 * @since       10/05/2012       
 * @param color Sets the color of the ball
 * @param radius Sets the radius of the ball
 * @param x, y indicates the position of axis / coordinates
 * @param image Image name
 * @param offscreen Refers to the Graphics
 * @param d sets the dimension of the application area
 */

@SuppressWarnings("serial")
public class BouncingBall1	
    extends java.applet.Applet implements Runnable {

	
  protected Color color = Color.green;
  protected int radius = 20;
  protected int x, y;
  protected int dx = -2, dy = -4;
  protected Image image;
  protected Graphics offscreen;
  protected Dimension d;

  /**
     * Called by the browser or applet viewer to inform
     * this applet that it has been loaded into the system. It is always
     * called before the first time that the <code>start</code> method is
     * called.
     * <p>
     * A subclass of <code>Applet</code> should override this method if
     * it has initialization to perform. For example, an applet with
     * threads would use the <code>init</code> method to create the
     * threads and the <code>destroy</code> method to kill them.
     * <p>
     * The implementation of this method provided by the
     * <code>Applet</code> class does nothing.
     *
     * @see     java.applet.Applet#destroy()
     * @see     java.applet.Applet#start()
     * @see     java.applet.Applet#stop()

 * @param att Defines the delay in time for the ball to appear on the screen
 * the parameter is passed from the HTML file 
 */
public void init() {
    String att = getParameter("delay");
    if (att != null) { 
      delay = Integer.parseInt(att);
    }
    d = getSize();
    x = d.width * 2 / 3;
    y = d.height - radius;
  }

/**
* Method to set the Applet level properties such as Image, color and 
* later Draw it in the browser or the applet viewer 
* @param g Contains the graphic parameters for displaying the ball 
*/
public void update(Graphics g) {
    // create the off-screen image buffer
    // if it is invoked the first time
    if (image == null) {
      image = createImage(d.width, d.height);
      offscreen = image.getGraphics();
    }

    // draw the background
    offscreen.setColor(Color.white);
    offscreen.fillRect(0,0,d.width,d.height);

    // adjust the position of the ball
    // reverse the direction if it touches
    // any of the four sides
    if (x < radius || x > d.width - radius) {
      dx  =  -dx;
    }
    if (y < radius || y > d.height - radius) {
      dy  =  -dy;
    }
    x += dx;
    y += dy;

    // draw the ball
    offscreen.setColor(color);
    offscreen.fillOval(x - radius, y - radius,
		       radius * 2, radius * 2);

    // copy the off-screen image to the screen
    g.drawImage(image, 0, 0, this);
  }

/**
* Method to paint the applet, by calling the update(g) 
*/
public void paint(Graphics g) {
    update(g);
  }

  // The animation applet idiom
  protected Thread bouncingThread;
  protected int delay = 100;

  /**
     * Called by the browser or applet viewer to inform
     * this applet that it should start its execution. It is called after
     * the <code>init</code> method and each time the applet is revisited
     * in a Web page.
 */
public void start() {
    bouncingThread = new Thread(this);
    bouncingThread.start();
  }

/**

     * Called by the browser or applet viewer to inform
     * this applet that it should stop its execution. It is called when
     * the Web page that contains this applet has been replaced by
     * another page, and also just before the applet is to be destroyed.

*/
public void stop() {
    bouncingThread = null;
  }

/**
*   Method to execute the thread started using the start method 
*/
public void run() {
    while (Thread.currentThread() == bouncingThread) {
      try {
        Thread.currentThread().sleep(delay);
      } catch (InterruptedException  e) {}
      repaint();
    }
  }

}

