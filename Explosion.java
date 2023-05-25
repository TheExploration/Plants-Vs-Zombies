import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends animatedObject
{
    public GreenfootImage[] explosion;
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Explosion() {
        explosion = importSprites("spudow",8);
    }
    public void addedToWorld(World world) {
        AudioPlayer.play(80, "potato_mine.mp3");
        
        
    }
    public void act()
    {
        if (frame <= 8) {
            animate(explosion, 50L, false);
        } else {
            getWorld().removeObject(this);
            return;
            
        }
        // Add your action code here.
    }
}
