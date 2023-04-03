import greenfoot.GreenfootSound;

/**
 * Write a description of class AudioPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AudioPlayer  
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class AudioPlayer
     */
    public AudioPlayer()
    {
        
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void play(String... audio)
    {
        int index = (int)(Math.random()*audio.length);
        GreenfootSound temp = new GreenfootSound(audio[index]);
        temp.play();
    }
    public static void play(int volume,String... audio)
    {
        int index = (int)(Math.random()*audio.length);
        GreenfootSound temp = new GreenfootSound(audio[index]);
        temp.setVolume(volume);
        temp.play();
    }
    public static void play(boolean loop, String... audio)
    {
        int index = (int)(Math.random()*audio.length);
        GreenfootSound temp = new GreenfootSound(audio[index]);
        if (loop) {
            temp.playLoop();
        } else {
            temp.play();
        }
    }
    public static void stop(GreenfootSound... audio) {
        for (int i = 0; i < audio.length; i++) {
            audio[i].stop();
        }
    }
}
