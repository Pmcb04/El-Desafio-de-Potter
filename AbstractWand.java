import java.io.*;
/**
 * Class AbstractWand
 * Strategy Pattern
 *
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 26/11/2019
 */
public abstract class AbstractWand implements Wand
{
    // instance variables - replace the example below with your own
    private String Name;
    private String Type;

    /**
     * Constructor for objects of class AbstractWand
     * @param Name Name given for the wand
     * @param Type Wand type
     */
    public AbstractWand(String Name, String Type)
    {
        this.Name = Name;
        this.Type = Type;
    }
    
    /**
    * Uses the wand and returns the attack points
    * @param characterOffensivePoints The offensive points from the character that uses the wand
    * @param characterEnergyPoints The energy points from the character that uses the wand
    * @return Attack points
    */
    @Override
    public abstract float offensiveUse(float characterOffensivePoints, float characterEnergyPoints);
    
    
    /**
    * Uses the wand and returns the resistance points
    * @param characterDefensivePoints The defensive points from the character that uses the wand
    * @param characterEnergyPoints The energy points from the character that uses the wand
    * @return Resistance points
    */
    @Override
    public abstract float defensiveUse(float characterdefensivePoints, float characterEnergyPoints);
    
    /**
     * Get method for getting the wand's name
     * @return Wand's name
     */
    @Override
    public String getName(){
     return Name;   
    }
    
    /**
     * Get method for getting the wand's type
     * @return Wand's type
     */
    @Override
    public String getType(){
     return Type;
    }
    
    
   /**
     * Gets Wand info in order to print it.
     * @return Wand info
     */
    @Override
    public String toString(){
        return "<wand: " + getName() + " (" + getType() + ")>";
    };
}
