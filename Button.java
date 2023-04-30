import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends animatedObject
{
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public GreenfootImage idle;
    public GreenfootImage hover;
    public Button(String idle, String hover) {
        this.idle = new GreenfootImage(idle);
        this.hover = new GreenfootImage(hover);
        setImage(idle);
    }
    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        GameOver world = (GameOver)getWorld();
        if (mouse != null) {
            world.moveHitbox();
            if (this.intersects(world.hitbox)) {
                setImage(hover);
            } else {
                setImage(idle);
            }
            if (Greenfoot.mouseClicked(this)) {
                AudioPlayer.play(100, "gravebutton.mp3");
                update(); 
            }
        }
        
      
    }
    public void update() {
        
    }
}
