
/**
 * Class OffensiveCharacter
 *
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 26/11/2019
 */
public class OffensiveCharacter extends Character
{

    /**
     * Constructor for objects of class OffensiveCharacter (default mode)
     * @param Name Name given for the character
     * @param Wand Wand assigned to the character
     */
    public OffensiveCharacter(String Name, Wand wand)
    {
        super(Name,wand);
        boostOffensivePoints();
    }

     /**
     * Constructor for objects of class OffensiveCharacter (custom mode)
     * @param Name Name given for the character
     * @param Wand Wand assigned to the character
     * @param energyPoints Character's energy points
     * @param offensivePoints Character's offensive points
     * @param defensivePoints Character's defensive points
     */
    public OffensiveCharacter(String Name, float energyPoints, float offensivePoints, float defensivePoints, Wand wand)
    {
        super(Name,energyPoints,offensivePoints,defensivePoints,wand);
        boostOffensivePoints();
    }
    
    /**
     * Method that boosts the offensive points from the character
     */
    private void boostOffensivePoints(){
        setOffensivePoints(getOffensivePoints()+5f);
    }
}
