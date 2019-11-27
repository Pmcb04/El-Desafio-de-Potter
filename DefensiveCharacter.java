
/**
 * Class Defensive Character
 *
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 26/11/2019
 */
public class DefensiveCharacter extends Character
{

    /**
     * Constructor for objects of class DefensiveCharacter
     */
    public DefensiveCharacter(String Name, Wand wand)
    {
        super(Name,wand);
        boostDefensivePoints();
    }

    /**
     * Constructor for objects of class DefensiveCharacter
     */
    public DefensiveCharacter(String Name, float energyPoints, float offensivePoints, float defensivePoints,Wand wand)
    {
        super(Name,energyPoints,offensivePoints,defensivePoints,wand);
        boostDefensivePoints();
    }
    
    private void boostDefensivePoints(){
        setDefensivePoints(getDefensivePoints()+5f);
    }
}
