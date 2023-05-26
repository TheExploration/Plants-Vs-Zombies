import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PotatoPacket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PotatoPacket extends SeedPacket
{
    /**
     * Act - do whatever the PotatoPacket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public PotatoPacket() {
        super(40000L, false, 25, "potatopacket");
    }
 
    public TransparentObject addImage() {
        TransparentObject temp = new TransparentPotato(false);
        ((MyWorld)getWorld()).addObject(temp, Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
        return temp;
    }
    public Plant getPlant() {
        return new PotatoMine();
    }
}
