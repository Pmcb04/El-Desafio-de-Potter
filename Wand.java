import java.io.*;
/**
 * Class Wand
 * Strategy Pattern
 *
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 26/11/2019
 */
public interface Wand
{
    
    /**
    * Uses the wand and returns the attack points
    * @param characterOffensivePoints The offensive points from the character that uses the wand
    * @param characterEnergyPoints The energy points from the character that uses the wand
    * @return Attack points
    */
    public float offensiveUse(float characterOffensivePoints, float characterEnergyPoints);
    
    /**
    * Uses the wand and returns the resistance points
    * @param characterDefensivePoints The defensive points from the character that uses the wand
    * @param characterEnergyPoints The energy points from the character that uses the wand
    * @return Resistance points
    */
    public float defensiveUse(float characterDefensivePoints, float characterEnergyPoints);
    
    /**
     * Get method for getting the wand's name
     * @return Wand's name
     */
    public String getName();
    
    /**
     * Get method for getting the wand's type
     * @return Wand's type
     */
    public String getType();
    
    /**
     * Gets Wand info in order to print it.
     * @return Wand info
     */
    public String toString();
}
