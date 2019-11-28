import java.util.*;
/**
 * Creating a class which implements Comparator Interface (using resistencePoints)
 * Order from less to high by the attribute resistencePoints
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
