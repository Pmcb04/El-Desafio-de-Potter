import java.io.*;
/**
 * Write a description of class AbstractWand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class AbstractWand implements Wand
{
    // instance variables - replace the example below with your own
    private String Name;
    private String Type;

    /**
     * Constructor for objects of class AbstractWand
     */
    public AbstractWand(String Name, String Type)
    {
        this.Name = Name;
        this.Type = Type;
    }
    
    /***
     * 
     */
    @Override
    public abstract float offensiveUse(float characterOffensivePoints, float characterEnergyPoints);
    
    /***
     * 
     */
    @Override
    public abstract float defensiveUse(float characterdefensivePoints, float characterEnergyPoints);
    
    /***
     * 
     */
    @Override
    public String getName(){
     return Name;   
    }
    
    /***
     * 
     */
    @Override
    public String getType(){
     return Type;
    }
}
