import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private boolean isPlaying = false;
    Board board = new Board();
    public GreenfootSound Grasswalk = new GreenfootSound("Grasswalk.wav");
    public Zombie[][] level1 = {
                {new BasicZombie(), null, new BasicZombie(), new BasicZombie(), new BasicZombie()}, 
                {new BasicZombie(), new BasicZombie(), new BasicZombie()}
    };
    public WaveManager level = new WaveManager(30000L, level1, 5000L);
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(840, 480, 1); 
        Greenfoot.setSpeed(50);
        setBackground("lawn2.5.png");
       
        addObject(board,0,0);
        
     
        
        
        
        
        
    }
    
    public void act() {
        if (!isPlaying) {
            Grasswalk.playLoop();
            
            isPlaying = true;
            
            for (int k = 0; k < board.Board[0].length; k++) {
                board.placePlant(0,k, new Sunflower());
            }
            for (int k = 0; k < board.Board[0].length; k++) {
                board.placePlant(1,k, new Peashooter());
            }
            
            
            
            addObject(level,0,0);
        }
        
        
    }
}
