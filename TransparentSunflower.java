import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TransparentSunflower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TransparentSunflower extends TransparentObject
{
    /**
     * Act - do whatever the TransparentSunflower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public TransparentSunflower(boolean bool) {
        if (bool) {
            getImage().setTransparency(125);
        } else {
            getImage().setTransparency(255);
        }
    }
    public void act()
    {
        // Add your action code here.
    }
}
