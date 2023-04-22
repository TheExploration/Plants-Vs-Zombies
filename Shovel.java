import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shovel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shovel extends SmoothMover
{
    /**
     * Act - do whatever the Shovel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean selected = false;
    
    public void addedToWorld(World world) {
        setImage("shovel1.png");
        selected = false;
    }
    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            if (Greenfoot.mouseClicked(null)) {
                MyWorld MyWorld = (MyWorld)getWorld();
                MyWorld.moveHitbox();
                if (intersects(MyWorld.hitbox)) {
                    if (!selected) {
                        selected = true;
                        setImage("shovel2.png");
                        AudioPlayer.play(80, "shovel.mp3");
                        MyWorld.addObject(new clickShovel(), mouse.getX(), mouse.getY());
                    }
                }
            }
        }
        // Add your action code here.
    }
    public void setSelected(boolean bool) {
        if (!bool) {
            selected = bool;
            setImage("shovel1.png");
        } 
    }
    
}
