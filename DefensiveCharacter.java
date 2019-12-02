
/**
 * Class DefensiveCharacter
 *
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 26/11/2019
 */
public class DefensiveCharacter extends Character
{

    /**
     * Constructor for objects of class DefensiveCharacter (default mode)
     * @param Name Name given for the character
     * @param Wand Wand assigned to the character
     */
    public DefensiveCharacter(String Name, Wand wand)
    {
        super(Name,wand);
        boostDefensivePoints();
    }

     /**
     * Constructor for objects of class DefensiveCharacter (custom mode)
     * @param Name Name given for the character
     * @param Wand Wand assigned to the character
     * @param energyPoints Character's energy points
     * @param offensivePoints Character's offensive points
     * @param defensivePoints Character's defensive points
     */
    public DefensiveCharacter(String Name, float energyPoints, float offensivePoints, float defensivePoints,Wand wand)
    {
        super(Name,energyPoints,offensivePoints,defensivePoints,wand);
        boostDefensivePoints();
    }
    
    /**
     * Method that boosts the defensive points from the character
     */
    private void boostDefensivePoints(){
        setDefensivePoints(getDefensivePoints()+5f);
    }
}
