import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PopCap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PopCap extends World
{

    /**
     * Constructor for objects of class PopCap.
     * 
     */
    public int counter = 0;
    public GreenfootSound menutheme = new GreenfootSound("menutheme.mp3");
    public PopCap()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(576, 430, 1, false); 
        setPaintOrder(EndTransition.class, Transition.class);
        
    }
    public void act() {
        if (!menutheme.isPlaying()) {
            menutheme.setVolume(70);
            menutheme.playLoop();
        }
        counter++;
        if (counter > 100) {
            addObject(new Transition(true, new MainMenu(menutheme), 6), 288, 215);
        }
    }
}
