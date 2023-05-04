import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BasicZombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Conehead extends Zombie
{
    /**
     * Act - do whatever the BasicZombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean cone = true;
    public GreenfootImage[] idle;
    public GreenfootImage[] walk;
    public GreenfootImage[] armless;
    public GreenfootImage[] eat;
    public GreenfootImage[] armlesseat;
    public GreenfootImage[] conehead;
    public GreenfootImage[] coneheadwalk;
    public GreenfootImage[] coneheadwalkd;
    public GreenfootImage[] coneheadwalkdd;
    public GreenfootImage[] coneheadeat;
    public GreenfootImage[] coneheadeatd;
    public GreenfootImage[] coneheadeatdd;
    
    public Conehead() {
        idle = importSprites("zombieidle", 4);
        walk = importSprites("zombiewalk", 7);
        eat = importSprites("zombieeating", 7);
        armlesseat = importSprites("armlesszombieeating", 7);
        armless = importSprites("armlesszombie", 7);
        
        //Conehead
        coneheadwalk = importSprites("coneheadwalk", 7);
        coneheadwalkd = importSprites("coneheadwalkd", 7);
        coneheadwalkdd = importSprites("coneheadwalkdd", 7);
        coneheadeat = importSprites("coneheadeat", 7);
        coneheadeatd = importSprites("coneheadeatd", 7);
        coneheadeatdd = importSprites("coneheadeatdd", 7);
        
        
        walkSpeed = Random.Double(11, 14);
        maxHp = 300;
        hp = maxHp;
    }

    public void update() {
        if (hp > 232) {
            if (!isEating()) {
                animate(coneheadwalk, 350, true);   
                move(-walkSpeed);
            } else {
                animate(coneheadeat, 200, true);
                playEating();
            }
        } else if (hp > 166) {
            if (!isEating()) {
                animate(coneheadwalkd, 350, true);   
                move(-walkSpeed);
            } else {
                animate(coneheadeatd, 200, true);
                playEating();
            }
        } else if (hp > 100) {
            if (!isEating()) {
                animate(coneheadwalkdd, 350, true);   
                move(-walkSpeed);
            } else {
                animate(coneheadeatdd, 200, true);
                playEating();
            }
        } else {
            if (cone) {
                cone = false;
                MyWorld.addObject(new Cone(), getX(), getY()-25);
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
        AudioPlayer.play(70, "plastichit.mp3", "plastichit2.mp3");
        AudioPlayer.play(70, "splat.mp3", "splat2.mp3", "splat3.mp3");
        if (isLiving()) {
            if (hp > 232) {
                if (!isEating()) {
                    hitFlash(coneheadwalk, "coneheadwalk");
                } else {
                    hitFlash(coneheadeat, "coneheadeat");
                    
                }
            } else if (hp > 166) {
                if (!isEating()) {
                    hitFlash(coneheadwalkd, "coneheadwalkd");
                } else {
                    hitFlash(coneheadeatd, "coneheadeatd");
                }
            } else if (hp > 100) {
                if (!isEating()) {
                    hitFlash(coneheadwalkdd, "coneheadwalkdd");
                } else {
                    hitFlash(coneheadeatdd, "coneheadeatdd");
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
