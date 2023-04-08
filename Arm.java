import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arm here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arm extends FallingObject
{
    /**
     * Act - do whatever the Arm wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Arm() {
        super(0.1, 0.2, 0.2, Random.Int(-1,1), 350L);
    }
  
}
