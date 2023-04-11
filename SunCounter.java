import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SunCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SunCounter extends Actor
{
    public static final int x = 120;
    public static final int y = 50;
    public int sun = 0;
    /**
     * Act - do whatever the SunCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    MyWorld MyWorld;
    
    public void act()
    {
        
        // Add your action code here.
    }
    
    public void addedToWorld(World world) {
        MyWorld = (MyWorld)getWorld();
        updateText();
    }
    public void updateText() {
        String number = ""+sun;
        char[] text = number.toCharArray();
        for (char i : text) {
            
        }
    }
    
}
