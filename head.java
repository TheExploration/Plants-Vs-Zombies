import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class head here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Head extends FallingObject
{
    /**
     * Act - do whatever the head wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Head() {
        super(-3, 0.2, 0.7, Random.Int(1, 5), 700L);
        
    }
    
}
