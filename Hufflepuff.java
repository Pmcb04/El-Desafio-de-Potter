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
   * 
   * @param name Name of the Hufflepuff
   */
  public Hufflepuff (){
        super("Hufflepuff");
  }
  
  /***
   * Order from less to high by the attribute attackPoints the 
   * character of characterList
   */
  @Override
  public void orderCharacters() {
    Collections.sort(getCharacterList(),new OffensivePointsComparator());
  }

}
