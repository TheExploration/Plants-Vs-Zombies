import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SeedPacket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SeedPacket extends Actor
{
    /**
     * Act - do whatever the SeedPacket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public long deltaTime;
    public long lastFrame = System.nanoTime();
    public long rechargeTime;
    public long currentFrame = System.nanoTime();
    public int sunCost;
    public boolean recharged = false;
    public boolean startRecharged = false;
    public String name;
    public boolean selected = false;
    public MyWorld MyWorld;
    public SeedPacket(long rechargeTime, boolean recharged, int sunCost, String name) {
        this.rechargeTime = rechargeTime;
        this.recharged = recharged;
        this.sunCost = sunCost;
        this.name = name;
        
    }
    
    public void addedToWorld(World world) {
        setRecharged(recharged);
        MyWorld = ((MyWorld)getWorld());
    }
    
    public void act() {
        currentFrame = System.nanoTime();
        deltaTime = (currentFrame - lastFrame) / 1000000;
        
        if (MyWorld.seedbank.suncounter.sun >= sunCost) {
            if (!recharged) {
                if (deltaTime > rechargeTime) {
                    setRecharged(true); 
                } else {
                    setRecharged(false);
                }
            }
             
    
        } else {
            setRecharged(false);        
        }
        
        // Add your action code here.
    }
    public void startRecharge() {
        lastFrame = currentFrame;
        
    }
    public void setRecharged(boolean charge) {
        recharged = charge;
        if (recharged) {
            setImage(name+"1.png");
        } else {
            setImage(name+"2.png");
        }

    }
    public void setSelected(boolean bool) {
        selected = bool;
         if (selected) {
            setImage(name+"2.png");
        } else {
            setImage(name+"1.png");
        }
    }
    
    public boolean getCharge() {
        return recharged;
    }
    public boolean getSelected() {
        return selected;
    }
    public TransparentObject addImage() {
        return null;
    }
    public Plant getPlant() {
        return null;
    }
}
