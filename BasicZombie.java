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
    
    public GreenfootImage[] idle;
    public GreenfootImage[] walk;
    public GreenfootImage[] armless;
    public GreenfootImage[] eat;
    public GreenfootImage[] armlesseat;
    
    public BasicZombie() {
        idle = importSprites("zombieidle", 4);
        walk = importSprites("zombiewalk", 7);
        eat = importSprites("zombieeating", 7);
        armlesseat = importSprites("armlesszombieeating", 7);
        armless = importSprites("armlesszombie", 7);
        walkSpeed = (((Math.random() * (15 - 12)) + 12)/100);
        maxHp = 100;
        hp = maxHp;
    }

    public void update() {
        if (hp > 50) {
            if (!isEating()) {
                animate(walk, 350, true);   
                move(-walkSpeed);
            } else {
                animate(eat, 200, true);
                playEating();
            }
        } else {
            if (!fallen) {
                fallen = true;
                AudioPlayer.play(80, "shoop.wav");
                MyWorld.addObject(new Arm(), getX()+8, getY()+10);
            }
            if (!isEating()) {
                animate(armless, 350, true);
                move(-walkSpeed);
            } else {
                animate(armlesseat, 200, true); 
                playEating();
            }
            
        }
        
    }
   
    public void hit(int dmg) {
        AudioPlayer.play(80, "splat.wav", "splat2.wav", "splat3.wav");
        if (isLiving()) {
            
            if (!fallen) {
                if (!eating) {
                    hitFlash(walk, "zombiewalk");
                } else {
                    hitFlash(eat, "zombieeating");
                }
            } else {
                if (!eating) {
                    hitFlash(armless, "armlesszombie");
                } else {
                    hitFlash(armlesseat, "armlesszombieeating");
                }
                
            }
            
            hp -= dmg;
        } else if (!finalDeath) {
            if (!eating) {
                hitFlash(headless, "zombieheadless");
            } else {
                hitFlash(headlesseating, "headlesszombieeating");
            }
        }
        
        
    }
    
    
}
