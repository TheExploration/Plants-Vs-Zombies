import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author Exploration
 * @version 0.1
 */

public class MyWorld extends World
{   
    
    private boolean isPlaying = false;
    public boolean lose = false;
    public boolean loseOnce = false;
    Board board = new Board();
    public GreenfootSound Grasswalk = new GreenfootSound("Grasswalk.mp3");
    public Zombie[][] level1 = {
                {null, null, new BasicZombie(), null, null},
                {new BasicZombie(), null, new BasicZombie(), new BasicZombie(), new BasicZombie()}, 
                {new BasicZombie(), new BasicZombie(), new BasicZombie(),  new BasicZombie(), new BasicZombie()}, 
                {new BasicZombie(), new BasicZombie(), new BasicZombie(), new BasicZombie(), new BasicZombie(), new BasicZombie(), new BasicZombie(), new BasicZombie()}
    };
    public WaveManager level = new WaveManager(45000L, level1, 10000L, true);
    public SeedPacket[] bank = {new SunflowerPacket(), new PeashooterPacket()};
    public SeedBank seedbank = new SeedBank(bank);   
    public Hitbox hitbox = new Hitbox();
     
    public void stopped() {
        
        Grasswalk.stop();
        
    }
    public void started() {
        
        Greenfoot.setWorld(new MyWorld());
        
    }
    public void moveHitbox() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            hitbox.setLocation(mouse.getX(), mouse.getY());
        }
    }

    public boolean hasLost() {
        for (Zombie i : getObjects(Zombie.class)) {
        
            
            if (i.getX() < 125) {
                lose = true;
                return lose;
            } else {
                lose = false;
            }
            
        }
        return lose;
    }
    public boolean hasWon() {
        return level.hasWon();
    }
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(733, 430, 1, false); 
        Greenfoot.setSpeed(50);
        setBackground("lawn2.png");
        addObject(seedbank,0,0);
        addObject(board,0,0);
        addObject(hitbox, 0,0);
        setPaintOrder(SunCounter.class, TransparentObject.class, Sun.class, Dirt.class, Pea.class, FallingObject.class, Zombie.class, Plant.class, fallingZombie.class);
     
          
        
        
        
        
    }
    
    public void act() {
        if (!isPlaying) {
            addObject(level,0,0);
            Timer DelayAudio = new Timer();
            DelayAudio.schedule(new DelayAudio(Grasswalk, 70, true), 2000L); 
            level.startLevel();
            isPlaying = true;
            
           
            
            
        }
        if (!loseOnce && hasLost()) {
            Grasswalk.stop();
            AudioPlayer.play(80, "losemusic.mp3");
            Timer DelayAudio = new Timer();
            GreenfootSound scream = new GreenfootSound("scream.mp3");
            DelayAudio.schedule(new DelayAudio(scream, 70, false), 3000L);
            loseOnce = true;
            Greenfoot.delay(1000);
        }
        
    }
    

}
