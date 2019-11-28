import java.io.*;
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
    public Character(String Name, Wand wand)
    {
        this.Name = Name;
        energyPoints = 20;
        offensivePoints = 20;
        defensivePoints = 20;
        characterWand = wand;
    }
    
    /**
     * Constructor for objects of class Character
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
        return characterWand.offensiveUse(getOffensivePoints(), getEnergyPoints());
    }
    
    /***
     * 
     */
    public float getResistancePoints(){
        return characterWand.defensiveUse(getDefensivePoints(),getEnergyPoints());
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
    public void fight(Character opponent, FileWriter fw) throws IOException{
        float attackPoints;
        float resistancePoints;
        float balance;
        
        attackPoints = getAttackPoints();
        resistancePoints = opponent.getResistancePoints();
        
        balance = attackPoints - resistancePoints;
        
        if(balance >= 0)
            opponent.executeDamage(balance);
            
        printDuel(opponent, balance, fw);
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void printDuel(Character opponent, float balance, FileWriter fw) throws IOException
    {
        
       
        String s1 = String.format("<%s> is dueling against <%s>%n", 
                                   getName(), opponent.getName());
        String s2 = String.format("attack points of <%s> are: <%.1f>%nresistance points of <%s> are: <%.1f>%nthe remaining energy of <%s> after the duel are: <%.1f>%n",
                                   getName(), getOffensivePoints(), opponent.getName(), opponent.getDefensivePoints(), 
                                   opponent.getName(), balance);
       
     
        
        if(balance < 0){ 
            System.out.printf(s1);
            fw.write(s1);
        }else{
           System.out.printf(s1 + s2);  
           fw.write(s1 + s2);
        }
        
         System.out.println();
        fw.write("\n");

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
    
    /***
    * 
    */
    public float getEnergyPoints(){
        return energyPoints;
    }
    
    public Wand getWand(){
     return characterWand;   
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void printCharacter(FileWriter fw) throws IOException
    {
      String s = String.format("character:<%s> <e: %.1f> <o: %.1f> <d: %.1f> <wand: %s (%s)>\n", getName(), getEnergyPoints(),
                            getAttackPoints(),getResistancePoints(), getWandName(), getWandType());
      System.out.printf(s);
      fw.write(s);
    }

}
