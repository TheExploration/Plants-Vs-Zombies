import java.util.Timer;
import java.util.TimerTask;
import greenfoot.*;

/**
 * Write a description of class Timer2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
class FixOrder extends TimerTask
{
    
    public WaveManager level;
    
    public FixOrder(WaveManager level) {
        
        this.level = level;
    }
    public void run() {
        
            level.fixOrder();
       
    }
}
