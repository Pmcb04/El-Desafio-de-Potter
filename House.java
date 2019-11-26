import java.util.*;

/**
 * Class House
 *
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 12/11/2019
 */
public abstract class House {

  protected List<Character> characterList;

  /**
   * Constructor for objects of class House
   */
  public House() {
    characterList = new ArrayList<Character>();
  }

  /***
   * Abstract method that especific house order it is own characters
   */
  public abstract void orderCharacters();

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
      System.out.printf("character:<%s> <e: %f> <o: %f> <d: %f> <wand: %s (%s)>\n", c.getName(), c.getEnergyPoints(),
          c.getOffensivePoints(), c.getDefensivePoints(), c.getWandName(), c.getWandType());
    }

  }

}
