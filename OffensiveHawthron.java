
/**
 * Write a description of class OffensiveHawthron here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OffensiveHawthron extends AbstractWand
{
    private float offensivePointsMultiplier;
    private float defensivePointsMultiplier;
    private float offensiveEnergyMultiplier;
    private float defensiveEnergyMultiplier;

    /**
     * Constructor for objects of class OffensiveHawthron
     */
    public OffensiveHawthron(String Name)
    {
        super(Name,"OffensiveHawthron");
        offensivePointsMultiplier = 1.4f;
        defensivePointsMultiplier = 0.2f;
        offensiveEnergyMultiplier = 0.6f;
        defensiveEnergyMultiplier = 0.8f;
        
    }

    @Override
    public float offensiveUse(float characterOffensivePoints, float characterEnergyPoints){
        return (offensiveEnergyMultiplier * characterEnergyPoints + offensivePointsMultiplier * characterOffensivePoints);   
    }

    @Override
    public float defensiveUse(float characterdefensivePoints, float characterEnergyPoints){
        return (defensiveEnergyMultiplier * characterEnergyPoints + defensivePointsMultiplier * characterdefensivePoints);   
    }
}
