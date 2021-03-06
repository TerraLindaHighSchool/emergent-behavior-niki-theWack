import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.List;
/**
 * The world where ants live.
 * 
 * @author Michael Kölling
 * @version 0.1
 */
public class AntWorld extends World
{
    public static final int SIZE = 640;

    /**
     * Create a new world. It will be initialised with a few ant hills
     * and food sources
     */
    public AntWorld()
    {
        super(SIZE, SIZE, 1);
        setPaintOrder(Ant.class, AntHill.class);
        prepare();
    }
    
    public void act()
    {
        if (getObjects(Food.class).size() == 0)
        {
            Greenfoot.stop();
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        AntHill antHill = new AntHill();
        addObject(antHill,171,193);
        AntHill antHill2 = new AntHill();
        addObject(antHill2,341,78);
        Food food = new Food();
        addObject(food,172,517);
        Food food2 = new Food();
        addObject(food2,520,332);
        Food food3 = new Food();
        addObject(food3,213,77);
    }
}
