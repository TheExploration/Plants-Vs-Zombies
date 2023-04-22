import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class clickShovel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class clickShovel extends SmoothMover
{
    /**
     * Act - do whatever the clickShovel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    MyWorld MyWorld;
    Plant lastPlant = null;
    
    public void addedToWorld(World world) {
        MyWorld = (MyWorld)getWorld();
    }
    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            setLocation(mouse.getX(), mouse.getY());
            MyWorld.moveHitbox();
            
            
            if (touchingPlant() != null) {
                if (lastPlant != null && lastPlant != touchingPlant()) {
                    lastPlant.opaque = false;
                    lastPlant = touchingPlant();
                } else {
                    lastPlant = touchingPlant();
                    lastPlant.opaque = true;
                }
                
            } else {
                if (lastPlant != null) {
                    lastPlant.opaque = false;
                }
            }
            
            
            
            if (Greenfoot.mouseClicked(null)) {
                
                if (touchingPlant() != null) {
                    Plant target = touchingPlant();
                    MyWorld.board.removePlant(target.getXPos(), target.getYPos());
                    
                } else {
                    AudioPlayer.play(80, "tap.mp3", "tap2.mp3");
                    
                }
                MyWorld.shovel.setSelected(false);
                MyWorld.removeObject(this);
                return;
            }
        }
        // Add your action code here.
    }
    public Plant touchingPlant() {
        for (Object i : MyWorld.hitbox.getTouching()) {
            if (i instanceof Plant) {
                return (Plant)i;
                    
            }
        }
        return null;
    }
}
