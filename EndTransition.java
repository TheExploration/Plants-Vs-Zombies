import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndTransition here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndTransition extends Actor
{
    /**
     * Act - do whatever the EndTransition wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int alpha = 255;
    public EndTransition() {
        getImage().setTransparency(255);
    }
    public void act()
    {
        alpha-=10;
        if (alpha >= 0) { 
            getImage().setTransparency(alpha);
        } else {
            getImage().setTransparency(0);
            getWorld().removeObject(this);
        }
        // Add your action code here.
    }
}
