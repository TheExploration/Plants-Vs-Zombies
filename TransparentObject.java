import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TransparentObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TransparentObject extends Actor
{
    /**
     * Act - do whatever the TransparentObject wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public TransparentObject() {
        
    }
    public void act()
    {
        // Add your action code here.
    }
    public void setTransparent(boolean bool) {
        if (bool) {
            getImage().setTransparency(125);
        } else {
            getImage().setTransparency(255);
        }
    }
}
