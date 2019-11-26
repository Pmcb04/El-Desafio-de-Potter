import java.util.*;

/**
 * Class Hyfflepuff
 *
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 12/11/2019
 */
public class Hufflepuff extends House {

  /***
  *
  */
  @Override
  public void orderCharacters() {
    Collections.sort(characterList, new AttackPointsComparator());
  }

}
