import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends Button
{
    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean clicked = false;
    GreenfootImage[] start;
    public int counter = 0;
    public Start() {
        super("start1.png", "start2.png");
        start = importSprites("start", 2);
    }
    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        MainMenu world = (MainMenu)getWorld();
        if (clicked) {
            animate(start, 80, true);
            counter++;
            if (counter == 200) {
                
                update();
            }
        } else {
            if (mouse != null) {
                world.moveHitbox();
                if (this.intersects(world.hitbox)) {
                    setImage(hover);
                } else {
                    setImage(idle);
                }
                if (Greenfoot.mouseClicked(this)) {
                    clicked = true;
                    world.menutheme.stop();
                    AudioPlayer.play(100, "gravebutton.mp3");
                    AudioPlayer.play(70, "losemusic.mp3");
                    getWorld().addObject(new DelayAudio(new GreenfootSound("evillaugh.mp3"), 70, false, 1000L), 0,0);
                    
                }
            }
        }
        
      
    }
    public void update() {
        getWorld().addObject(new Transition(false, new Intro(), 4), 365, 215);
    }
}
