/**
 * Class AbstractPotionExtra
 * Decorator Pattern
 *
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 26/11/2019
 */
public abstract class AbstractPotionExtra extends Character{

    private Character decoratedCharacter;
    
    
    /**
     * Constructor for objects of class AbstractPotionExtra
     * @param character Character that will be decorated
     */
    public AbstractPotionExtra(Character character){
        super(character.getName(),character.getEnergyPoints(),
        character.getOffensivePoints(),character.getDefensivePoints(),character.getWand());
        decoratedCharacter = character;
    }
    
    /**
     * Get method for getting defensive points
     * @return Defensive points
     */
    public float getDefensivePoints(){
     return decoratedCharacter.getDefensivePoints();
    }
    
    /**
     * Get method for getting offensive points
     * @return Offensive points
     */
    public float getOffensivePoints(){
      return decoratedCharacter.getOffensivePoints();
    }

}
