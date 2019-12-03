import java.util.*;

/**
 * Class Slytherin
 *
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 12/11/2019
 */
public class Slytherin extends House {
 
  /**
   * Constructor for objects of class Slytherin
   * 
   * @param name Name of the Slytherin
   */
  public Slytherin (){
        super("Slytherin");
  }   
     
  /***
   * Order from high to less by the attribute attackPoints the 
   * character of characterList
   */
  @Override
  public void orderCharacters() {
    Collections.sort(getCharacterList(), Collections.reverseOrder(new OffensivePointsComparator()));
  }

}
