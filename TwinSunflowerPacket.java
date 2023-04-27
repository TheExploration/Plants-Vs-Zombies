import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SunflowerPacket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TwinSunflowerPacket extends SeedPacket
{
    /**
     * Act - do whatever the SunflowerPacket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public TwinSunflowerPacket() {
        super(16000L, true, 175, "twinsunflowerpacket");
    }
 
    public TransparentObject addImage() {
        TransparentObject temp = new TransparentTwinSunflower(false);
        ((MyWorld)getWorld()).addObject(temp, Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
        return temp;
    }
    public Plant getPlant() {
        return new TwinSunflower();
    }
}
