
/**
 * Class Character
 *
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 26/11/2019
 */
public abstract class Character
{
    // instance variables - replace the example below with your own
    private String Name;
    private float energyPoints;
    private float offensivePoints;
    private float defensivePoints;
    private Wand characterWand;

    /**
     * Constructor for objects of class Character
     */
    public Character(String Name)
    {
        this.Name = Name;
        characterWand = null;
        energyPoints = 20;
        offensivePoints = 20;
        defensivePoints = 20;
    }
    
    /**
     * Constructor for objects of class Character
     */
    public Character(String Name, float energyPoints, float offensivePoints, float defensivePoints)
    {
        this.Name = Name;
        characterWand = null;
        this.energyPoints = energyPoints;
        this.offensivePoints = offensivePoints;
        this.defensivePoints = defensivePoints;
    }

   
    /**
     * Changes the current wand into a new wand
     * 
     */
    public void changeWand(Wand newWand)
    {
        characterWand = newWand;
    }
    
    /***
     * 
     */
    public String getName(){
        return Name;
    }
    
     /***
     * 
     */
    public String getWandName(){
        return characterWand.getName();
    }
    
    /***
     * 
     */
    public String getWandType(){
        return characterWand.getType();
    }
    
    /***
     * 
     */
    public float getAttackPoints(){
        return characterWand.offensiveUse(offensivePoints, energyPoints);
    }
    
    /***
     * 
     */
    public float getResistancePoints(){
        return characterWand.defensiveUse(defensivePoints, energyPoints);
    }
    
    /***
     * 
     */
    public float getEnergyPoints(){
        return energyPoints;
    }
    
    /***
     * 
     */
    public void executeDamage(float damage){
        energyPoints -= damage;
    }
    
    /***
     * 
     */
    public void fight(Character opponent){
        float attackPoints;
        float resistancePoints;
        float balance;
        
        attackPoints = getAttackPoints();
        resistancePoints = opponent.getResistancePoints();
        
        balance = attackPoints - resistancePoints;
        
        if(balance>0) opponent.executeDamage(balance);
    }
    
    public void setOffensivePoints(float offensivePoints){
     this.offensivePoints = offensivePoints;    
    }
    
    public void setDefensivePoints(float defensivePoints){
     this.defensivePoints = defensivePoints;    
    }
    
    public void setEnergyPoints(float energyPoints){
     this.energyPoints = energyPoints;    
    }
    
    public float getOffensivePoints(){
     return offensivePoints;    
    }
    
    public float getDefensivePoints(){
     return defensivePoints;    
    }
    
}
