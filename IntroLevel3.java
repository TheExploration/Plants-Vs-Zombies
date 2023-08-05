import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class IntroLevel3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroLevel3 extends World
{
    public GreenfootSound CYS = new GreenfootSound("chooseyourseeds.mp3");
    public int count = 0;
    public int scrollSpeed = 4;
    public int location = 0;
    public boolean started = false;
    public Zombie n = null;
    public SeedPacket[] bank = {new SunflowerPacket(), new PeashooterPacket(), new WalnutPacket(), new PotatoPacket(), new RepeaterPacket(), new TwinSunflowerPacket()};
    
    public SeedBank seedbank = new SeedBank(bank); 
    public Zombie[][] level3 = {
                {null, n, null, new BasicZombie()},
                {n},
                {new BasicZombie(), new Buckethead(), new Buckethead(), new Buckethead(), null}, 
                {new BasicZombie(),n,new Buckethead(),new Buckethead(),n,new BasicZombie()},
                {n, new Conehead(), n, new Buckethead(),n,n,new BasicZombie(),n,n,n,new BasicZombie(),new BasicZombie()},
                {new BasicZombie(),n,n,n,new Conehead(), n,n,n,n,n,n,n,n,n,new BasicZombie()},
                {n},
                {new BasicZombie(), new Conehead(), new Brickhead(), new BasicZombie(), new Conehead(), new BasicZombie(), new BasicZombie(), new Buckethead()},
                {new BasicZombie(),n,n,new BasicZombie(),new BasicZombie()},
                {n,n,new Buckethead(), n,n,n,n,new Buckethead()},
                {new Conehead(), new Conehead(),new Buckethead(), new Conehead(),new Conehead()},
                {new BasicZombie(), new Conehead(), new BasicZombie(), new BasicZombie(), new BasicZombie()},
                {new Brickhead()},
                {new Conehead(), new Buckethead(), new Buckethead(), new Conehead(), new Buckethead()},
                {n},
                {new BasicZombie(), new BasicZombie(), new BasicZombie(), new BasicZombie(), new BasicZombie()},
                {n,n,n,new Brickhead(), new Brickhead()},
                {new Conehead(), new Buckethead(), new Conehead()},
                {n},
                {new Buckethead(), new Buckethead(), new Buckethead(), new Buckethead(), new Buckethead()},
                {new BasicZombie(), new BasicZombie(), new BasicZombie(), new BasicZombie(), new BasicZombie()},
                {n, new Conehead()},
                {n,n,n,n,new BasicZombie()},
                {n}, 
                {new BasicZombie(), new BasicZombie(),new BasicZombie(),new BasicZombie(),new BasicZombie()},
                {new Conehead(),new Conehead(),new Conehead(),new Conehead(),new Conehead(), new Buckethead(),new Buckethead(),new Buckethead(),new Buckethead(),new Buckethead(), new Brickhead(),new Brickhead(),new Brickhead(),new Brickhead(),new Brickhead()},
                {n},
                {n,n,new Buckethead(), n,n,n,n,new Buckethead(),n,n,n,n,new Buckethead(),n,n,n,n,new Buckethead(), n,n,n,n,new Buckethead(),n,n,n,n,new Buckethead()}
                
                
                
                
    };
  
    
    public WaveManager level = new WaveManager(23500L, level3, 15000L, true, 7, 13, 19, 24, 27);
    public IntroLevel3()
    {    
        
        super(733, 430, 1, false); 
        addObject(new Basic(), 800, 200);
         addObject(new Basic(), 920, 310);
        addObject(new IdleCone(), 800, 110);
        addObject(new IdleBucket(), 900, 100);
        addObject(new IdleCone(), 890, 370);
        
        addObject(new IdleBucket(), 822, 241);
        addObject(new IdleBrickhead(), 890, 210);
        addObject(new IdleBrickhead(), 850, 70);
        addObject(new IdleBrickhead(), 824, 317);
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
            
            
            List<IdleZombie> idleZombie = getObjects(IdleZombie.class );
            for ( IdleZombie zombie : idleZombie ) {
                
                removeObject(zombie);
            }
            
            
            
            Greenfoot.setWorld(new MyWorld(CYS,level, seedbank, new IntroLevel3(), new WinTwinsunflower()));
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
