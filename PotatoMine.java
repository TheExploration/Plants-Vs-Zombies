import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PotatoMine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PotatoMine extends Plant
{
    private GreenfootImage[] idle;
    private GreenfootImage[] arm;
    private boolean playOnce = false;
    private boolean armed = false;
    private long lastFrame2 = System.nanoTime();
    private long deltaTime2;
    public PotatoMine() {
        idle = importSprites("potato", 5);
        arm = importSprites("potatomine", 3);
        maxHp = 60;
        hp = maxHp;
    }
    /**
     * Act - do whatever the PotatoMine wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void update(){
        deltaTime2 = (currentFrame - lastFrame2) / 1000000;
        if (deltaTime2 > 5000L) {
            armed = true;
            if (!playOnce) {
                
                animate(arm, 200, false);
                if (frame < 3) {
                    playOnce = true;
                }
            } else {
                animate(idle, 200, true);
            }
            checkExplosion();
            
        }
        

    }
    public void hit(int dmg) {
        if (isLiving() && !armed) {
            hitFlash(arm, "potatomine");
            
            hp = hp-dmg;
        }
    }
    public void checkExplosion() {
        if (MyWorld.level.zombieRow.get(getYPos()).size() == 0) {
            
        } else {
            
            for (Zombie i : MyWorld.level.zombieRow.get(getYPos())) {
                if (Math.abs(i.getX() - getX()) < 30) {
                    getWorld().addObject(new Explosion(), getX(), getY());
                    getWorld().removeObject(this);
                    return;
                } 
            }
                                    
        }
    }
    
  
}
