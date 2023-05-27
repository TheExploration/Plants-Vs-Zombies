import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Intro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Intro extends World
{
    public GreenfootSound CYS = new GreenfootSound("chooseyourseeds.mp3");
    public int count = 0;
    public int scrollSpeed = 4;
    public int location = 0;
    public boolean started = false;
    public Zombie n = null;
    public SeedPacket[] bank = {new SunflowerPacket(), new PeashooterPacket(), new WalnutPacket()};
    
    public SeedBank seedbank = new SeedBank(bank);   
    
    public Zombie[][] level1 = {
                {new BasicZombie(), n , null, null},
                {n},
                {n, null, null, null, new BasicZombie()}, 
                {n},
                {null, new BasicZombie(), null, new BasicZombie()},
                {new BasicZombie(),n,n,n,n,n,new BasicZombie()},
                {null, null, new BasicZombie(), new BasicZombie(), new BasicZombie()},
                {n},
                {new BasicZombie(), new Conehead(), new BasicZombie(), new BasicZombie(), new BasicZombie(), n,new BasicZombie()}
    };
    
    public WaveManager level = new WaveManager(23500L, level1, 15000L, true, 8);
    public Intro()
    {    
        
        super(733, 430, 1, false); 
        addObject(new Basic(), 800, 200);
        addObject(new Basic(), 900, 100);
        addObject(new Basic(), 890, 370);
        addObject(new Basic(), 822, 241);
        addObject(new IdleCone(), 890, 210);
    
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
        else if (count == 450) {
            List<IdleZombie> idleZombie = getObjects(IdleZombie.class );
            for ( IdleZombie zombie : idleZombie ) {
                
                removeObject(zombie);
            }
        }
        else if ( count == 500 )
        {
           
            Greenfoot.setWorld(new MyWorld(CYS, level, seedbank, new Intro(), new WinPotato()));
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
            } 
            
        } 
        
    }
}
