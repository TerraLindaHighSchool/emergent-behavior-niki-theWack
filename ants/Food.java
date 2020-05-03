import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class Food here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Food extends Actor
{
    private int size = 30;
    private int crumbs = 100;
    private GreenfootImage image = new GreenfootImage(size, size);
    
    /**
     * Act - do whatever the Food wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        removeCrumb();
    }   
    
    private void updateImage ()
    {
        Random random = new Random();
         int stDev = size / 6;
     int x = (int) (stDev * random.nextGaussian( ) + 3 * stDev);
     int y = (int) (stDev * random.nextGaussian( ) + 3 * stDev);
            
     // keep crumbs in image
     if(x < 0) 
         x = 0;
     if(x >= size) 
         x = size - 1;
     if(y < 0) 
         y = 0;
     if(y >= size) 
         y = size - 1;
     
     Color color = new Color(0, 255, 255);  // pick the color you want by replacing r, g, b with values.
     image.setColorAt(x, y, color);
     
     setImage(image);
    }
    
    public void removeCrumb ()
    {
       crumbs --;
       GreenfootImage image = getImage();
       image.clear();
       updateImage();
       
       Food food = (Food) getOneIntersectingObject(Food.class);
       if (food != null) 
       {
            food.removeCrumb();
       }
    }
}
