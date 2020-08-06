import java.util.*;

/**
 * Class DefensivePointsComparator
 * Sorts by defensivePoints in an ascending order. If defensivePoints are equal, it sorts by name
 * 
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 12/11/2019
 */
class DefensivePointsComparator implements Comparator<Character> {
  public int compare(Character c1, Character c2) {

    if (c1.getDefensivePoints() == c2.getDefensivePoints())
       return c1.getName().compareTo(c2.getName());
    else if (c1.getDefensivePoints() > c2.getDefensivePoints())
      return 1;
    else
      return -1;
  }
}
