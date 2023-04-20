/**
 * Write a description of class Random here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Random  
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Random
     */
    public Random()
    {
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static int Int(int min, int max) {
        return (int)((Math.random() * (max - min)) + min);
    }
    public static double Double(int min, int max) {
        return (((Math.random() * (max - min)) + min)/100);
    }
}
