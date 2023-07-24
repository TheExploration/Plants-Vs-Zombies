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
    public long lastFrame2 = System.nanoTime();
    public long deltaTime2 = System.nanoTime();
    public Sun() {
        super(-3, 0.15, Random.Double(-100, 100), 0, 800L);
        sun = importSprites("sun", 2);
        
    }
    public void update() {
        
        currentFrame = System.nanoTime();
        deltaTime = (currentFrame - lastFrame) / 1000000;
        deltaTime2 = (currentFrame - lastFrame2) / 1000000;
        animate(sun, 200, true);
        if (!beenClicked) {
            if (checkClick()) {
                beenClicked = true;
                AudioPlayer.play(90, "points.mp3");
                MyWorld.seedbank.suncounter.addSun(25);
                
            } else {
                if (deltaTime2 > 12000) {
                    if (getImage().getTransparency() > 0) {
                        if (getImage().getTransparency()-20 <= 0) {
                            getImage().setTransparency(0);
                        } else {
                            getImage().setTransparency(getImage().getTransparency()-20);
                        }
                    } else {
                        getWorld().removeObject(this);
                        return;
                    }
                }
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
            if (!(Math.abs(getX()-SunCounter.x) < 20 && Math.abs(getY()-SunCounter.y) < 20)) {
                turnTowards(SunCounter.x,SunCounter.y);
                move(20);
            }
        }
        checkDeath();
    }
    public boolean checkClick() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null && Greenfoot.mouseClicked(null)) {
            
            MyWorld.moveHitbox();
            if (intersects(MyWorld.hitbox)) {
                clicked =  true;    
            } else {
                clicked = false;
            }
            return clicked;
        }
            
        
        clicked = false;
        return clicked;
        
    }
    public void checkDeath() {
        if (Math.abs(getX()-SunCounter.x) < 20 && Math.abs(getY()-SunCounter.y) < 20) {
            move(0.5);
            if (getImage().getTransparency() > 0) {
                if (getImage().getTransparency()-20 <= 0) {
                    getImage().setTransparency(0);
                } else {
                    getImage().setTransparency(getImage().getTransparency()-20);
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
