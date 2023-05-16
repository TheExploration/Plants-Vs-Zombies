import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class First here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class First extends World
{

    /**
     * Constructor for objects of class First.
     * 
     */
    public First()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(576, 430, 1, false); 
        setBackground(new GreenfootImage("transition.png"));
        addObject(new Transition(true, new PopCap(),10),288, 215);
        setPaintOrder(EndTransition.class, Transition.class);
    }
    public void act() {
        
    }
}
