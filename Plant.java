import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plant extends animatedObject
{
    public int maxHp;
    public boolean isAlive = true;
    public int hp;
    public int damage;
    public MyWorld MyWorld;
    public boolean remove = false;
    public Plant() {
        
    }
    /**
     * Act - do whatever the Plant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (isLiving()) {
            update();    
        } else if (!remove) {
            MyWorld = (MyWorld)getWorld();
            AudioPlayer.play(80,"gulp.wav");
            remove = true;
            MyWorld.board.removePlant(getXPos(), getYPos());
            MyWorld.removeObject(this);
            
            return;
        } 
        
        // Add your action code here.
    }
    public void update() {
        
    }
    public int getXPos() {
        return ((getX()-Board.xOffset)/Board.xSpacing);
    }   
    public int getYPos() {
        return ((getY()-Board.yOffset)/Board.ySpacing);
    }
    @Override
    public void addedToWorld(World world) {
        MyWorld MyWorld = (MyWorld)getWorld();
        MyWorld.addObject(new Dirt(), getX(), getY()+30);
    }
    public boolean isLiving() {
        if (hp <=0) {
            isAlive = false;
        } else {
            isAlive = true;
        }
        return isAlive;
    }
    public void hit(int dmg) {
        
    }
    
}
