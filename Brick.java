import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Brick here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Brick extends FallingObject
{
    /**
     * Act - do whatever the Brick wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Brick() {
        super(-2, 0.2, 0.9, Random.Int(1, 5), 640L);
        
    }
}
