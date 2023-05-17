import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class MyWorld extends World
{   
    
    private boolean isPlaying = false;
    public boolean lose = false;
    public boolean loseOnce = false;
    public boolean winOnce = false;
    Board board = new Board();
    public GreenfootSound Grasswalk = new GreenfootSound("Grasswalk.mp3");
    public GreenfootSound CYS;
    public Zombie n = null;
    
    
    public Zombie[][] level1 = {
                {null, new BasicZombie(), null, null},
                {n},
                {new BasicZombie(), null, null, null, null}, 
                {n},
                {null, new BasicZombie(), null, new BasicZombie()},
                {new BasicZombie()},
                {null, null, new Conehead(), null, null},
                {n},
                {new BasicZombie(), null, new BasicZombie(), new BasicZombie(), new BasicZombie() , new BasicZombie()}, 
                {null, new Conehead()},
                {n,n,n, new BasicZombie()},
                {new Buckethead(), null, null, null, null},
                {n,n,n,n,new Conehead()},
                {n, new BasicZombie()},
                {null, new BasicZombie(), null, null, new Conehead()},
                {n,n,new BasicZombie()},
                {new BasicZombie(), new BasicZombie(), new BasicZombie(),  null, new Conehead()}, 
                {n,n,n,new Conehead()},
                {null, null, new BasicZombie(), null, null},
                {n},
                {new Conehead(), new Conehead(), new Conehead(), new BasicZombie(), new BasicZombie(), new Buckethead(), null, new BasicZombie(), new Conehead(), new Buckethead()}
    };
    public Zombie[][] level2 = {
                {null, new BasicZombie(), null, null},
                {null, new BasicZombie(), null, null}
    };
   
    
    public SeedPacket[] bank = {new SunflowerPacket(), new PeashooterPacket(), new WalnutPacket(), new CactusPacket(), new TwinSunflowerPacket()};
    public SeedBank seedbank = new SeedBank(bank);   
    public Hitbox hitbox = new Hitbox();
    public Shovel shovel = new Shovel();
    
    
    public WaveManager level = new WaveManager(23500L, level1, 20000L, true, 8, 20);
    
    
    
    
    
    public void stopped() {
        if (Grasswalk.isPlaying()) {
            Grasswalk.pause();
        }
        
    }
    public void started() {
        if (!Grasswalk.isPlaying()) {
            Grasswalk.playLoop();
        }
        Greenfoot.setSpeed(50);        
        
    }
    public void moveHitbox() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            hitbox.setLocation(mouse.getX(), mouse.getY());
        }
    }
    public void finishLevel() {
        Grasswalk.stop();
        AudioPlayer.play(70, "winmusic.mp3");
        
        
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
        setPaintOrder(Transition.class, AHugeWave.class,ReadySetPlant.class, SunCounter.class, clickShovel.class, Shovel.class, TransparentObject.class, SeedPacket.class, FallingSun.class, Sun.class, Dirt.class, Projectile.class, FallingObject.class, Zombie.class, fallingZombie.class, Plant.class);
     
          
        
        
        
        
    }
    public MyWorld(GreenfootSound CYS)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(733, 430, 1, false); 
        this.CYS = CYS;
        Greenfoot.setSpeed(50);
        setBackground("lawn2.png");
        addObject(seedbank,0,0);
        addObject(board,0,0);
        addObject(hitbox, 0,0);
        addObject(shovel, 690,420);
        setPaintOrder(Transition.class,AHugeWave.class, ReadySetPlant.class, SunCounter.class, clickShovel.class, Shovel.class, TransparentObject.class, SeedPacket.class, FallingSun.class, Sun.class, Dirt.class, Projectile.class, FallingObject.class, Zombie.class, fallingZombie.class, Plant.class);
     
          
        
        
        
        
    }
    
    public void act() {
        if (!isPlaying) {
            addObject(level,0,0);
            addObject(new DelayAudio(Grasswalk,CYS, 70, true, 2000L), 0,0);
            
            level.startLevel();
            isPlaying = true;           
            
        }
        if (!loseOnce && hasLost()) {
            Grasswalk.stop();
            AudioPlayer.play(80, "losemusic.mp3");
            
            GreenfootSound scream = new GreenfootSound("scream.mp3");
            
            addObject(new DelayAudio(scream, 70, false, 4000L), 0,0);
            loseOnce = true;
            Greenfoot.delay(250);
            addObject(new Transition(false, new GameOver(), "gameover.png", 5), 365, 215);
        }
        if (!winOnce && hasWon()) {
            winOnce = true;
            addObject(new WinRepeater(), Random.Int(SeedBank.x1, SeedBank.x2), 215);
        }
        
    }
    /*
    DOESNT WORK
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

}
