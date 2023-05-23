import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BasicZombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Brickhead extends Zombie
{
    /**
     * Act - do whatever the BasicZombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean brick = true;
    public GreenfootImage[] idle;
    public GreenfootImage[] walk;
    public GreenfootImage[] armless;
    public GreenfootImage[] eat;
    public GreenfootImage[] armlesseat;
    public GreenfootImage[] brickhead;
    public GreenfootImage[] brickheadwalk;
    public GreenfootImage[] brickheadwalkd;
    public GreenfootImage[] brickheadwalkdd;
    public GreenfootImage[] brickheadeat;
    public GreenfootImage[] brickheadeatd;
    public GreenfootImage[] brickheadeatdd;
    
    public Brickhead() {
        idle = importSprites("zombieidle", 4);
        walk = importSprites("zombiewalk", 7);
        eat = importSprites("zombieeating", 7);
        armlesseat = importSprites("armlesszombieeating", 7);
        armless = importSprites("armlesszombie", 7);
        
        
        brickheadwalk = importSprites("brickhead", 7);
        brickheadwalkd = importSprites("brickheadd", 7);
        brickheadwalkdd = importSprites("brickheaddd", 7);
        brickheadeat = importSprites("brickheadeat", 7);
        brickheadeatd = importSprites("brickheadeatd", 7);
        brickheadeatdd = importSprites("brickheadeatdd", 7);
        
        
        walkSpeed = Random.Double(11, 14);
        maxHp = 1400;
        hp = maxHp;
    }

    public void update() {
        if (hp > 966) {
            if (!isEating()) {
                animate(brickheadwalk, 350, true);   
                move(-walkSpeed);
            } else {
                animate(brickheadeat, 200, true);
                playEating();
            }
        } else if (hp > 533) {
            if (!isEating()) {
                animate(brickheadwalkd, 350, true);   
                move(-walkSpeed);
            } else {
                animate(brickheadeatd, 200, true);
                playEating();
            }
        } else if (hp > 100) {
            if (!isEating()) {
                animate(brickheadwalkdd, 350, true);   
                move(-walkSpeed);
            } else {
                animate(brickheadeatdd, 200, true);
                playEating();
            }
        } else {
            if (brick) {
                brick = false;
                MyWorld.addObject(new Brick(), getX(), getY()-25);
            }
            
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
                    AudioPlayer.play(80, "limbs_pop.mp3");
                    MyWorld.addObject(new Arm(), getX()+8, getY()+20);
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
    }
   
    public void hit(int dmg) {
    
        AudioPlayer.play(70, "splat.mp3", "splat2.mp3", "splat3.mp3");
        
        
        if (isLiving()) {
            if (hp > 966) {
                if (!isEating()) {
                    hitFlash(brickheadwalk, "brickhead");
                } else {
                    hitFlash(brickheadeat, "brickheadeat");
                    
                }
            } else if (hp > 533) {
                if (!isEating()) {
                    hitFlash(brickheadwalkd, "brickheadd");
                } else {
                    hitFlash(brickheadeatd, "brickheadeatd");
                }
            } else if (hp > 100) {
                if (!isEating()) {
                    hitFlash(brickheadwalkdd, "brickheaddd");
                } else {
                    hitFlash(brickheadeatdd, "brickheadeatdd");
                }
            } else {        
                
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
