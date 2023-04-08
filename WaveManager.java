import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*; //HAHAHADIE
/**
 * Write a description of class WaveManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaveManager extends Actor
{
    public long currentFrame = System.nanoTime();
    
    public ArrayList<ArrayList<Zombie>> zombieRow = new ArrayList<ArrayList<Zombie>>();
    public ArrayList<Zombie> row1 = new ArrayList<Zombie>();
    public ArrayList<Zombie> row2 = new ArrayList<Zombie>();
    public ArrayList<Zombie> row3 = new ArrayList<Zombie>();
    public ArrayList<Zombie> row4 = new ArrayList<Zombie>();
    public ArrayList<Zombie> row5 = new ArrayList<Zombie>();
    
    public long lastFrame = System.nanoTime();
    public Zombie[][] level;
    public long levelTime;
    public long waveTime;
    public long firstWave;
    public long deltaTime;
    public World MyWorld;
    private int wave = -1;
    public boolean first = false;
    public WaveManager(long timeBetweenWaves, Zombie[][] level, long firstWave) {
        this.level = level;
        this.levelTime = levelTime;
        this.waveTime = timeBetweenWaves;
        this.firstWave = firstWave;
        wave = 0;
        first = true;
        zombieRow.add(row1);
        zombieRow.add(row2);
        zombieRow.add(row3);
        zombieRow.add(row4);
        zombieRow.add(row5);

    }
    public WaveManager() {
        zombieRow.add(row1);
        zombieRow.add(row2);
        zombieRow.add(row3);
        zombieRow.add(row4);
        zombieRow.add(row5);
    }
    
    public void act()
    {
        currentFrame = System.nanoTime();
        deltaTime = (currentFrame - lastFrame) / 1000000;
        if (wave > level.length-1) {
                wave = -1;
        }
        
        if (deltaTime >= firstWave && wave != -1 && first == true) {
            
            sendWave(level[wave]);
            wave++;
            lastFrame = System.nanoTime();
            first =false;
        }
        if (first == false && wave != -1) {
            if ((deltaTime >= waveTime) || MyWorld.getObjects(Zombie.class).size() == 0) {
                
                sendWave(level[wave]);
                wave++;
                lastFrame = System.nanoTime();
                
            }
        }
    }
    
     @Override
    protected void addedToWorld(World world) {
        MyWorld = (MyWorld)getWorld();
        
    }
    
    public void sendWave(Zombie[] wave) {
        
        for (int i = 0; i < wave.length; i++) {
            
            if (wave[i%5]!=null) {
                MyWorld.addObject(wave[i%5], 1200, i%5*80+90);
                zombieRow.get(i%5).add(wave[i%5]);
            }
        }
    }
}
