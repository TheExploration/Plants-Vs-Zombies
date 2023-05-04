
import greenfoot.*;

/**
 * Write a description of class Timer2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
class DelayWave extends Actor
{
    public long deltaTime;
    public long lastFrame = System.nanoTime();
    public long currentFrame = System.nanoTime();
    public long delayTime;
    public Zombie[] wave;
    public int i;
    public WaveManager level;
    
    DelayWave(Zombie[] wave, int i, WaveManager level, long delayTime) {
        this.delayTime = delayTime;
        this.wave = wave;
        this.i = i;
        this.level = level;
    }
    public void act() {
        currentFrame = System.nanoTime();
        deltaTime = (currentFrame - lastFrame) / 1000000;
        if (deltaTime > delayTime) {
            
            if (wave[i]!=null) {
                        
                    level.MyWorld.addObject(wave[i], WaveManager.xOffset, (i%5)*level.ySpacing+level.yOffset);
                    level.zombieRow.get(i%5).add(wave[i]);
                    
            }       
            getWorld().removeObject(this);
            return;
        }
        
        
    }
}
