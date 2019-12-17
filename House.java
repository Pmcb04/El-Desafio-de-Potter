import java.util.*;
import java.io.*;

/**
 * Class House
 *
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 12/11/2019
 */
public abstract class House {

  private List<Character> characterList;
  private String name;

  /**
   * Constructor for objects of class House
   * 
   * @param name Name of the house
   */
  public House(String name) {
    this.name = name;
    characterList = new ArrayList<Character>();
  }

  /***
   * Abstract method that sorts characterList depending of the house
   */
  public abstract void orderCharacters();

  /***
   * Returns the name of the house
   * @return The name of the house
   */
  protected String getName(){
      return name;
  }
  
  /***
  * Introduces a new name for the house
  * @param name New name for the house
  */
  protected void setName(String name){
      this.name = name;
  }
   
  /**
  * Returns the number of characters from characterList
  * @return Size of characterList
  */
  public int howManyCharacters()
  {
     return characterList.size();
  }

  
  /***
  * Returns characterList
  * @return CharacterList
  */
  protected List<Character> getCharacterList(){
      return characterList;
  }

  /***
   * Introduce one Character in the last position of characterList
   *
   * @param character The character that will get introduced in characterList
   */
  public void setCharacter(Character character) {
    characterList.add(character);
  }

  /***
   * Returns the first character of characterList
   *
   * @return the first character of characterList
   */
  public Character getCharacter() {
    return characterList.get(0);
  }
  
  /***
   * Checks if the first Character of characterList is eliminated, if it is eliminated it gets deleted from
   * characterList. If it is not eliminated it gets moved to the last position of character List
   */
  public void checkCharacters(){
      
      if(getCharacter().getEnergyPoints() <= 0) characterList.remove(0);
      else {
          Character c  = getCharacter();
          characterList.remove(0);
          characterList.add(c);
      }
  }
  
  /**
  * Calculates the sum of energy points from all characters of characterList
  * 
  * @return Sum of energy points from all characters
  */
  public float getTotalEnergyPoints()
  {
    float totalEnergy = 0;
    
    for(Character c : characterList)
        totalEnergy += c.getEnergyPoints();
        
    return totalEnergy;
  }
  
  /**
  * Calculates the sum of defensive and offensive points from all characters of characterList
  * 
  * @return Sum of defensive points from all characters
  */
  public float getTotalDefensiveOffensivePoints()
  {
    float totalPoints = 0;
    
    for(Character c : characterList)
        totalPoints += c.getOffensivePoints() + c.getDefensivePoints();
        
    return totalPoints;
  }
  
  /***
   * Prints all characters from characterList with their attributes
   */
  public void printCharacterList(FileWriter fw) throws IOException{

    for (Character c : characterList) {
        c.printCharacter(fw);
        fw.write("\n");
        System.out.println();
    }

  }

}
