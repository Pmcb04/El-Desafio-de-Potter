/**
 * Class HollyDefensive
 * Strategy Pattern
 *
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 26/11/2019
 */
public class HollyDefensive extends AbstractWand
{
    private float offensivePointsMultiplier;
    private float defensivePointsMultiplier;
    private float offensiveEnergyMultiplier;
    private float defensiveEnergyMultiplier;

    /**
     * Constructor for objects of class HollyDefensive
     * @param Name Name given for the wand
     */
    public HollyDefensive(String Name)
    {
        super(Name,"HollyDefensive");
        offensivePointsMultiplier = 0.3f;
        defensivePointsMultiplier = 1.1f;
        offensiveEnergyMultiplier = 0.7f;
        defensiveEnergyMultiplier = 0.9f;
        
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
