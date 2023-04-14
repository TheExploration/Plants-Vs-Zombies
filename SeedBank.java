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
   
    public MyWorld MyWorld;
    public SunCounter suncounter = new SunCounter();
    public SeedPacket[] bank;
    public SeedPacket selectedPacket = null;

    
    public SeedBank(SeedPacket[] bank) {
        
        this.bank = bank;
    }
    public void act() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        for (SeedPacket i : bank) {
            if (Greenfoot.mouseClicked(i)) {
                SeedPacket clicked = (SeedPacket)mouse.getActor();
                
                if (selectedPacket != clicked) {
                    if (clicked.selected == false) {
                        selectedPacket = clicked;
                        AudioPlayer.play(80, "seedlift.wav");
                        clicked.setSelected(false);
                    } else {
                        
                    }
                } else {
                    if (clicked.recharged == false) {
                        selectedPacket = null;
                        AudioPlayer.play(80, "seedlift.wav");
                        clicked.setRecharged(true);
                    }
                }
            
            }
            // Add your action code here.
        }
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
