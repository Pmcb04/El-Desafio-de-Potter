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
   * Return the name of the house
   * @return name of the house
   */
  protected String getName(){
      return name;
  }
  
  /***
  * Introduce the name of the house
  * @param name is a name of the house
  */
  protected void setName(String name){
      this.name = name;
  }
   
  /**
  * An example of a method - replace this comment with your own
  *
  * @param  y  a sample parameter for a method
  * @return    the sum of x and y
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
   * @param character is a character that it will introduce in characterList
   */
  public void setCharacter(Character character) {
    characterList.add(character);
  }

  /***
   * Return the first character in characterList
   *
   * @return Character
   */
  public Character getCharacter() {
    return characterList.get(0);
  }
  
  /***
   * 
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
  * An example of a method - replace this comment with your own
  *
  * @param  y  a sample parameter for a method
  * @return    the sum of x and y
  */
  public int getTotalEnergyPoints()
  {
    int totalEnergy = 0;
    
    for(Character c : characterList)
        totalEnergy += c.getEnergyPoints();
        
    return totalEnergy;
  }
  
    /**
  * An example of a method - replace this comment with your own
  *
  * @param  y  a sample parameter for a method
  * @return    the sum of x and y
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
