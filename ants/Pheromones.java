import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pheromones here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pheromones extends Actor
{
    private int GreenfootImage;
    private int MAX_INTENSITY;
    private int intensity;
    /**
     * Act - do whatever the Pheromones wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        intensity--;
        if(intensity <= 0)
        {
            // to be implemented
        }
        else
        {
             if ((intensity % 6) == 0)  // prevents updating too often
             { 
                 updateImage();
             }
        }
       
    }  
    
    public void updateImage()
    {
        //
    }
}
