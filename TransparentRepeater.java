import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TransparentRepeater here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TransparentRepeater extends TransparentObject
{
    /**
     * Act - do whatever the TransparentRepeater wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public TransparentRepeater(boolean bool) {
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
