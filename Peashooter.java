import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Peashooter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Peashooter extends Plant
{
    /**
     * Act - do whatever the Peashooter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.  */
    private GreenfootImage[] idle;
    private GreenfootImage[] shoot;
    private boolean shootOnce = false;
    private boolean shooting = false;
    private long shootDelay = 1700L;
    private long lastFrame2 = System.nanoTime();
    private long deltaTime2;
    
    public Peashooter() {
        shoot = importSprites("peashootershoot", 3);
        idle = importSprites("peashooter", 9);
    }
    public void act()
    {
        MyWorld MyWorld = (MyWorld)getWorld();
        currentFrame = System.nanoTime();
        if (!shooting) {
            animate(idle, 150, true);
            lastFrame2 = System.nanoTime();
        } else {
            
            deltaTime2 = (currentFrame - lastFrame2) / 1000000;
            if (deltaTime2 < shootDelay) {
                animate(idle, 150, true);
            } else {
                if (!shootOnce) {
                    shootOnce = true;
                    frame = 0;
                    AudioPlayer.play(80, "throw.wav", "throw2.wav");
                    MyWorld.addObject(new Pea(), getX()+20,getY()-19);
                }
                if (frame >= 2) {
                    shootOnce = false;
                    lastFrame2 = currentFrame;
                }
                animate(shoot, 100, false);
                
                
            }
            
            
        }
        if (MyWorld.level.zombieRow.get(getYPos()).size() == 0) {
            shooting = false;
        } else {
            for (int i = 0; i < MyWorld.level.zombieRow.get(getYPos()).size(); i++) {
                if (MyWorld.level.zombieRow.get(getYPos()).get(i).getX() > getX()){
                    shooting = true;
                    
                } else {
                    shooting = false;
                }
                
            }             
        }
           
        
    }
 
}
