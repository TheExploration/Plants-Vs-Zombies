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
    public MyWorld MyWorld;
    public SunCounter suncounter = new SunCounter();
    public SeedPacket[] bank;
    public SeedPacket selectedPacket = null;
    
    public SeedBank(SeedPacket[] bank) {
        seedbank.add(new PeashooterPacket());
        seedbank.add( new SunflowerPacket());
        this.bank = bank;
    }
    public void act() {
        if (Greenfoot.mouseClicked(SeedPacket.class)) {
            
        }
        // Add your action code here.
    }
    @Override
    public void addedToWorld(World world) {
        MyWorld = (MyWorld)getWorld();
        MyWorld.addObject(suncounter, 120, 50);
        for (int i = 0; i < bank.length; i++) {
            MyWorld.addObject(bank[i], 120, 120+i*50);
        }
    }
    
}
