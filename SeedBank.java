import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class SeedBank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SeedBank extends Actor
{
    /**
     * Act - do whatever the SeedBank wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ArrayList<SeedPacket> seedbank = new ArrayList<SeedPacket>();
    MyWorld MyWorld;
    SunCounter suncounter = new SunCounter();
    
    public SeedBank() {
        seedbank.add(new PeashooterPacket());
        seedbank.add( new SunflowerPacket());
    }
    public void act()
    {
        // Add your action code here.
    }
    @Override
    public void addedToWorld(World world) {
        MyWorld = (MyWorld)getWorld();
        MyWorld.addObject(suncounter, 120, 50);
    }
    
}
