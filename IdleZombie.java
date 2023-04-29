import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IdleZombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IdleZombie extends animatedObject
{
    /**
     * Act - do whatever the IdleZombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    public void addedToWorld(World world) {
        frame = Random.Int(1,4);
    }
}
