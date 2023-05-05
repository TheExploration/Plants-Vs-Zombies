import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class IntroLevel2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroLevel2 extends World
{
    public GreenfootSound CYS = new GreenfootSound("chooseyourseeds.mp3");
    public int count = 0;
    public int scrollSpeed = 4;
    public int location = 0;
    public boolean started = false;
    
    public IntroLevel2()
    {    
        
        super(733, 430, 1, false); 
        addObject(new Basic(), 800, 200);
        addObject(new Basic(), 900, 100);
        addObject(new Basic(), 890, 370);
        addObject(new Basic(), 822, 241);
        addObject(new IdleCone(), 890, 210);
        addObject(new IdleCone(), 850, 70);
        addObject(new IdleBucket(), 824, 317);
        CYS.setVolume(70);
        
    }
    public void act() {
        if (!started) {
            started = true;
            CYS.playLoop();
        }
        count++;
        bgScrollAnimate();
        
    }
    public void bgScrollAnimate()
    {
        if (count == 100 )
        {
            //removeObject(message);
        }
        if ( count > 100 && count < 160)
        {
            location -= scrollSpeed;
            
            scrollBGimage(location);
        }
        else if (count > 350 && count < 410)
        {
            location += scrollSpeed;
            
            scrollBGimage(location);
        }
        else if ( count == 500 )
        {
            
            
            List<IdleZombie> idleZombie = getObjects(IdleZombie.class );
            for ( IdleZombie zombie : idleZombie ) {
                
                removeObject(zombie);
            }
            
            
           
            Greenfoot.setWorld(new MyWorld(CYS));
        }
       
    }
    
    public void scrollBGimage(int offset)
    {
        GreenfootImage bg = getBackground(); 
        GreenfootImage move = new GreenfootImage("lawn2.png");
        bg.drawImage(move, offset, 0);  
        
        // get all objects and move them by the offset delta value
        List<Actor> currentObjects = getObjects(null);
        
        for ( Actor thisObject : currentObjects )
        {
            if ( count > 100 && count < 160)
            {
                thisObject.setLocation(thisObject.getX() - scrollSpeed , thisObject.getY() );
            }
            else if ( count > 350 && count < 410)
            {
                thisObject.setLocation(thisObject.getX() + scrollSpeed , thisObject.getY() );
            } // end inner if/else
            
        } // end for-each loop
        
    }
}
