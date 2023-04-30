import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{
    Hitbox hitbox = new Hitbox();
    GreenfootSound menutheme = new GreenfootSound("menutheme.mp3");
    public MainMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(576, 430, 1, false); 
        addObject(hitbox,0,0);
        addObject(new Start(), 412, 132);
        Greenfoot.setSpeed(50);
    }
    public void started() {
        if (!menutheme.isPlaying()) {
            menutheme.setVolume(70);
            menutheme.playLoop();
        }
    
    }

    public void moveHitbox() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            hitbox.setLocation(mouse.getX(), mouse.getY());
        }
    }
    
}
