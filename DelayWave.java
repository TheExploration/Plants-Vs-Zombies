import java.util.Timer;
import java.util.TimerTask;
import greenfoot.*;

/**
 * Write a description of class Timer2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
class DelayWave extends TimerTask
{
    public Zombie[] wave;
    public int i;
    public WaveManager level;
    
    DelayWave(Zombie[] wave, int i, WaveManager level) {
        this.wave = wave;
        this.i = i;
        this.level = level;
    }
    public void run() {
        level.finishedSending = true;
        if (wave[i]!=null) {
                    
                level.MyWorld.addObject(wave[i], WaveManager.xOffset, (i%5)*level.ySpacing+level.yOffset);
                level.zombieRow.get(i%5).add(wave[i]);
        }       
        
        
    }
}
