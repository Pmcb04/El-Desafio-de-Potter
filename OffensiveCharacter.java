
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
    public OffensiveCharacter(String Name, Wand wand)
    {
        super(Name,wand);
        boostOffensivePoints();
    }

    /**
     * Constructor for objects of class DefensiveCharacter
     */
    public OffensiveCharacter(String Name, float energyPoints, float offensivePoints, float defensivePoints, Wand wand)
    {
        super(Name,energyPoints,offensivePoints,defensivePoints,wand);
        boostOffensivePoints();
    }
    
    private void boostOffensivePoints(){
        setOffensivePoints(getOffensivePoints()+5f);
    }
}
