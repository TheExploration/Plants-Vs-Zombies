import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SaveBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SaveBlock extends Button
{
    /**
     * Act - do whatever the SaveBlock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean clicked = false;
    GreenfootImage[] start;
    public int counter = 0;
    public SaveBlock() {
        super("saveblock1.png", "saveblock2.png");
        start = importSprites("saveblock", 2);
    }
    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        MainMenu world = (MainMenu)getWorld();
        
        if (mouse != null) {
            world.moveHitbox();
            if (this.intersects(world.hitbox)) {
                setImage(hover);
            } else {
                setImage(idle);
            }
            if (Greenfoot.mouseClicked(this)) {
                clicked = true;
                
                AudioPlayer.play(100, "tap.mp3", "tap2.mp3");
                
            }
        }
        
        
      
    }
    public void update() {
        
    }
}
