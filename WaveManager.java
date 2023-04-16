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
    public final int yOffset = 90;
    public final int ySpacing = 80;
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
    public boolean won = false;
    public World MyWorld;
    private int wave = -1;
    public boolean first = false;
    public boolean finishedSending = false;
    
    public WaveManager(long timeBetweenWaves, Zombie[][] level, long firstWave, boolean first) {
        this.level = level;
        this.levelTime = levelTime;
        this.waveTime = timeBetweenWaves;
        this.firstWave = firstWave;
        
        this.first = first;
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
    public void startLevel() {
        wave = 0;
        AudioPlayer.play(80, "readysetplant.mp3");
    }
    
    public void act()
    {
        if (wave != -1) {
            currentFrame = System.nanoTime();
            deltaTime = (currentFrame - lastFrame) / 1000000;
        }
        if (wave > level.length-1) {
                wave = -1;
        }
        
        if (deltaTime >= firstWave && wave != -1 && first == true) {
            AudioPlayer.play(80, "awooga.mp3");
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
    public boolean hasWon() {
        if (wave == -1 && finishedSending && MyWorld.getObjects(Zombie.class).size() == 0) {
            won = true;
        } else {
            won = false;
        }
        return won;
    }
    
    public void sendWave(Zombie[] wave) {
        
        for (int i = 0; i < wave.length; i++) {
            if (i < 5) {
                finishedSending = true;
                if (wave[i]!=null) {
                    //Send!
                    
                    MyWorld.addObject(wave[i], 840, (i%5)*ySpacing+yOffset);
                    zombieRow.get(i%5).add(wave[i]);
                }
            } else {
                
                //If more then 1 zombie per row, delay depending on how many
                if (wave[i] != null) {
                    finishedSending = false;
                    int wait = (int)(i/5);
                    long delayTime = (long)(wait*5000L);
                    Timer delay = new Timer();
                    delay.schedule(new DelayWave(wave, i, this), delayTime);
                }
            }
        }
    }
}
