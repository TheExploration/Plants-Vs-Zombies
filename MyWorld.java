import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private boolean isPlaying = false;
    public boolean lose = false;
    Board board = new Board();
    public GreenfootSound Grasswalk = new GreenfootSound("Grasswalk.wav");
    public Zombie[][] level1 = {
                {null, null, new BasicZombie(), null, null, new BasicZombie(), null, new BasicZombie()},
                {new BasicZombie(), null, new BasicZombie(), new BasicZombie(), new BasicZombie()}, 
                {new BasicZombie(), new BasicZombie(), new BasicZombie()}, 
                {new BasicZombie(), new BasicZombie(), new BasicZombie(), new BasicZombie(), new BasicZombie()}
    };
    public WaveManager level = new WaveManager(50000L, level1, 10000L, true);
    public SeedPacket[] bank = {new SunflowerPacket(), new PeashooterPacket()};
    public SeedBank seedbank = new SeedBank(bank);   
    
     
    public void stopped() {
        
        Grasswalk.stop();
        
    }
    

    public boolean hasLost() {
        for (Zombie i : getObjects(Zombie.class)) {
            if (i.getX() < 200) {
                lose = true;
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
        super(820, 480, 1, false); 
        Greenfoot.setSpeed(50);
        setBackground("lawn2.5.png");
        addObject(seedbank,0,0);
        addObject(board,0,0);
        setPaintOrder(SunCounter.class, Sun.class, Dirt.class, Pea.class, Zombie.class, Plant.class, fallingZombie.class);
     
  
        
        
        
        
    }
    
    public void act() {
        if (!isPlaying) {
            addObject(level,0,0);
            Timer DelayAudio = new Timer();
            DelayAudio.schedule(new DelayAudio(Grasswalk, 70, true), 2000L); 
            level.startLevel();
            isPlaying = true;
            
            for (int k = 0; k < board.Board.length; k++) {
                board.placePlant(0,k, new Sunflower());
            }
            for (int k = 0; k < board.Board.length; k++) {
                board.placePlant(2,k, new Peashooter());
            }
            
            /*
            for (int k = 0; k < board.Board.length; k++) {
                board.placePlant(1,k, new Peashooter());
            }
            */
            
        }
        if (hasLost()) {
            AudioPlayer.play(80, "losemusic.wav");
        }
        
    }
    

}
