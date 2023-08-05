import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{
    Hitbox hitbox = new Hitbox();
    GreenfootSound menutheme = new GreenfootSound("menutheme.mp3");
    public MainMenu(GreenfootSound menutheme)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(576, 430, 1, false); 
        addObject(hitbox,0,0);
        addObject(new Start(), 412, 132);
        addObject(new More(), 398, 224);
        addObject(new Bush(), 459, 394);
        addObject(new Achievements(), 155, 380);
        addObject(new SaveBlock(), 150, 175);
        this.menutheme = menutheme;
        Greenfoot.setSpeed(50);
    }
    public void act() {
        if (Greenfoot.isKeyDown("1")) {
            menutheme.stop();
            Greenfoot.setWorld(new Intro());
                    
                
        } else if (Greenfoot.isKeyDown("2")) {
           menutheme.stop();
                
            Greenfoot.setWorld(new IntroLevel1());
                    
        } else if (Greenfoot.isKeyDown("3")) {
            menutheme.stop();
                
            Greenfoot.setWorld(new IntroLevel2());
                    
        } else if (Greenfoot.isKeyDown("4")) {
            menutheme.stop();
                
            Greenfoot.setWorld(new IntroLevel3());
                    
        }
    }
    public void started() {
        if (!menutheme.isPlaying()) {
            menutheme.setVolume(70);
            menutheme.playLoop();
        }
    
    }
    public void stopped() {
        menutheme.pause();
    }

    public void moveHitbox() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            hitbox.setLocation(mouse.getX(), mouse.getY());
        }
    }
    
}
