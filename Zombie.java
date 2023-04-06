import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends animatedObject
{
    public int hp;
    public int maxHp;
    public double walkSpeed;
    public int eatSpeed;
    public boolean fixAnim = false;
    public boolean isAlive = true;
    public GreenfootImage[] headless;
    public GreenfootImage[] fall;
    public GreenfootImage[] flashHeadless;
    public boolean resetAnim = false;
    public boolean finalDeath = false;
    /**
     * Act - do whatever the Zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Zombie() {
        headless = importSprites("zombieheadless", 7);
        fall = importSprites("zombiefall",6);
        
    }
    public void act()
    {
        
        // Add your action code here.
    }
    
    public void deathAnim() {
        if (!resetAnim) {
                frame = 0;
                resetAnim = true;
        }
        if (frame <=7) {
            if (finalDeath) {
                if (!fixAnim) {
                    fixAnim = true;
                    setLocation(getX()-10, getY()+10);
                    
                }
                animate(fall, 350, false);
                
            } else {
                animate(headless, 350, false);
                move(-walkSpeed);
            }
        } else if (!finalDeath) {
            resetAnim = false;
            finalDeath = true;
        }

    }
    @Override
    protected void addedToWorld(World world) {
        
        
    }
    public boolean isLiving() {
        if (hp <=0) {
            isAlive = false;
        } else {
            isAlive = true;
        }
        return isAlive;
    }
    
}
