import java.awt.*;
import javax.swing.JApplet;

public class AnimationApplet extends JApplet implements Runnable{

  protected Component comp;
  protected Thread animationThread;
  protected int delay = 100;
  
  public void run(){
    while(Thread.currentThread() == animationThread){
      try{
        Thread.currentThread().sleep(delay);
      }catch(InterruptedException e){
        
      }
      repaint();
    }  
  }
  
  public void start(){
    animationThread = new Thread(this);
    animationThread.start();
  }
  
  public void stop(){
    animationThread = null;
  }
  
  final public void setDelay(int delay){
    this.delay = delay;
  }
  
  final public int getDelay(){
    return delay;
  }
  
  public AnimationApplet(Component comp){
    this.comp = comp;
  }
  
  public AnimationApplet(){
    
  }
  
}
