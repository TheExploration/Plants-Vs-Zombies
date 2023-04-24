import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TransparentWalnut here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TransparentWalnut extends TransparentObject
{
    /**
     * Act - do whatever the TransparentWalnut wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public TransparentWalnut(boolean bool) {
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
