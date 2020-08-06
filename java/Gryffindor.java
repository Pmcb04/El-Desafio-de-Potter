import java.util.*;

/**
 * Class Gryffindor
 *
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 12/11/2019
 */
public class Gryffindor extends House {
    
  /**
   * Constructor for objects of class Gryffindor
   */
  public Gryffindor (String name){
        super(name);
  }  
    
    
  /***
   * Sort characters by their defensive points in an ascendant order
   */
  @Override
  public void orderCharacters() {
    Collections.sort(getCharacterList(), new DefensivePointsComparator());
  }

}
