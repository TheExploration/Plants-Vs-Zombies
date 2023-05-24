import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Repeater here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Repeater extends Plant
{
    /**
     * Act - do whatever the Repeater wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.  */
    private GreenfootImage[] idle;
    private GreenfootImage[] shoot;
    private boolean shootOnce = false;
    private int shootCount = 0;
    private boolean resetFrame = false;
    private boolean shooting = false;
    private long shootDelay = 1700L;
    private long lastFrame2 = System.nanoTime();
    private long deltaTime2;
    
    public Repeater() {
        maxHp = 60;
        hp = maxHp;
        shoot = importSprites("repeatershoot", 3);
        idle = importSprites("repeater", 7);
    }
   
    public void hit(int dmg) {
        if (isLiving()) {
            if (!shootOnce) {
                hitFlash(idle, "repeater");
            } else {
                hitFlash(shoot, "repeatershoot");  
                
            }
            hp = hp-dmg;
        }
    }
    public void update() {
        MyWorld = (MyWorld)getWorld();
        currentFrame = System.nanoTime();
        if (!shooting) {
            animate(idle, 225, true);
            lastFrame2 = System.nanoTime();
        } else {
            
            deltaTime2 = (currentFrame - lastFrame2) / 1000000;
            if (deltaTime2 < shootDelay) {
                animate(idle, 225, true);
                shootCount = 0;
                resetFrame = false;
            } else {
                if (shootCount >= 2) {
                    lastFrame2 = currentFrame;
                }
                if (!resetFrame) {
                    setFrame(1);
                    resetFrame = true;
                }
                
                if (frame >= 3) {
                    AudioPlayer.play(80, "throw.mp3", "throw2.mp3");
                    MyWorld.addObject(new Pea(getYPos()), getX()+25,getY()-17);
                    setFrame(1);
                    setImage("repeatershoot1.png");
                    shootCount++;
                }
                animate(shoot, 70, false);
                
                
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
