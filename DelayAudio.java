
import greenfoot.*;

/**
 * Write a description of class Timer2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
class DelayAudio extends Actor
{
    public GreenfootSound music;
    public GreenfootSound stop;
    public int volume;
    public boolean loop;    
    public long deltaTime;
    public long lastFrame = System.nanoTime();
    public long currentFrame = System.nanoTime();
    public long delayTime;
    
    DelayAudio(GreenfootSound music, int volume, boolean loop, long delayTime) {
        this.delayTime = delayTime;
        this.music = music;
        this.volume = volume;
        this.loop = loop;
    }
    DelayAudio(GreenfootSound music, GreenfootSound stop, int volume, boolean loop, long delayTime) {
        this.stop = stop;
        this.delayTime = delayTime;
        this.music = music;
        this.volume = volume;
        this.loop = loop;
    }
    public void act() {
        currentFrame = System.nanoTime();
        deltaTime = (currentFrame - lastFrame) / 1000000;
        if (deltaTime > delayTime) {
            if (stop != null) {
                stop.stop();
            }
            music.setVolume(volume);
            if (loop) {
                music.playLoop();
            } else {
                music.play();    
            }
            getWorld().removeObject(this);
            return;
        }       
        
        
    }
}
