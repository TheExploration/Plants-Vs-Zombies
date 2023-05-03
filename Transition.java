import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Transition here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Transition extends Actor
{
    /**
     * Act - do whatever the Transition wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public World world;
    public boolean fadeOut = false;
    public boolean startFade = false;
    public int fadeSpeed;
    public int alpha = 0;
    public int counter = 0;
    public int waitDuration = 0;
    
    public Transition(boolean fadeOut, World world, int speed) {
        this.fadeSpeed = speed;
        this.world = world;
        this.fadeOut = fadeOut;
        
        getImage().setTransparency(0);
    }
    public Transition(boolean fadeOut, World world, int speed, int waitDuration) {
        this.fadeSpeed = speed;
        this.world = world;
        this.fadeOut = fadeOut;
        this.waitDuration = waitDuration;
        getImage().setTransparency(0);
    }
    public Transition(boolean fadeOut, World world, String image, int speed) {
        this.fadeSpeed = speed;
        setImage(new GreenfootImage(image));
        this.world = world;
        this.fadeOut = fadeOut;
        getImage().setTransparency(0);
    }
    public void act()
    {
        alpha+=fadeSpeed;
        if (alpha <= 255) {
            
            getImage().setTransparency(alpha);
            
        } else {
            getImage().setTransparency(255);
            counter++;
            if (counter > waitDuration) {
                if (!fadeOut) {
                    changeWorld();
                    return;
                } else {
                    world.addObject(new EndTransition(), 316, 215);
                    changeWorld();
                    return;
                }
            }
        }
        
        // Add your action code here.
    }
    public void changeWorld() { 

        getWorld().removeObject(this);
        Greenfoot.setWorld(world);
    }
    public void addedToWorld(World world) {
        
    }
}
