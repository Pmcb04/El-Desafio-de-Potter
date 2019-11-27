
/**
 * Write a description of class InvigorationPotion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InvigorationPotion extends AbstractPotionExtra
{
   
    public InvigorationPotion(Character character)
    {
       super(character);
    }

   @Override
    public float getDefensivePoints()
    {
        return 1.4f * super.getDefensivePoints();
    }
}
