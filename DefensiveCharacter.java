
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
    public DefensiveCharacter(String Name)
    {
        super(Name);
        boostDefensivePoints();
    }

    /**
     * Constructor for objects of class DefensiveCharacter
     */
    public DefensiveCharacter(String Name, float energyPoints, float offensivePoints, float defensivePoints)
    {
        super(Name,energyPoints,offensivePoints,defensivePoints);
        boostDefensivePoints();
    }
    
    private void boostDefensivePoints(){
        setDefensivePoints(getDefensivePoints()+5f);
    }
}
