import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class fallingObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FallingObject extends animatedObject
{
    /**
     * Act - do whatever the fallingObject wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public double vSpeed = 0;
    public double hSpeed = 0;
    public double acceleration = 1;
    public long deltaTime;
    public long lastFrame = System.nanoTime();
    public long currentFrame = System.nanoTime();  
    public long fallTime;
    public int rotate;
    public FallingObject(double vSpeed, double acceleration, double hSpeed, int rotate, long time) {
        this.vSpeed = vSpeed;
        this.acceleration = acceleration;
        this.rotate = rotate;
        this.hSpeed = hSpeed;
        this.fallTime = time; 
        lastFrame = System.nanoTime();
        currentFrame = System.nanoTime();    
    }
    public void act()
    {
        update();
        
    }
    
    public void update() {
        currentFrame = System.nanoTime();
        deltaTime = (currentFrame - lastFrame) / 1000000;
        if (deltaTime < fallTime) {
            double x = getExactX()+hSpeed;
            double y = getExactY()+vSpeed;
            setLocation(x,y);
            
            turn(rotate);
            
            vSpeed = vSpeed + acceleration;
        } else {
            checkDeath();
        }
    }
    public void checkDeath() {
        if (getImage().getTransparency() > 0) {
            if (getImage().getTransparency()-3 <= 0) {
                getImage().setTransparency(0);
            } else {
                getImage().setTransparency(getImage().getTransparency()-3);
            }
        } else {
            getWorld().removeObject(this);
            return;
        }
    }
}
