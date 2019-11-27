
/**
 * Write a description of class OffensiveCharacter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OffensiveCharacter extends Character
{

    /**
     * Constructor for objects of class DefensiveCharacter
     */
    public OffensiveCharacter(String Name)
    {
        super(Name);
        boostOffensivePoints();
    }

    /**
     * Constructor for objects of class DefensiveCharacter
     */
    public OffensiveCharacter(String Name, float energyPoints, float offensivePoints, float defensivePoints)
    {
        super(Name,energyPoints,offensivePoints,defensivePoints);
        boostOffensivePoints();
    }
    
    private void boostOffensivePoints(){
        setOffensivePoints(getOffensivePoints()+5f);
    }
}
