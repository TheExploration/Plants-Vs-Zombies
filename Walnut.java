import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Walnut here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Walnut extends Plant
{
    /**
     * Act - do whatever the Walnut wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage[] idle;
    private GreenfootImage[] d;
    private GreenfootImage[] dd;
    private boolean test = false;
    private long lastFrame2 = System.nanoTime();
    private long deltaTime2;
    public Walnut() {
        idle = importSprites("walnut", 5);
        d = importSprites("walnutd", 5);
        dd = importSprites("walnutdd", 5);
        maxHp = 730;
        hp = maxHp;
    }
    
    public void update(){
        if (hp >= 480) {
            animate(idle, 200, true);
        } else if (hp >= 240) {
            animate(d, 200, true);
        } else {
            animate(dd, 200, true);
        }

    }
    public void hit(int dmg) {
        if (isLiving()) {
            if (hp >= 480) {
                hitFlash(idle, "walnut");
            } else if (hp >= 240) {
                hitFlash(d, "walnutd");
            } else {
                hitFlash(dd, "walnutdd");
            }
            
            
            hp = hp-dmg;
        }
    }
  
}
