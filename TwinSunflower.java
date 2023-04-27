import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sunflower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TwinSunflower extends Plant
{
    private GreenfootImage[] idle;
    private boolean test = false;
    private long lastFrame2 = System.nanoTime();
    private long deltaTime2;
    public TwinSunflower() {
        idle = importSprites("twinsunflower", 10);
        maxHp = 100;
        hp = maxHp;
    }
    /**
     * Act - do whatever the Sunflower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void update(){
        produceSun();
        animate(idle, 150, true);

    }
    public void hit(int dmg) {
        if (isLiving()) {
            hitFlash(idle, "twinsunflower");
            
            hp = hp-dmg;
        }
    }
    public void produceSun() {
        deltaTime2 = (currentFrame - lastFrame2) / 1000000;
        if (deltaTime2 > 20000L) {
            lastFrame2 = System.nanoTime();
            hitFlash(idle, "twinsunflower");
            test= true;
            MyWorld.addObject(new Sun(), getX()+10, getY()-10);
            MyWorld.addObject(new Sun(), getX()-10, getY()-10);
        }
    }
  
}
