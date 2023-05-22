import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class IntroLevel1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroLevel1 extends World
{
    public GreenfootSound CYS = new GreenfootSound("chooseyourseeds.mp3");
    public int count = 0;
    public int scrollSpeed = 4;
    public int location = 0;
    public boolean started = false;
    public Zombie n = null;
    public SeedPacket[] bank = {new SunflowerPacket(), new PeashooterPacket(), new WalnutPacket(), new CactusPacket()};
    
    public SeedBank seedbank = new SeedBank(bank);   
    
    public Zombie[][] level1 = {
                {null, new BasicZombie(), null, null},
                {n},
                {new BasicZombie(), null, null, null, null}, 
                {n},
                {null, new BasicZombie(), null, new BasicZombie()},
                {new BasicZombie()},
                {null, null, new Conehead(), null, null},
                {n},
                {new BasicZombie(), new Conehead(), new BasicZombie(), new BasicZombie(), new BasicZombie(), n,new BasicZombie()}, 
                {n},
                {new Conehead(), n, null, new BasicZombie(), null, null, new BasicZombie()},
                {new BasicZombie(),n,n, new BasicZombie(), null, new BasicZombie(), new BasicZombie()},
                {null, null, null, new Buckethead(), null},
                {n,new BasicZombie(),n,n,new Conehead(), n, n, new BasicZombie()},
                {null, new BasicZombie(), null, null, new Conehead(),n,n,new BasicZombie()},
                {new BasicZombie(), new BasicZombie(), new BasicZombie(),  null, new Conehead()}, 
                {null, null, new BasicZombie(), null, null},
                {n},
                {new Conehead(), new Conehead(), new Conehead(), new BasicZombie(), new BasicZombie(), new Buckethead(), null, new BasicZombie(), new Conehead(), new Buckethead()}
    };
    
    public WaveManager level = new WaveManager(23500L, level1, 20000L, true, 8, 18);
    public IntroLevel1()
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
        else if (count == 450) {
            List<IdleZombie> idleZombie = getObjects(IdleZombie.class );
            for ( IdleZombie zombie : idleZombie ) {
                
                removeObject(zombie);
            }
        }
        else if ( count == 500 )
        {
           
            Greenfoot.setWorld(new MyWorld(CYS, level, seedbank));
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
