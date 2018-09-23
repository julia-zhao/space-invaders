import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowListener;

public class Makers extends JFrame
{
  JFrame frame = new JFrame();
  JPanel pan1 = new JPanel(); //Create a Panel
  JButton back = new JButton("BACK");
  
  public Makers () 
  { 
//        //Notifies program when frame is closed (disposed)
//    this.addWindowListener (new WindowAdapter (){
//      @Override
//      public void windowClosed(WindowEvent e) //overrides the default action that is performed then window is closed
//      {
//        Music.stop(); //stop music from playing
//      }
//    });
    
    int numClicks = 0;
    pan1.setLocation(700, 500);
    pan1.setSize (20, 10);
    frame.setSize (800, 600); //Set the size of the window
    frame.setResizable(false); //Do not allow the user to resize the window
    ImageIcon icon = new ImageIcon("makers.PNG");
    JLabel label = new JLabel(icon);
    label.setVisible(true);
    frame.add(label);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    
    //back.setSize(20,10);
    //back.setText("Back");
    //back.addActionListener(this);
    //frame.add(back);
    //pan1.add(back);
    //back.setVisible(true);
    //frame.add(pan1);
  }
  
  public static void main(String args[]) 
  {
    Makers frame = new Makers();
  }
}