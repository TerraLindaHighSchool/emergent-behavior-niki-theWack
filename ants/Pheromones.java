import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pheromones here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pheromones extends Actor
{
    private GreenfootImage image;
    private final int MAX_INTENSITY = 180 ;
    private int intensity;
    
    
    public Pheromones()
    {
        intensity = MAX_INTENSITY;
        updateImage();
        
    }
    
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
            getWorld().removeObject(this);
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
        int size = intensity / 3 + 5;
        image = new GreenfootImage(size + 1, size +1);
        
        image.setColor(new Color(225, 225, 225, intensity / 3 ));
        image.fillOval(0, 0, size, size);
        
        image.setColor(Color. GRAY);
        image.fillRect(size/2, size/2, 2, 2);
        
        setImage(image);
    }
}
