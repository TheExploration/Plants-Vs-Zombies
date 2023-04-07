import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class fallingObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FallingObject extends SmoothMover
{
    /**
     * Act - do whatever the fallingObject wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public double vSpeed = 0;
    public double acceleration = 1;
    public long deltaTime;
    public long lastFrame = System.nanoTime();
    public long currentFrame = System.nanoTime();  
    public long fallTime;
    public FallingObject(double vSpeed, double acceleration) {
        this.vSpeed = vSpeed;
        this.acceleration = acceleration;
        lastFrame = System.nanoTime();
        currentFrame = System.nanoTime();    
    }
    public void act()
    {
        currentFrame = System.nanoTime();
        deltaTime = (currentFrame - lastFrame) / 1000000;
        if (deltaTime < 700L) {
            double x = getExactX()+0.6;
            double y = getExactY()+vSpeed;
            setLocation(x,y);
            turn(2);
            vSpeed = vSpeed + acceleration;
        } else if (getImage().getTransparency() > 0) {
            getImage().setTransparency(getImage().getTransparency()-5);
        } else {
            getWorld().removeObject(this);
            return;
        }
        // Add your action code here.
    }
}
