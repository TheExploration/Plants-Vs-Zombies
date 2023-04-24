import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dirt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dirt extends animatedObject
{
    public GreenfootImage[] dirt;
    /**
     * Act - do whatever the Dirt wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Dirt() {
        dirt = importSprites("dirt",4);
    }
    public void act()
    {
        if (frame <= 3) {
            animate(dirt, 50L, false);
        } else {
            getWorld().removeObject(this);
            return;
            
        }
        // Add your action code here.
    }
}
