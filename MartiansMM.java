/**
 * MartiansMM.java
 * Tiantian, Marina, Julia
 * Created December 7 2016
 * (Pseudocode plan) Player controls spaceship, tries to shoot all the aliens before they reach the ground
 */

//put the separate classes on a different file
public class spaceship 
{
  //Create spaceship sprite
  //set size

  //method to move the spaceship if user presses left or right buttons 
  public static void moveShip (insert variable names here) //(thread 1)
  {
    //while button is right arrow pressed down && next pixel is still on screen
         //move spaceship x pixels to the right
    //while button is left arrow pressed down && next pixel is still on screen
         //move spaceship x pixels to the left
  } //end of moveShip
  
  //keep checking for spacebar input (thread 2)
  //if spacebar is pressed 
     //call bullet class
  //wait for next input
  
  //method to shoot a bullet if user presses space button
}//class for spaceship object

public class bullet 
{   
  //Create bullet/missile sprite
  
  //Method to animate the bullets (every time spacebar is pressed and no other bullets are on the screen)
     //set bullet sprite to visible
     //move x pixels to the right every millisecond until it goes off screen (for loop)
        //if bullet collides with something else (get value from another class?)
            //break the loop
     //set sprite to not visible
}//class for bullet object

public class barriers //(thread 3)
{
  //create sprite (?) array called barrier (have 3 barriers, each barrier has 3 parts to it)
  //position them on screen
  
  //(collision detection)
  //if something (enemy bomb or our bullets hits the barrier then that part breaks (disapepars)
}//class for barrier objects

public class martians //(thread 4)
{
  //Initialize martians 2d sprite array [5] [6]
  //For loop to assign the martians a value(an image)
  
  //Create a bomb sprite
  
  //method to drop bombs (happens at fixed time intervals)
     //while alien isn't hit (invisible) and bomb isnt on screen (invisible)
         //bomb = visible
         //travel down y pixels every millisecond until it reaches the end of the screen
           //if the player is hit or it reached the end of the screen or it hit a barrier
              //set bomb to invisible
              //wait 1000 milliseconds 
  //end of method
  
  //if alien is hit by a bullet
     //set to invisible
}//class for martians object (the enemies you have to shoot)

public class MartiansMM extends JFrame implements ActionListener (//thread 5)
{
  //for loop to make array to create martian sprites
  //create sprite for missile
  //create sprite for spaceship (separate class?)
  public MartiansGUI ()
  {//GUI constructor
    //make frames for the GUI to appear 
    //set title to MMM
    //setDefaultCloseOperation(EXIT_ON_CLOSE);
    //set size of screen 
    //set visible
  }
  
  public static void main(String[] args) 
  {  
    //Variables
    /**final int SCREEN_WIDTH = 358, final int SCREEN_HEIGHT = 350, final int GROUND = 290, final int BOMB_HEIGHT = 5;
      final int ALIEN_HEIGHT = 12, final int ALIEN_WIDTH = 12, final int BORDER_RIGHT = 30, final int BORDER_LEFT = 5;
      final  int GO_DOWN = 15, final int NUMBER_OF_ALIENS_TO_DESTROY = 24, final int CHANCE = 5, final int DELAY = 17;
      final int PLAYER_WIDTH = 15, final int PLAYER_HEIGHT = 10;
      */
    
    //run the Martians GUI constructor
  }//end of main
  
}//end of class
