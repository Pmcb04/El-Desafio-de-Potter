/**
 * Abstract class AbstractPotionExtra - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class AbstractPotionExtra extends Character{

    private Character decoratedCharacter;
    
    public AbstractPotionExtra(Character character){
        super(character.getName(),character.getEnergyPoints(),
        character.getOffensivePoints(),character.getDefensivePoints(),character.getWand());
        decoratedCharacter = character;
    }
    
    public float getDefensivePoints(){
     return decoratedCharacter.getDefensivePoints();   
    }
    
    public float getOffensivePoints(){
      return decoratedCharacter.getOffensivePoints();
    }

}