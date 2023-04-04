import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BasicZombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BasicZombie extends Zombie
{
    /**
     * Act - do whatever the BasicZombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean flashed = false;
    public GreenfootImage[] idle;
    public GreenfootImage[] walk;
    
    public BasicZombie() {
        idle = importSprites("zombieidle", 4);
        walk = importSprites("zombiewalk", 7);
        walkSpeed = (((Math.random() * (16 - 14)) + 16)/100);
        maxHp = 20;
        hp = maxHp;
    }
    public void act()
    {
        if (isLiving()) {
            animate(walk, 350, true);
           
            move(-walkSpeed);
        } else {
            deathAnim();            
            
        }
    }
    
    public void hit(int dmg) {
       
        AudioPlayer.play(80, "splat.wav", "splat2.wav", "splat3.wav");
        if (isLiving()) {
            hitFlash(walk, "zombiewalk");
        }
        hp -= dmg;
        
    }
    
    
}
