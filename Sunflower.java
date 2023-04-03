import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sunflower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sunflower extends Plant
{
    private GreenfootImage[] idle;
    private boolean flashed = false;   
    public Sunflower() {
        idle = importSprites("sunfloweridle", 8);
        flashed = false;
            
    }
    /**
     * Act - do whatever the Sunflower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        animate(idle, 200, true);

        if (flashed == false) {
            hitFlash(idle, "sunfloweridle");
            flashed=true;
        
        }
        
    }
}
