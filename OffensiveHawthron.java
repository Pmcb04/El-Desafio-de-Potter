/**
 * Class OffensiveHawthron
 * Strategy Pattern
 *
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 26/11/2019
 */
public class OffensiveHawthron extends AbstractWand
{
    private float offensivePointsMultiplier;
    private float defensivePointsMultiplier;
    private float offensiveEnergyMultiplier;
    private float defensiveEnergyMultiplier;

    /**
     * Constructor for objects of class OffensiveHawthron
     * @param Name Name given for the wand
     */
    public OffensiveHawthron(String Name)
    {
        super(Name,"OffensiveHawthron");
        offensivePointsMultiplier = 1.4f;
        defensivePointsMultiplier = 0.2f;
        offensiveEnergyMultiplier = 0.6f;
        defensiveEnergyMultiplier = 0.8f;
        
    }
    
    
    /**
    * Uses the wand and returns the attack points
    * @param characterOffensivePoints The offensive points from the character that uses the wand
    * @param characterEnergyPoints The energy points from the character that uses the wand
    * @return Attack points
    */
    @Override
    public float offensiveUse(float characterOffensivePoints, float characterEnergyPoints){
        return (offensiveEnergyMultiplier * characterEnergyPoints + offensivePointsMultiplier * characterOffensivePoints);   
    }

    
    /**
    * Uses the wand and returns the resistance points
    * @param characterDefensivePoints The defensive points from the character that uses the wand
    * @param characterEnergyPoints The energy points from the character that uses the wand
    * @return Resistance points
    */
    @Override
    public float defensiveUse(float characterdefensivePoints, float characterEnergyPoints){
        return (defensiveEnergyMultiplier * characterEnergyPoints + defensivePointsMultiplier * characterdefensivePoints);   
    }
}
