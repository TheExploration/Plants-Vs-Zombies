import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AHugeWave here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AHugeWave extends Actor
{
    /**
     * Act - do whatever the AHugeWave wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int counter = 0;
    public boolean finalWave = false;
    public AHugeWave(boolean finalWave) {
        this.finalWave = finalWave;

    
    }
    
    public void act()
    {
        counter++;
        if (!finalWave) {
            if (counter > 300) {
                AudioPlayer.play(70, "siren.mp3");
                getWorld().removeObject(this);
                return;
            } 
        } else {
            if (counter == 300) {
                AudioPlayer.play(70, "siren.mp3");
                setImage("finalwave.png");
                AudioPlayer.play(70, "finalwave.mp3");
            } 
            if (counter > 450) {
                getWorld().removeObject(this);
                return;
            }
        }
            
    }
}
