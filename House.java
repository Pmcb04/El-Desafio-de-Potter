import java.util.*;
import java.io.*;

/**
 * Class House
 *
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 12/11/2019
 */
public abstract class House {

  protected List<Character> characterList;
  protected String name;

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
  public String getName(){
      return name;
  }
  
  /***
  * Introduce the name of the house
  * @param name is a name of the house
  */
  public void setName(String name){
      this.name = name;
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
    Character c = characterList.get(0);
    characterList.remove(0);
    return c;
  }

  /***
   * Print all character in characterList with him attributes
   */
  public void printCharacterList() {

    for (Character c : characterList) {
      System.out.printf("character:<%s> <e: %.1f> <o: %.1f> <d: %.1f> <wand: %s (%s)>\n", c.getName(), c.getEnergyPoints(),
          c.getAttackPoints(), c.getResistancePoints(), c.getWandName(), c.getWandType());
    }

  }

}
