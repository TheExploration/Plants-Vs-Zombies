import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BasicZombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BasicZombie extends Zombie
{
    /**
     * Act - do whatever the BasicZombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean flashed = false;
    public GreenfootImage[] idle;
    public GreenfootImage[] walk;
    public BasicZombie() {
        idle = importSprites("zombieidle", 4);
        walk = importSprites("zombiewalk", 6);
        walkSpeed = (((Math.random() * (16 - 15)) + 16)/100);
        
    }
    public void act()
    {
       animate(walk, 250, true);
       
       move(-walkSpeed);
    }
    public void hit() {
        hitFlash(walk, "zombiewalk");
    }
    
    
}
