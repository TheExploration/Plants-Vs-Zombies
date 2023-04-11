import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Timer;
import java.io.*;
/**
 * Write a description of class animatedObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class animatedObject extends SmoothMover
{
    /**
     * Act - do whatever the animatedObject wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public long deltaTime;
    public long lastFrame = System.nanoTime();
    public long currentFrame = System.nanoTime();
    
    
    public int frame = 0;
    //In milliseconds (ms)
    
    public void act()
    {
        // Add your action code here.
    }
    
    public GreenfootImage[] importSprites(String filename, int frames) {
        GreenfootImage[] temp = new GreenfootImage[frames];
        for (int i = 0; i < frames; i++) {
            GreenfootImage scale = new GreenfootImage(filename+(i+1)+".png");
            scale.scale(scale.getWidth()*2, scale.getHeight()*2);
            temp[i] = scale;
        }
        return temp;
    }

    
    public GreenfootImage[] importSprites(String filename, int frames, double scaleFactor) {
        GreenfootImage[] temp = new GreenfootImage[frames];
        for (int i = 0; i < frames; i++) {
            GreenfootImage scale = new GreenfootImage(filename+(i+1)+".png");
            scale.scale((int)(scale.getWidth()*scaleFactor), (int)(scale.getHeight()*scaleFactor));
            temp[i] = scale;
        }
        return temp;
    }
    
    
    
    public void animate(GreenfootImage[] sprite, long duration) {
        currentFrame = System.nanoTime();
        deltaTime = (currentFrame - lastFrame) / 1000000;
        
        
        if (deltaTime > duration) {
            lastFrame = currentFrame;    
            frame++;
        }
        if (frame < sprite.length) {
            setImage(sprite[frame]);
        } else {
            frame = 0;
            setImage(sprite[frame]);
        }
        
           
    }
    
    public void animate(GreenfootImage[] sprite, long duration, boolean loop) {
        currentFrame = System.nanoTime();
        deltaTime = (currentFrame - lastFrame) / 1000000;
        
        if (deltaTime > duration) {
            lastFrame = currentFrame;    
            frame++;
        }
        if (frame < sprite.length) {
            setImage(sprite[frame]);
        } else if (loop) {
            frame = 0;
            setImage(sprite[frame]);
        } else {
            //do nothing
        }
               
        

        
    }
    public void setFrame(int toFrame) {
        frame = toFrame-1;
    }
    
    public int getCurrentFrame() {
        return frame+1;
    }
    public void hitFlash(GreenfootImage[] sprite, String filename) {
        int tempFrame = frame;
        int flashFrame = tempFrame+1;
        if (tempFrame >= sprite.length) {
            tempFrame = 0;
            flashFrame = 1;
          
        } else if (flashFrame >= sprite.length) {
            flashFrame = 0;
        }
      
        
        
        GreenfootImage first = new GreenfootImage("flash"+filename+(tempFrame+1)+".png");
        GreenfootImage second = new GreenfootImage("flash"+filename+(flashFrame+1)+".png");
        first.scale(first.getWidth()*2, first.getHeight()*2);
        second.scale(second.getWidth()*2, second.getHeight()*2);
        sprite[tempFrame] = first;
        sprite[flashFrame] = second;
        
        
        setImage(sprite[tempFrame]);
        
        Timer timer = new Timer();
        timer.schedule(new Timer1(sprite, filename, tempFrame,flashFrame), 500L); 
       
    }
   
    

}
