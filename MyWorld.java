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
                {null, null, null, new BasicZombie(), null},
                {new BasicZombie(), null, null, null, null}, 
                {null, new BasicZombie(), null, new BasicZombie()},
                {null, null, new Conehead(), null, null},
                {new BasicZombie(), null, new BasicZombie(), new BasicZombie(), null}, 
                {new Conehead(), null, null, null, null},
                {null, new BasicZombie(), null, null, new Conehead()},
                {new BasicZombie(), new BasicZombie(), new BasicZombie(),  null, new Conehead()}, 
                {null, null, new BasicZombie(), null, null},
                {new Conehead(), new Conehead(), new Conehead(), new BasicZombie(), new BasicZombie(),new Conehead(), new BasicZombie(), new Conehead()}
    };
    /*
    FIX ORDER
    public Zombie[][] fixOrder(String[][] level) {
        int longest = 0;
        
        
        for (int i = 0; i < level.length; i++) {
            if (level[i].length > longest) {
                longest = level[i].length;
                
            }
        }
        Zombie[][] waves = new Zombie[level.length][longest];
        for (int r = 0; r < longest; r++) {
            for (int c = 0; c < level.length; c++) {
                if (r < level[c].length) {
                    if (level[c][r] != null) {
                        if (level[c][r].equals("Basic")) {
                            waves[c][r] = new BasicZombie();
                        } else if (level[c][r].equals("Conehead")) {
                            waves[c][r] = new Conehead();
                        }
                    }
                }
            }
        }
        return waves;
        
    }
    */
    public SeedPacket[] bank = {new SunflowerPacket(), new PeashooterPacket(), new WalnutPacket(), new CactusPacket(), new TwinSunflowerPacket()};
    public SeedBank seedbank = new SeedBank(bank);   
    public Hitbox hitbox = new Hitbox();
    public Shovel shovel = new Shovel();
    
    
    public WaveManager level = new WaveManager(47000L, level1, 10000L, true);
    
    
    
    
    
    public void stopped() {
        
        Grasswalk.stop();
        
    }
    public void started() {
        
        Greenfoot.setSpeed(50);        
        
    }
    public void moveHitbox() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            hitbox.setLocation(mouse.getX(), mouse.getY());
        }
    }

    public boolean hasLost() {
        for (Zombie i : getObjects(Zombie.class)) {
        
            
            if (i.getWorld() != null && i.getX() < 125) {
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
        addObject(shovel, 690,420);
         setPaintOrder(Transition.class, SunCounter.class, clickShovel.class, Shovel.class, TransparentObject.class, SeedPacket.class, FallingSun.class, Sun.class, Dirt.class, Projectile.class, FallingObject.class, Zombie.class, fallingZombie.class, Plant.class);
     
          
        
        
        
        
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
            DelayAudio.schedule(new DelayAudio(scream, 70, false), 4000L);
            loseOnce = true;
            Greenfoot.delay(250);
            addObject(new Transition(false, new GameOver(), "gameover.png", 5), 365, 215);
        }
        
    }
    

}
