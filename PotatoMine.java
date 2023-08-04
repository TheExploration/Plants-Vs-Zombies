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
    public boolean armed = false;
    private long lastFrame2 = System.nanoTime();
    private boolean playSFX = false;
    private long deltaTime2 = System.nanoTime();
    public PotatoMine() {
        idle = importSprites("potato", 5);
        arm = importSprites("potatomine", 3);
        maxHp = 60;
        hp = maxHp;
        currentFrame = System.nanoTime();
        lastFrame2 = System.nanoTime();
    }
    
    public void update() {
        currentFrame = System.nanoTime();
        deltaTime2 = (currentFrame - lastFrame2) / 1000000;
        if (deltaTime2 > 22000L) {
            armed = true;
            if (!playOnce) {
                if (!playSFX) {
                    playSFX = true;
                    AudioPlayer.play(70, "dirt_rise.mp3");
                }
                animate(arm, 200, false);
                if (frame > 2) {
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
            
            
            hp = hp-dmg;
        }
    }
    public void checkExplosion() {
        if (MyWorld.level.zombieRow.get(getYPos()).size() == 0) {
            
        } else {
            
            for (Zombie i : MyWorld.level.zombieRow.get(getYPos())) {
                if (Math.abs(i.getX() - getX()) < 28) {
                    
                    getWorld().addObject(new Explosion(MyWorld.level.zombieRow.get(getYPos())), getX(), getY()-25);
                    ((MyWorld)getWorld()).board.removePlant(getXPos(), getYPos());
                    return;
                } 
            }
                                    
        }
    }
    
  
}
