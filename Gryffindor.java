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
   * 
   * @param name Name of the Gryffindor
   */
  public Gryffindor (String name){
        super(name);
  }  
    
    
  /***
   * Order from less to high by the attribute resistencePoints the 
   * character of characterList
   */
  @Override
  public void orderCharacters() {
    Collections.sort(getCharacterList(), new DefensivePointsComparator());
  }

}
