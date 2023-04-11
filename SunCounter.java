import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SunCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SunCounter extends Actor
{
    public static final int x = 125;
    public static final int y = 50;
    public static int Sun = 0;
    /**
     * Act - do whatever the SunCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    Font font = new Font(10);
    
    public void act()
    {
        getImage().setFont(font);
        getImage().drawString("asd", x,y+20);
        // Add your action code here.
    }
    
}
