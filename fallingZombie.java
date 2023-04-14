import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class fallingZombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class fallingZombie extends animatedObject
{
    /**
     * Act - do whatever the fallingZombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public GreenfootImage[] fall;
    
    
    public fallingZombie(GreenfootImage[] fall) {
        this.fall = fall;
    }
    public void act()
    {
        if (getImage().getTransparency() <= 0) {
            getWorld().removeObject(this);
            return;
        }
        if (frame <= 7) {
        
        
        animate(fall, 200, false);
        } else {
            if (getImage().getTransparency()-3 <= 0) {
                getImage().setTransparency(0);
            } else {
                getImage().setTransparency(getImage().getTransparency()-3);
            }
        }
        // Add your action code here.
    }
}
