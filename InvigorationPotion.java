/**
 * Class InvigorationPotion
 * Decorator Pattern
 *
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 26/11/2019
 */
public class InvigorationPotion extends AbstractPotionExtra
{
    /**
     * Constructor for objects of class InvigorationPotion
     * @param character Character that will be decorated
     */
    public InvigorationPotion(Character character)
    {
       super(character);
    }

   @Override
    /**
     * Get method for getting defensive points with potion effects
     * @return Defensive points
     */
    public float getDefensivePoints()
    {
        return 1.4f * super.getDefensivePoints();
    }
}
