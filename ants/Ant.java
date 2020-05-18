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
    
    private boolean carryingFood = false;
    
    private GreenfootImage image1 ;
    private GreenfootImage image2 ;
    
    private final int MAX_PH_AVAILABLE = 16;
    private final int TIME_FOLLOWING_TRAIL = 30;
    private int phAvailable = MAX_PH_AVAILABLE; 
    private int followTrailTimeRemaining = 0;
  
    
    
    
    private int deltaX;
    private int deltaY;
    //private boolean carryingFood;
    
    
    
    /**
     * Create an ant with a given home hill. The initial speed is zero (not moving).
     */
    public Ant(AntHill home)
    {
        setHomeHill(home);
        
        phAvailable = MAX_PH_AVAILABLE;
        followTrailTimeRemaining = 0;
        
        image1 = getImage();
        image2 = new GreenfootImage("ant-with-food.gif");
    
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
        if(followTrailTimeRemaining == 0)
        {
            walkTowardsPheromoneCenter();
            randomWalk();
            
        }
        else
        {
            followTrailTimeRemaining--;
            walkAwayFromHome();
            
        }
        checkForFood();
        
    }
    
    private void status()
    {
            if(carryingFood == true)
            {
                handlePheromoneDrop();
                walkTowardsHome();
                
                 if (atHome())
                 {
                        setImage(image1);
                        carryingFood = false;
                        getHomeHill().countFood();
                        
                 }
            }
            else
            {
                searchForFood();
                
            }
    }

    private void handlePheromoneDrop ()
    {
         if ( MAX_PH_AVAILABLE == 16 )
        {
            new Pheromones();
            Pheromones ph = new Pheromones ();
            getWorld().addObject(ph, getX(), getY());
            phAvailable = 0;
        }
        else
        {
            phAvailable++;
        }
        //status();
        
    }
    
    private boolean smellsPheromone()
    {
        if ( isTouching(Pheromones.class) )
        {
           return(true);
        }
        else
        {
            return(false);
        }
     
    }
    
    private void walkTowardsPheromoneCenter()
    {
        Pheromones pheromones = (Pheromones) getOneIntersectingObject(Pheromones.class);
        if (pheromones != null) 
        {
            headTowards(pheromones);
            if(pheromones.getX() == getX() && pheromones.getY() == getY())
            {
                followTrailTimeRemaining = TIME_FOLLOWING_TRAIL;
            }
        }
        //handlePheromoneDrop();
    }
    
    /**
     * Do what an ant's gotta do.
     */
    public void act()
    {
        randomWalk();
        checkForFood(); // This currently does not do anything
        status();
        //handlePheromoneDrop();
    }
    
    private void checkForFood()
    {
    
        Food food = (Food) getOneIntersectingObject(Food.class);
        if (food != null) 
        {
            food.removeCrumb();
            carryingFood = true;
            setImage(image2);
        }
        
    }
}