import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pea here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Pea extends animatedObject
{
    private double speed = 4;
    private GreenfootImage[] pea;
    private boolean hit = false;
    public MyWorld MyWorld;
    private boolean foundTarget = false;
    public Zombie hitZombie;
    /**
     * Act - do whatever the Pea wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Pea() {
        pea = importSprites("pea",3);
        setImage(pea[0]);
        
    }
    public void act()
    {
        
        MyWorld = (MyWorld)getWorld();
        if (frame >= 3) {
            MyWorld.removeObject(this);   
            return;
        }
        if (!hit) {
            move(speed);
        } else {
            animate(pea, 150, false);
        }
        if (isAtEdge()) {
            MyWorld.removeObject(this);   
            return;
        }
        if (isTouching(Zombie.class)) {
            
            if (!((Zombie)getOneIntersectingObject(Zombie.class)).finalDeath) {
                if (!foundTarget) {
                    hitZombie = (Zombie)getOneIntersectingObject(Zombie.class);
                    foundTarget = true;
                }
                
                
                if (!hit) {
                    
                    
                    hitZombie.hit(10);
                    hit = true;
                    
                } else if (getX() < hitZombie.getX()) {
                   move(speed); 
                }
            }
        }
        
    }
}
