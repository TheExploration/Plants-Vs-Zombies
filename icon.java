import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class icon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class icon extends World
{

    /**
     * Constructor for objects of class icon.
     * 
     */
    public icon()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 576, 1); 
        Greenfoot.setWorld(new First());
    }
    public void started() {
        Greenfoot.setWorld(new First());
    }
    public void act() {
        Greenfoot.setWorld(new First());
    }
}
