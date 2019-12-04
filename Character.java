import java.io.*;
/**
 * Class Character
 *
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 26/11/2019
 */
public abstract class Character
{
    private String Name;
    private float energyPoints;
    private float offensivePoints;
    private float defensivePoints;
    private Wand characterWand;

    /**
     * Constructor for objects of class Character (default mode)
     * @param Name Name given for the character
     * @param Wand Wand assigned to the character
     */
    public Character(String Name, Wand wand)
    {
        this.Name = Name;
        energyPoints = 20;
        offensivePoints = 20;
        defensivePoints = 20;
        characterWand = wand;
    }
    
    /**
     * Constructor for objects of class Character (custom mode)
     * @param Name Name given for the character
     * @param energyPoints Character's energy points
     * @param offensivePoints Character's offensive points
     * @param defensivePoints Character's defensive points
     * @param Wand Wand assigned to the character
     */
    public Character(String Name, float energyPoints, float offensivePoints, float defensivePoints, Wand wand
    )
    {
        this.Name = Name;
        this.energyPoints = energyPoints;
        this.offensivePoints = offensivePoints;
        this.defensivePoints = defensivePoints;
        characterWand = wand;
    }

   
    /**
     * Changes the current wand into a new wand
     * @param Wand The new wand wanted to assign
     */
    public void changeWand(Wand newWand)
    {
        characterWand = newWand;
    }
    
    /***
     * Returns the name of the character
     * @return The name of the character
     */
    public String getName(){
        return Name;
    }
    
     /***
     * Returns the character's assigned wand
     * @return Character's wand
     */
    public String getWandName(){
        return characterWand.getName();
    }
    
     /***
     * Returns the character's assigned wand type
     * @return Character's wand type
     */
    public String getWandType(){
        return characterWand.getType();
    }
    
    
     /***
     * Uses the wand in a offensive way in order to get the attack points 
     * @return Character's attack points
     */
    public float getAttackPoints(){
        return characterWand.offensiveUse(getOffensivePoints(), getEnergyPoints());
    }
    
     /***
     * Uses the wand in a defensive way in order to get the resistance points 
     * @return Character's resistance points
     */
    public float getResistancePoints(){
        return characterWand.defensiveUse(getDefensivePoints(),getEnergyPoints());
    }
       
     /***
     * Damages the character's energy points
     * @param damage Amount of damage the character has taken
     */
    public void executeDamage(float damage){
        energyPoints -= damage;
        if(energyPoints<0) energyPoints = 0;
    }
    
    /***
     * Fights an opponent and calls a method to print the results
     * @param opponent Character that will be the opponent
     * @param fw The FileWriter that will be written
     */
    public void fight(Character opponent, FileWriter fw) throws IOException{
        float attackPoints;
        float resistancePoints;
        float balance;
        
        attackPoints = getAttackPoints();
        resistancePoints = opponent.getResistancePoints();
        
        balance = attackPoints - resistancePoints;
        
        
        if(balance >= 0)
            opponent.executeDamage(balance);
            
        printDuel(opponent, resistancePoints, fw);
    }
    
    /**
     * Prints the fight that has called this method
     *
     * @param opponent The opponent that has been fought
     * @param opponentResistancePoints The resistance points that the opponent had while the fight
     * @param fw The FileWriter where the fights will be writen
     */
    public void printDuel(Character opponent, float opponentResistancePoints, FileWriter fw) throws IOException
    {
        
        float ap = Math.round(getAttackPoints() * 100f) / 100f;
        float rp = Math.round(opponentResistancePoints * 100f) / 100f;
        float ep = Math.round(opponent.getEnergyPoints() * 100f) / 100f;
        
        String s = "attack points of <" + getName() + "> are : <" + ap + ">\nresistance points of <" + opponent.getName() + "> are: <" +
            rp +  ">\nthe remaining points of : <" + opponent.getName() + " after the duel are <" + ep + ">\n"; 
       
     
         System.out.printf(s);  
         fw.write(s);
        
         System.out.println();
        fw.write("\n");
    }

    
    /**
     * Set method for setting new offensive points
     * @param offensivePoints New offensive points
     */
    public void setOffensivePoints(float offensivePoints){
     this.offensivePoints = offensivePoints;    
    }
    
    /**
     * Set method for setting new defensive points
     * @param offensivePoints New defensive points
     */
    public void setDefensivePoints(float defensivePoints){
     this.defensivePoints = defensivePoints;    
    }
    
    /**
     * Set method for setting new energy points
     * @param offensivePoints New energy points
     */
    public void setEnergyPoints(float energyPoints){
     this.energyPoints = energyPoints;    
    }
    
    
    /**
     * Get method for getting offensive points
     * @return Offensive points
     */
    public float getOffensivePoints(){
     return offensivePoints;    
    }
    
    /**
     * Get method for getting defensive points
     * @return Defensive points
     */
    public float getDefensivePoints(){
     return defensivePoints;    
    }
    
    /**
     * Get method for getting energy points
     * @return Energy points
     */
    public float getEnergyPoints(){
      return energyPoints;
    }
    
    
    /**
     * Get method for getting the character's wand
     * @return Character's wand
     */
    public Wand getWand(){
       return characterWand;   
    }
    
    /**
     * Print method to print the character info
     * @param fw FileWriter where the info will be written
     */
    public void printCharacter(FileWriter fw) throws IOException
    {
       
        float op = Math.round(getOffensivePoints() * 100f) / 100f;
        float dp = Math.round(getDefensivePoints() * 100f) / 100f;
        float ep = Math.round(getEnergyPoints() * 100f) / 100f;
        
        String s = "character:<" + getName() + "> <e: " + ep + "> <o: " + op + "> <d: " +
            dp + "> <wand: " + getWandName() + " (" + getWandType() + ")>"; 
         

      System.out.printf(s);
      fw.write(s);
    }

}
