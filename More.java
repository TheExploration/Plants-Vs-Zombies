import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class More here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class More extends Button
{
    /**
     * Act - do whatever the More wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean clicked = false;
    GreenfootImage[] start;
    public int counter = 0;
    public More() {
        super("more1.png", "more2.png");
        start = importSprites("more", 2);
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
                
                AudioPlayer.play(100, "gravebutton.mp3");
                
            }
        }
        
        
      
    }
    public void update() {
        
    }
}
