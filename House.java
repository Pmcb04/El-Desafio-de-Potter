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
   * Abstract method that especific house order it is own characters
   */
  public abstract void orderCharacters();

  /***
   * Returns the name of the house
   * @return name of the house
   */
  protected String getName(){
      return name;
  }
  
  /***
  * Introduces the name of the house
  * @param name Name of the house
  */
  protected void setName(String name){
      this.name = name;
  }
   
  /**
  * Returns the number of elements of characterList
  * @return  size of characterList
  */
  public int howManyCharacters()
  {
     return characterList.size();
  }

  
  /***
  * Return the characterList
  * @return the characterList
  */
  protected List<Character> getCharacterList(){
      return characterList;
  }

  /***
   * Introduce one Character in the last index of characterList
   *
   * @param character Is a character that it will introduce in characterList
   */
  public void setCharacter(Character character) {
    characterList.add(character);
  }

  /***
   * Return the first character in characterList
   *
   * @return the first character of characterList
   */
  public Character getCharacter() {
    return characterList.get(0);
  }
  
  /***
   * Checks if the first Character of characterList is eliminated, if it is eliminated it gets deleted from
   * characterList, if it isn't eliminated it gets moved to the last position of character List
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
  * Calculated the total of energy points of all characters of characterList
  * 
  * @return total of energy points
  */
  public int getTotalEnergyPoints()
  {
    int totalEnergy = 0;
    
    for(Character c : characterList)
        totalEnergy += c.getEnergyPoints();
        
    return totalEnergy;
  }
  
  /**
  * Calculated the total of defensive points and offensive of all characters of characterList
  * 
  * @return total of defnsive points and offensive points
  */
  public int getTotalDefensiveOffensivePoints()
  {
    int totalPoints = 0;
    
    for(Character c : characterList)
        totalPoints += c.getOffensivePoints() + c.getDefensivePoints();
        
    return totalPoints;
  }
  
  /***
   * Print all character in characterList with him attributes
   */
  public void printCharacterList(FileWriter fw) throws IOException{

    for (Character c : characterList) {
        c.printCharacter(fw);
        fw.write("\n");
    }

  }

}
