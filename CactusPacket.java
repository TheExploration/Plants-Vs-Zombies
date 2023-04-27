import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CactusPacket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CactusPacket extends SeedPacket
{
    public CactusPacket() {
        super(20000L, false, 125, "cactuspacket");
        
    }
    
    public TransparentObject addImage() {
        TransparentObject temp = new TransparentCactus(false);
        ((MyWorld)getWorld()).addObject(temp, Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
        return temp;
    }
    public Plant getPlant() {
        return new Cactus();
    }
}
