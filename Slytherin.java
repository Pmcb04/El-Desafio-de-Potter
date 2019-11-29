import java.util.*;

/**
 * Class Slytherin
 *
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 12/11/2019
 */
public class Slytherin extends House {

  public Slytherin (String name){
        super(name);
  }   
     
  /***
   * Order from high to less by the attribute attackPoints the character of
   * characterList
   */
  @Override
  public void orderCharacters() {
    Collections.sort(getCharacterList(), new OffensivePointsComparator());
  }

}
