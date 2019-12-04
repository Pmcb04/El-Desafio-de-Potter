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
   */
  public Slytherin (){
        super("Slytherin");
  }   
     
  /***
   * Sort characters by their offensive points in an descendant order
   */
  @Override
  public void orderCharacters() {
    Collections.sort(getCharacterList(), Collections.reverseOrder(new OffensivePointsComparator()));
  }

}
