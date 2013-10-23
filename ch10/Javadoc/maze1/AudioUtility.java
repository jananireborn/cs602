package maze;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * 
 * @author Janani Swaminathan
 * @version 1
 * @since 11/19/2012
 * 
 */


public class AudioUtility 
{ 
	
/**
 * Method to locate the Audio file 
 * @param filename  Name of the Audio file 
 * @return
 */
  public static final AudioClip getAudioClip(String filename) 
  { 
    if (filename != null)
    { 
      try
      { 
        return Applet.newAudioClip(new URL("http://harp.njit.edu/~js595/cs602/ch9/" + filename));
      }
      catch (MalformedURLException e) 
      { 
        e.printStackTrace();
      }
    }
    return null;
  }
/**
 * Method to play the audio file 
 * @param audiourl Location of the Audio file (URL)
 * @return
 */
  
public static Object PLAY(String audiourl) {
  // TODO Auto-generated method stub
  return null;
}

}