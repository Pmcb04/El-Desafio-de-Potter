import java.util.*;

/**
 * Class Hyfflepuff
 *
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 12/11/2019
 */
public class Hufflepuff extends House {

  /**
   * Constructor for objects of class Hufflepuff
   */
  public Hufflepuff (){
        super("Hufflepuff");
  }
  
  /***
   * Sort characters by their offensive points in an ascendant order
   */
  @Override
  public void orderCharacters() {
    Collections.sort(getCharacterList(),new OffensivePointsComparator());
  }

}
