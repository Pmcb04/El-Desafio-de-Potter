/**
 * Class FelixFelicisPotion
 * Decorator Pattern
 *
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 26/11/2019
 */
public class FelixFelicisPotion extends AbstractPotionExtra
{
    /**
     * Constructor for objects of class FelixFelicisPotion
     * @param character Character that will be decorated
     */
    public FelixFelicisPotion(Character character)
    {
        super(character);
    }

   @Override
    /**
     * Get method for getting offensive points with potion effects
     * @return Offensive points
     */
    public float getOffensivePoints()
    {
        return 1.3f * super.getOffensivePoints();
    }
}
