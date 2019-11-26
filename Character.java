
/**
 * Class Character
 *
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 26/11/2019
 */
public class Character
{
    // instance variables - replace the example below with your own
    private String Name;
    private float energyPoints;
    private float offensivePoints;
    private float defensivePoints;
    private Wand characterWand;
    private String Type;

    /**
     * Constructor for objects of class Character
     */
    public Character(String Name, String Type, Wand wand)
    {
        this.Name = Name;
        this.Type = Type;
        characterWand = wand;
        energyPoints = 20;
        offensivePoints = 20;
        defensivePoints = 20;
        checkType();
    }
    
    /**
     * Constructor for objects of class Character
     */
    public Character(String Name, String Type, float energyPoints, float offensivePoints, float defensivePoints, Wand wand)
    {
        this.Name = Name;
        this.Type = Type;
        characterWand = wand;
        this.energyPoints = energyPoints;
        this.offensivePoints = offensivePoints;
        this.defensivePoints = defensivePoints;
        checkType();
    }

    /**
     * Method that checks Character type and applies the type characterictics
     
     */
    public void checkType()
    {
        if (Type.equals("Offensive")) offensivePoints += 5;
        if (Type.equals("Defensive")) defensivePoints += 5;
    }
   
    /**
     * Changes the current wand into a new wand
     * 
     */
    public void changeWand(Wand newWand)
    {
        characterWand = newWand;
    }
    
    public float getAttackPoints(){
        return characterWand.offesiveUse(offensivePoints, energyPoints);
    }
    public float getResistancePoints(){
        return characterWand.defensiveUse(defensivePoints, energyPoints);
    }
    
    public void executeDamage(float damage){
        energyPoints -= damage;
    }
    
    public void fight(Character opponent){
        float attackPoints;
        float resistancePoints;
        float balance;
        
        attackPoints = getAttackPoints();
        resistancePoints = opponent.getResistancePoints();
        
        balance = attackPoints - resistancePoints;
        
        if(balance>0) opponent.executeDamage(balance);
    }
}
