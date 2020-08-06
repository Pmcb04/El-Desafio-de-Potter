import java.util.*;

/**
 * Class OffensivePointsComparator
 * Sorts by attackPoints in an ascending order. If attackPoints are equal, it sorts by name
 *
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 12/11/2019
 */
class OffensivePointsComparator implements Comparator<Character> {
  public int compare(Character c1, Character c2) {

    if (c1.getOffensivePoints() == c2.getOffensivePoints())
       return c1.getName().compareTo(c2.getName());
    else if (c1.getOffensivePoints() > c2.getOffensivePoints())
      return 1;
    else
      return -1;
  }
}
