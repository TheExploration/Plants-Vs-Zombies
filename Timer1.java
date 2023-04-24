import java.util.Timer;
import java.util.TimerTask;
import greenfoot.*;

/**
 * Write a description of class Timer1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
class Timer1 extends TimerTask
{
    public GreenfootImage[] image;
    public String spriteSheet;
    public int frame;
    public int frame2;
    
    
    Timer1(GreenfootImage[] image, String filename, int frame, int frame2) {
        this.image = image;
        this.spriteSheet = filename;
        this.frame = frame;
        this.frame2 = frame2;
    }
    public void run() {
        GreenfootImage first = new GreenfootImage(spriteSheet+(frame+1)+".png");
        GreenfootImage second = new GreenfootImage(spriteSheet+(frame2+1)+".png");
        
        image[frame] = first;
        image[frame2] = second;
        
        
    }
}
