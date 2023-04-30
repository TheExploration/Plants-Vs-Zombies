import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bush here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bush extends animatedObject
{
    /**
     * Act - do whatever the Bush wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] bush;
    public Bush() {
        bush = importSprites("bush",3);
    }
    public void act()
    {
        animate(bush, 300, true);
        // Add your action code here.
    }
}
