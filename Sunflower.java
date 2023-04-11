import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sunflower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sunflower extends Plant
{
    private GreenfootImage[] idle;
    private boolean test = false;
    
    public Sunflower() {
        idle = importSprites("sunfloweridle", 8);
        maxHp = 60;
        hp = maxHp;
    }
    /**
     * Act - do whatever the Sunflower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void update(){
        produceSun();
        animate(idle, 200, true);

    }
    public void hit(int dmg) {
        if (isLiving()) {
            hitFlash(idle, "sunfloweridle");
            
            hp = hp-dmg;
        }
    }
    public void produceSun() {
         if (!test) {
            hitFlash(idle, "sunfloweridle");
            test= true;
            MyWorld.addObject(new Sun(), getX(), getY()-10);
        }
    }
  
}
