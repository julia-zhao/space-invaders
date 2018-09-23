/**
 * Auto Generated Java Class.
 */  

//////thread testing
//import java.io.*;
//import sun.audio.*;
////
//////class to thread for music
//public class threadMusic implements Runnable 
//{
//  public void run() 
//  {
//    try
//    {
//      // open the sound file as a Java input stream
//      String bgm = "cirno.wav";
//      InputStream input = new FileInputStream(bgm);
//      
//      // create an audiostream from the inputstream
//      AudioStream bgmAudStream = new AudioStream(input);
//      
//      // play the audio clip with the audioplayer class
//      AudioPlayer.player.start(bgmAudStream);
//
//    }
//    catch (IOException e)
//    {
//      System.out.println ("Error. Cannot play music.");
//    }
//  }
//  
////  public static void main(String[] args) { 
////    (new Thread(new threadMusic())).start();
////  }
//} //end of class

import java.io.*;
import sun.audio.*;
public class threadMusic
{
  int endMusic = 0;
  //method to thread music
  public void run() 
  {
    //declare variables
    String bgm = null;
    InputStream input = null;
    AudioStream bgmAudStream = null;
    //while the program is still running
    while (endMusic == 0)
    {
      //try and catch blocks to catch IOException error
      try
      {
        // open the sound file as a Java input stream
        bgm = "cirno.mp3";
        input = new FileInputStream(bgm);
        
        // create an audiostream from the inputstream
        bgmAudStream = new AudioStream(input);
        
        // play the audio clip with the audioplayer class
        AudioPlayer.player.start(bgmAudStream);
        
        if (endMusic > 0)
        {
          AudioPlayer.player.stop(bgmAudStream);//stop the audioplayer
          break; //break the try block
        }
        
      }
      //if IOException error occurs
      catch (IOException e)
      {
        System.out.println ("Error. Cannot play music.");
      }
      
      // break; //break the loop
    }
    //this part of the program is not reached yet (debugging issue?)
    //thread is exited/stopped
    //stop music
    // AudioPlayer.player.stop(bgmAudStream);
    
    public static void main (Strings [] args)
    {
      while (endMusic = 0)
      {
        endMusic = input.nextInt();
      }
    }
  }
  
////class to thread for music
//import java.io.*;
//import sun.audio.*;
//public class threadMusic implements Runnable
//{
//  int run = 0;
//  public void run()
//  {
//    // open the sound file as a Java input stream
//    String bgm = "testMusic.wav";
//    InputStream input = new FileInputStream(bgm);
//    
//    //play music
//    //keep looping music forever
//    while (run == 0)
//    {
//        // create an audiostream from the inputstream
//    AudioStream bgmAudStream = new AudioStream(input);
//    }
//  }
//  
//  public static void main(String[] args) //throws Exception 
//  { 
//    (new Thread(new threadMusic())).start();
//    System.out.println ("asasas");
//    
//  }
//} //end of class