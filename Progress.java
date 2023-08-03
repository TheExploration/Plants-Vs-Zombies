import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Progress here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Progress extends Actor
{
    /**
     * Act - do whatever the Progress wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //428, 14
    public long currentFrame = System.currentTimeMillis();
    public long lastFrame = System.currentTimeMillis();
    public long deltaTime = System.currentTimeMillis();
    public WaveManager level;
    
    public GreenfootImage bar = new GreenfootImage(428, 14);
    
    public Progress(WaveManager level) {
        this.level = level;
        
        
    }
    public void addedToWorld(World world) {
        for (int i : level.hugeWaves) {
            if (i == level.level.length-1) {
                getWorld().addObject(new Flag(), 290, 21);
            } else {
                int x = 700-(int)((double)(i+1)/(level.level.length)*428);
                getWorld().addObject(new Flag(), x, 21);
            }
            
        }
    }
    public void act()
    {
        currentFrame = System.currentTimeMillis();
        deltaTime = (currentFrame - lastFrame);
        if (level.wave != -1) {
            if (deltaTime > 2000L) {
                bar.setColor(new Color(240, 240, 128));
                bar.fillRect((int)(428-428*((double)(level.wave+1)/level.level.length)), 0, (int)(428*((double)(level.wave+1)/level.level.length)), 14);
                getImage().drawImage(bar, 14, 14);
                bar.setColor(new Color(192, 224, 96));
                bar.fillRect((int)(428-428*((double)(level.wave+1)/level.level.length)), 5, (int)(428*((double)(level.wave+1)/level.level.length)), 14);
                getImage().drawImage(bar, 14, 14);
                bar.setColor(new Color(152, 200, 80));
                bar.fillRect((int)(428-428*((double)(level.wave+1)/level.level.length)), 7, (int)(428*((double)(level.wave+1)/level.level.length)), 14);
                getImage().drawImage(bar, 14, 14);
                bar.setColor(new Color(128, 184, 64));
                bar.fillRect((int)(428-428*((double)(level.wave+1)/level.level.length)), 9, (int)(428*((double)(level.wave+1)/level.level.length)), 14);
                getImage().drawImage(bar, 14, 14);
                bar.setColor(new Color(80, 160, 32));
                bar.fillRect((int)(428-428*((double)(level.wave+1)/level.level.length)), 11, (int)(428*((double)(level.wave+1)/level.level.length)), 14);
                getImage().drawImage(bar, 14, 14);
            }
            
        }
    }
}
