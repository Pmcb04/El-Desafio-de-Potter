
/**
 * Write a description of class FelixFelicisPotion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FelixFelicisPotion extends AbstractPotionExtra
{

    /**
     * Constructor for objects of class FelixFelicisPotion
     */
    public FelixFelicisPotion(Character character)
    {
        super(character);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public float getOffensivePoints()
    {
        return 1.3f * super.getOffensivePoints();
    }
}
