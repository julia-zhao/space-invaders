import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.*;

public class Fail extends JFrame
{
  JFrame frame = new JFrame();
  //JPanel pan1 = new JPanel(); //Create a Panel
  //JButton back = new JButton("BACK");
  ImageIcon icon = new ImageIcon("fail.PNG");
    JLabel label = new JLabel(icon);
  
  public Fail () 
  { 
    //int numClicks = 0;
    //pan1.setLocation(700, 500);
    //pan1.setSize (20, 10);
    frame.setSize (800, 600); //Set the size of the window
    frame.setResizable(false); //Do not allow the user to resize the window
    label.setVisible(true);
    frame.add(label);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    
//    back.setSize(20,10);
//    //back.setText("Back");
//    back.addActionListener(this);
//    frame.add(back);
//    pan1.add(back);
//    back.setVisible(true);
//    frame.add(pan1);
  }
  
  public static void main(String args[]) 
  {
    Fail frame = new Fail();
  }
}