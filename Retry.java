import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Retry here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Retry extends Button
{
    /**
     * Act - do whatever the Retry wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Retry() {
        super("retry1.png", "retry2.png");
    }
    public void update() {
        getWorld().addObject(new Transition(false, new MyWorld(), 10), 365, 215);
    }
}
