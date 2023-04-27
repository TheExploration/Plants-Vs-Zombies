import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cactus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cactus extends Plant
{
    /**
     * Act - do whatever the Peashooter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.  */
    private GreenfootImage[] idle;
    private GreenfootImage[] shoot;
    private boolean shootOnce = false;
    private boolean shooting = false;
    private long shootDelay = 2400L;
    private long lastFrame2 = System.nanoTime();
    private long deltaTime2;
    
    public Cactus() {
        maxHp = 100;
        hp = maxHp;
        shoot = importSprites("cactusshoot", 2);
        idle = importSprites("cactus", 4);
    }
   
    public void hit(int dmg) {
        if (isLiving()) {
            if (!shootOnce) {
                hitFlash(idle, "cactus");
            } else {
                hitFlash(shoot, "cactusshoot");  
                
            }
            hp = hp-dmg;
        }
    }
    public void update() {
        MyWorld = (MyWorld)getWorld();
        currentFrame = System.nanoTime();
        if (!shooting) {
            animate(idle, 150, true);
            lastFrame2 = System.nanoTime();
        } else {
            
            deltaTime2 = (currentFrame - lastFrame2) / 1000000;
            if (deltaTime2 < shootDelay) {
                animate(idle, 150, true);
                shootOnce = false;
            } else {
                if (!shootOnce) {
                    shootOnce = true;
                    frame = 0;
                    
                }
                
                if (frame >= 2) {
                    
                    MyWorld.addObject(new Needle(getYPos()), getX()+30,getY()-8);
                    lastFrame2 = currentFrame;
                }
                animate(shoot, 150, false);
                
                
            }
            
            
        }
        if (MyWorld.level.zombieRow.get(getYPos()).size() == 0) {
            shooting = false;
        } else {
            
            for (Zombie i : MyWorld.level.zombieRow.get(getYPos())) {
                if (i.getX() > getX() && i.getX()<=MyWorld.getWidth()+10){
                    shooting = true;
                    break;
                } else {
                    shooting = false;
                }
            }
                                    
        }
    }
}
