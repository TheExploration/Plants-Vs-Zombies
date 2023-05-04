import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BasicZombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Buckethead extends Zombie
{
    /**
     * Act - do whatever the BasicZombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean bucket = true;
    public GreenfootImage[] idle;
    public GreenfootImage[] walk;
    public GreenfootImage[] armless;
    public GreenfootImage[] eat;
    public GreenfootImage[] armlesseat;
    public GreenfootImage[] buckethead;
    public GreenfootImage[] bucketheadwalk;
    public GreenfootImage[] bucketheadwalkd;
    public GreenfootImage[] bucketheadwalkdd;
    public GreenfootImage[] bucketheadeat;
    public GreenfootImage[] bucketheadeatd;
    public GreenfootImage[] bucketheadeatdd;
    
    public Buckethead() {
        idle = importSprites("zombieidle", 4);
        walk = importSprites("zombiewalk", 7);
        eat = importSprites("zombieeating", 7);
        armlesseat = importSprites("armlesszombieeating", 7);
        armless = importSprites("armlesszombie", 7);
        
        //Conehead
        bucketheadwalk = importSprites("bucketheadwalk", 7);
        bucketheadwalkd = importSprites("bucketheadwalkd", 7);
        bucketheadwalkdd = importSprites("bucketheadwalkdd", 7);
        bucketheadeat = importSprites("bucketheadeat", 7);
        bucketheadeatd = importSprites("bucketheadeatd", 7);
        bucketheadeatdd = importSprites("bucketheadeatdd", 7);
        
        
        walkSpeed = Random.Double(11, 14);
        maxHp = 700;
        hp = maxHp;
    }

    public void update() {
        if (hp > 500) {
            if (!isEating()) {
                animate(bucketheadwalk, 350, true);   
                move(-walkSpeed);
            } else {
                animate(bucketheadeat, 200, true);
                playEating();
            }
        } else if (hp > 300) {
            if (!isEating()) {
                animate(bucketheadwalkd, 350, true);   
                move(-walkSpeed);
            } else {
                animate(bucketheadeatd, 200, true);
                playEating();
            }
        } else if (hp > 100) {
            if (!isEating()) {
                animate(bucketheadwalkdd, 350, true);   
                move(-walkSpeed);
            } else {
                animate(bucketheadeatdd, 200, true);
                playEating();
            }
        } else {
            if (bucket) {
                bucket = false;
                MyWorld.addObject(new Bucket(), getX(), getY()-25);
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
        if (bucket) {
            AudioPlayer.play(70, "shieldhit.mp3", "shieldhit2.mp3");
        } else {
            AudioPlayer.play(70, "splat.mp3", "splat2.mp3", "splat3.mp3");
        }
        
        if (isLiving()) {
            if (hp > 500) {
                if (!isEating()) {
                    hitFlash(bucketheadwalk, "bucketheadwalk");
                } else {
                    hitFlash(bucketheadeat, "bucketheadeat");
                    
                }
            } else if (hp > 300) {
                if (!isEating()) {
                    hitFlash(bucketheadwalkd, "bucketheadwalkd");
                } else {
                    hitFlash(bucketheadeatd, "bucketheadeatd");
                }
            } else if (hp > 100) {
                if (!isEating()) {
                    hitFlash(bucketheadwalkdd, "bucketheadwalkdd");
                } else {
                    hitFlash(bucketheadeatdd, "bucketheadeatdd");
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
