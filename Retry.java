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
    public World restart;
    public Retry(World restart) {
        super("retry1.png", "retry2.png");
        this.restart = restart;
    }
    public void update() {
        getWorld().addObject(new Transition(false, restart, 10), 365, 215);
    }
}
