import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plant extends animatedObject
{
    private int maxHp;
    private int hp;
    private int damage;
    
    public Plant() {
        
    }
    /**
     * Act - do whatever the Plant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
        // Add your action code here.
    }
    public int getXPos() {
        return ((getX()-Board.xOffset)/Board.xSpacing);
    }   
    public int getYPos() {
        return ((getY()-Board.yOffset)/Board.ySpacing);
    }
}
