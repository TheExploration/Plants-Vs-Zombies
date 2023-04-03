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
            
            BasicZombie hitZombie = (BasicZombie)getOneIntersectingObject(Zombie.class);
            if (!hit) {
                
                AudioPlayer.play(80, "splat.wav", "splat2.wav", "splat3.wav");
                hitZombie.hit();
                hit = true;
                
            } else if (getX() < hitZombie.getX()) {
               move(speed); 
            }
        }
        
    }
}
