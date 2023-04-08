import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board extends Actor
{
    
     // instance variables - replace the example below with your own
    public Plant[][] Board = new Plant[5][9]; 
    public static final int xOffset = 237;
    public static final int yOffset = 110;
    public static final int xSpacing = 64;
    public static final int ySpacing = 80;
    
    
    /**
     * Constructor for objects of class Board
     */
    public Board()
    {
        
    }
    public void placePlant(int x, int y, Plant plant) {
        if (Board[y][x] == null) {
            Board[y][x] = plant;    
            World MyWorld = getWorld();
            
            MyWorld.addObject(plant, x*xSpacing+xOffset, y*ySpacing+yOffset);
            AudioPlayer.play(80, "plant.wav", "plant2.wav");
        }
        
    }
    public void removePlant(int x, int y) {
        Board[y][x] = null;
    }
    
    public void updateBoard() {
        for (int i = 0; i < Board.length; i++) {
            for (int k = 0; k < Board[0].length; k++) {
                if (Board[i][k] != null) {
                    World MyWorld = getWorld();
                    Plant temp = Board[i][k];
                    MyWorld.addObject(temp, i*xSpacing+xOffset, k*ySpacing+yOffset);
                }
            }
        }
        
    }
    
    /**
     * Act - do whatever the Board wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }
}
