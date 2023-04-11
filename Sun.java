import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sun extends FallingObject
{
    /**
     * Act - do whatever the Sun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public MyWorld MyWorld;
    public GreenfootImage[] sun;
    public boolean clicked = false;
    public boolean beenClicked = false;
    public Sun() {
        super(-3, 0.2, Random.Int(-2, 2), Random.Int(-1,1), 600L);
        sun = importSprites("sun", 2);
        
    }
    public void update() {
        currentFrame = System.nanoTime();
        deltaTime = (currentFrame - lastFrame) / 1000000;
        animate(sun, 200, true);
        if (!beenClicked) {
            if (checkClick()) {
                beenClicked = true;
                AudioPlayer.play(90, "points.wav");
                SunCounter.Sun+=25;
            }
        }
        
        if (!beenClicked) {
            if (deltaTime < fallTime) {
                double x = getExactX()+hSpeed;
                double y = getExactY()+vSpeed;
                setLocation(x,y);
                
                turn(rotate);
                
                vSpeed = vSpeed + acceleration;
            } 
                
            
        } else {
            if (!(Math.abs(getX()-SunCounter.x) < 10 && Math.abs(getY()-SunCounter.y) < 10)) {
                turnTowards(SunCounter.x,SunCounter.y);
                move(20);
            }
        }
        checkDeath();
    }
    public boolean checkClick() {
        if (Greenfoot.mouseClicked(this)) {
            clicked =  true;
        } else {
            clicked = false;
        }
        return clicked;
    }
    public void checkDeath() {
        if (Math.abs(getX()-SunCounter.x) < 10 && Math.abs(getY()-SunCounter.y) < 10) {
            
            if (getImage().getTransparency() > 0) {
                if (getImage().getTransparency()-50 <= 0) {
                    getImage().setTransparency(0);
                } else {
                    getImage().setTransparency(getImage().getTransparency()-50);
                }
            } else {
                getWorld().removeObject(this);
                return;
            }
        }
        
    }
    @Override
    public void addedToWorld(World world) {
         MyWorld = (MyWorld)getWorld();
    }
}
