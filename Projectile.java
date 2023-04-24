import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pea here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Projectile extends animatedObject {
    public double speed = 4;
    public GreenfootImage[] image;
    public boolean hit = false;
    public MyWorld MyWorld;
    public boolean foundTarget = false;
    public Zombie hitZombie;
    public int frameCount;
    public int yPos;
    /**
     * Act - do whatever the Pea wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Projectile(String name, int frameCount, int yPos) {
        this.frameCount = frameCount;
        this.image = importSprites(name, frameCount);
        this.yPos = yPos;
        setImage(image[0]);
        
        
        
    }
    public void act()
    {
        if (getWorld() != null) {
            MyWorld = (MyWorld)getWorld();
            if (frame >= frameCount) {
                MyWorld.removeObject(this);   
                return;
            }
            if (!hit) {
                move(speed);
            } else {
                animate(image, 150, false);
            }
            if (isAtEdge()) {
                MyWorld.removeObject(this);   
                return;
            }
            for (Zombie i : MyWorld.level.zombieRow.get(yPos)) {
                if (Math.abs(i.getX() - getX()) < 20) {
                    if (!foundTarget) {
                        hitZombie = i;
                        foundTarget = true;
                    } 
                    if (!hit) {
                        
                        
                        hitZombie.hit(10);
                        hit = true;
                        
                    } else if (hitZombie.getWorld() != null && getX() < hitZombie.getX()) {
                       move(speed); 
                    }
                }
                
                
            }
            
           
        }
    }
}
