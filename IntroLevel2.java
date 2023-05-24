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
    public Zombie n = null;
    public SeedPacket[] bank = {new SunflowerPacket(), new PeashooterPacket(), new WalnutPacket(), new CactusPacket(), new RepeaterPacket()};
    
    public SeedBank seedbank = new SeedBank(bank); 
    public Zombie[][] level2 = {
                {null, n, null, new BasicZombie()},
                {n},
                {new BasicZombie(), null, null, null, null}, 
                {n,n,new BasicZombie()},
                {null, new BasicZombie(), new BasicZombie(), new BasicZombie()},
                {new Conehead()},
                {null, null, new Conehead(), null, null, n, new BasicZombie()},
                {n},
                {new BasicZombie(), new Buckethead(), new BasicZombie(), new Conehead(), new BasicZombie(), n,new BasicZombie()}, 
                {n},
                {new Conehead(), n, null, new BasicZombie(), null, null, new BasicZombie()},
                {n,n,n, new Conehead(), null, new Buckethead(), new BasicZombie()},
                {n, new Brickhead(), null, null, null},
                {n,new BasicZombie(),new BasicZombie(), new BasicZombie(),new Conehead(), new BasicZombie(), n, new BasicZombie(), new BasicZombie()},
                {null, new BasicZombie(), new Buckethead(), null, new Conehead(),n,n,new BasicZombie()},
                {new BasicZombie(), new BasicZombie(), new BasicZombie(),  new Brickhead(), new Conehead()}, 
                {null, null, new Conehead(), null, null},
                {n},
                {new Brickhead(), new Conehead(), new Conehead(), new BasicZombie(), new BasicZombie(), new Buckethead(), null, new BasicZombie(), new Conehead(), new Brickhead()}
    };
  
    
    public WaveManager level = new WaveManager(23500L, level2, 15000L, true, 8, 18);
    public IntroLevel2()
    {    
        
        super(733, 430, 1, false); 
        addObject(new Basic(), 800, 200);
        addObject(new IdleCone(), 900, 100);
        addObject(new IdleCone(), 890, 370);
        addObject(new Basic(), 822, 241);
        addObject(new IdleBucket(), 890, 210);
        addObject(new IdleBucket(), 850, 70);
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
            
            
            
            Greenfoot.setWorld(new MyWorld(CYS,level, seedbank, new IntroLevel2()));
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
