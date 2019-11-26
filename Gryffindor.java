import java.util.*;

/**
 * Class Gryffindor
 *
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 12/11/2019
 */
public class Gryffindor extends House {

  /***
  * 
  */
  @Override
  public void orderCharacters() {
    Collections.sort(characterList, new ResistencePointsComparator());
  }

}
