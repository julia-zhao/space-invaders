import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
//import java.util.concurrent.TimeUnit;
import javax.swing.Timer;
//import javax.swing.SwingUtilities.*;
import java.awt.Font;

public class SpaceShip extends JPanel implements ActionListener, KeyListener
{
  static int screen =3, music = 2, minutes, seconds;
  Timer t = new Timer(5, this); //delay between two instants in time
  
  //Declare variables
  double shipX = 400, y = 500, vx = 0, width = 0, height = 0, bulletX = 400, bullety = 500, vBullety=0, boxx=0, boxy=0, vbox=0.75, bombCount=1, bombX, bombY=560, vBombY;
  static int points = 0, screenX=800, screenY=600, checkWin=0, bombWhere, result;
  public int exit = 0;
  
  JLabel score = new JLabel("Score: "+points, JLabel.LEFT);
  //score.setFont(new Font("Courier New", Font.ITALIC, 12));
  
//  try
//  {
//    int timeBonus = timeLeft();
//  }
//  catch (InterruptedException e)
//  {
//    System.out.println ("Error: " + e);
//  }
  
  //Create an array for the state of martians advancing down the screen
  //0 means alive 1 means dead
  int [][] ships = new int[1][1];
  int [][][] barriers = new int[10][2][3];
  
  //Constructor to format/organize/display the graphics
  public SpaceShip()
  {    
    t.start();
    setBackground(Color.black);
    addKeyListener(this);
    setFocusable(true);
    this.add(score);
    score.setFont(new Font("Courier New", Font.ITALIC, 12));
  } //end of SpaceShip
  
  //Method to send music back to music thread in Main
  public static int getMusic ()
  {
   // if (screen == 4)//if screen is already changed to end screen
      //music = 3; //play music file (music for end screens)
    return music;
  }
  
  //performs the action
  public void actionPerformed(ActionEvent e)
  {

    if(exit==0){
      repaint(); //update the screen to see everything moving
      
      //Stop the ship from going off screen
      //if the ship's x coordinate is greater than 730 and it's moving
      if(shipX >= 730 && vx>0)
      {
        vx=0; //set velocity to 0
      }
      //if the ship's x coordinate is less than 5 and it's moving
      else if(shipX <= 5 && vx<0)
      {
        vx=0; //set velocity to 0
      }
      
      //change the x coordinate of the martians to move it
      shipX += vx;
      
      //move the bullet up
      bullety += vBullety; 
      
      //if the bullet is not on screen
      if(bullety < 0)
      {
        bullety = 500;
        vBullety = 0;
      }
      
      boxx+=vbox;
      if(bombY>500){
        bombWhere = (int)Math.floor(Math.random()*16+1);
        bombX=(int) this.boxx + (20 * (bombWhere + 1));
        bombY=(int) this.boxy + (25 * 3);
        vBombY=1;
      }
      
      bombY+=vBombY;
      if(bombY > 550)
      {
        bombY = 560;
        vBombY = 0;
      }
      
      //if the aliens have reached the end of the screen move it down and reverse the direction it's going
      if(boxx>(screenX-((ships.length)*28))||boxx<=-20)
      {
        vbox=-vbox; //change direction of the aliens
        boxy+=20; //move aliens down 20 pixels
      }
      
      //if the martians reach the ship
      if(boxy>450-(25*ships[0].length) || points < 0)
      {
        screen = 4; //screen has changed to end screen
        //Fail fail = new Fail (); //call up Fail class
        result = 0;
        Win endScreen = new Win();
        SwingUtilities.getWindowAncestor(this).dispose();

        exit=1;
      }
      for(int E=0; E<ships[0].length; E++)
      {
        for(int I=0; I<ships.length; I++)
        {
          if(ships[I][E]==1)
            checkWin+=1;
        }
      }
      
      if(checkWin==(ships.length)*(ships[0].length))
      {
        screen = 4;
        result = 1;
        music = 3;
        Win end = new Win (); //call up Win class
        SwingUtilities.getWindowAncestor(this).dispose();

        exit=1;
      }
      checkWin=0;
    }
  } //end of actionPerformed
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D)g;
    
    for(int e=0; e<ships[0].length; e++)
    {
      for(int i=0; i<ships.length; i++)
      {
        g.setColor(Color.blue);
        Rectangle hitBox = new Rectangle((int)this.boxx+(25*(i+1)), (int)this.boxy+(25*(e+1)), 20, 20);
        if(ships[i][e] < 1){
          if(hitBox.intersects((int)this.bulletX+15, (int)this.bullety+17, 15, 5)){
            ships[i][e] = 1;
            bullety = 500;
            vBullety = 0;
            points+=500;
            score.setText("Score: " + points);
          }
        }
        
        if(ships[i][e] < 1) {
          g.fillRect((int) this.boxx + (25 * (i + 1)), (int) this.boxy + (25 * (e + 1)), 20, 20);
        }
      }
    }
    
    //draw bullet
    g2d.setPaint(Color.yellow);
    g.fillRect((int)this.bulletX+15, (int)this.bullety+17, 5, 15);
    
    g2d.setPaint(Color.black);
    g.fillRect(0, 510, 800, 80);
    
    //draw ship
    g2d.setPaint(Color.red);
    g.fillRect((int)this.shipX, (int)this.y, 50, 50);
    
    Rectangle ufoHit = new Rectangle((int)this.shipX, (int)this.y, 50, 50);
    if(ufoHit.intersects((int)bombX,(int)bombY, 10, 10)){
     // Music.effect ("bombSound.wav");
      bombY = 560;
      points-=1000;
      score.setText("Score: " + points);
    }
    
    g.fillRect((int)bombX,(int)bombY, 10, 10);
    
    for(int a = 0;a<3;a++){
      for(int f=0;f<barriers[0].length;f++){
        for(int d=0;d<barriers.length;d++){
          g2d.setPaint(Color.blue);
          Rectangle barrierHit = new Rectangle(150+(a*200)+(10*d), 400+(10*f), 10, 10);
          if(barriers[d][f][a] < 1){
            if(barrierHit.intersects((int)this.bulletX+15, (int)this.bullety+17, 15, 5)){
              barriers[d][f][a] = 1;
              bullety = 500;
              vBullety = 0;
            }
            if(barrierHit.intersects((int)bombX,(int)bombY, 10, 10)){
              barriers[d][f][a] = 1;
              bombY = 560;
            }
          }
          if(barriers[d][f][a] < 1) {
            g.fillRect(150+(a*200) + (10 *d), 400+(10*f), 10, 10);
          }
        }
      }
    }
  }
  
  public void keyTyped(KeyEvent e)
  {
    // TODO Auto-generated method stub
  }
  
  //see which key is being pressed
  public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
    
    if(keyCode == KeyEvent.VK_RIGHT){
      right(); //call right method
    }
    if(keyCode == KeyEvent.VK_LEFT){
      left();
    }
    //if spacebar is pressed and the previous bullet is no longer on screen
    if(keyCode == KeyEvent.VK_SPACE && bullety >= 500)
    {
      bulletX = shipX;
      shoot();
    }
  }
  
  public void left()
  {
    this.vx = -3; //move ship left
  }
  public void right()
  {
    this.vx = 3; //move ship right
  }
  public void shoot()
  {
    this.vBullety= -5; //move bullet up
    //Music.effect("shootSound.wav"); ///////////////////////////////////////////////////////////////
  }
  
  //method for when the buttons are released
  public void keyReleased(KeyEvent e)
  {
    int keyCode = e.getKeyCode();
    
    if(keyCode != KeyEvent.VK_RIGHT || keyCode != KeyEvent.VK_LEFT )
    {
      vx=0;
    }
  }
  
//  /*Sets timer countdown 
//   * @returns amount of time (seconds) left on the timer
//   */
//  public static int timeLeft () throws InterruptedException
//  {
//    System.out.println ("timer started");
//    for (minutes = 1; minutes < 1; minutes--)
//    {
//      if (checkWin == 30)
//        break;
//      System.out.println (minutes);
//      for (seconds = 59; seconds < 0; seconds--)
//      {
//        if (checkWin == 30)
//          break;
//        System.out.println ("       " + seconds);
//        TimeUnit.SECONDS.sleep(1);
//      }
//    }
//    seconds += minutes*60; //convert minuntes into seconds and add it into seconds
//    return seconds;
//  }
  
  //Method to return the score to end screens
  //@returns score of game
  public static int returnScore ()
  {
    return points;
  }
  
  //Method to return the result of the game (win or lose)
  //@returns 0 for lose, 1 for win
  public static int gameResult()
  {
    return result;
  }
  
  public static void main(String[] args) throws IOException
  {
    JFrame frame = new JFrame();
    SpaceShip space = new SpaceShip(); //calls SpaceShip class
    frame.add(space); //adds space to frame
    frame.setSize(800,600);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
//           // Notifies program when frame is closed (disposed)
//    frame.addWindowListener (new WindowAdapter (){
//      @Override
//      public void windowClosed(WindowEvent e) //overrides the default action that is performed then window is closed
//      {
//        Music.stop(); //stop music from playing
//      }
//    });
    
  } //end of main
}