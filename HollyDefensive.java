
/**
 * Write a description of class OffensiveHawthron here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HollyDefensive extends AbstractWand
{
    private float offensivePointsMultiplier;
    private float defensivePointsMultiplier;
    private float offensiveEnergyMultiplier;
    private float defensiveEnergyMultiplier;

    /**
     * Constructor for objects of class OffensiveHawthron
     */
    public HollyDefensive(String Name)
    {
        super(Name,"HollyDefensive");
        offensivePointsMultiplier = 0.3f;
        defensivePointsMultiplier = 1.1f;
        offensiveEnergyMultiplier = 0.7f;
        defensiveEnergyMultiplier = 0.9f;
        
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
