import greenfoot.*;

/**
 * An ant that collects food.
 * 
 * @author Michael Kölling
 * @version 0.1
 */
public class Ant extends Creature
{
    
    /** Current movement. Defined as the offset in x and y direction moved in each step. */
    private int deltaX;
    private int deltaY;
    private boolean carryingFood;
    private GreenfootImage image1 = getImage();
    private GreenfootImage image2 = new GreenfootImage("ant-with-food.gif");
    
    
    
    /**
     * Create an ant with a given home hill. The initial speed is zero (not moving).
     */
    public Ant(AntHill home)
    {
        setHomeHill(home);
    }
        
         private boolean atHome()
        {
            if (getHomeHill() != null) {
                return (Math.abs(getX() - getHomeHill().getX()) < 4) && 
                       (Math.abs(getY() - getHomeHill().getY()) < 4);
            }
            else {
                return false;
        }
    }
    
    private void searchForFood()
    {
        randomWalk();
        checkForFood();
    }
    
    private void status()
    {
        if(carryingFood = true && atHome())
        {
            setImage(image1);
            carryingFood = false;
            getHomeHill().countFood();
        }
        else
        {
            searchForFood();
        }
    }

    /**
     * Do what an ant's gotta do.
     */
    public void act()
    {
        randomWalk();
        checkForFood(); // This currently does not do anything
        
    }
    
    private void checkForFood()
    {
    
   
        Food food = (Food) getOneIntersectingObject(Food.class);
        if (food != null) 
        {
            food.removeCrumb();
        }
    
    
    }
}