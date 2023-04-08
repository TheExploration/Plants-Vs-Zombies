import java.util.Timer;
import java.util.TimerTask;
import greenfoot.*;

/**
 * Write a description of class Timer2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
class DelayAudio extends TimerTask
{
    public GreenfootSound music;
    public int volume;
    public boolean loop;    
    
    DelayAudio(GreenfootSound music, int volume, boolean loop) {
        this.music = music;
        this.volume = volume;
        this.loop = loop;
    }
    public void run() {
        music.setVolume(volume);
        if (loop) {
            music.playLoop();
        } else {
            music.play();    
        }
        
       
        
        
    }
}
