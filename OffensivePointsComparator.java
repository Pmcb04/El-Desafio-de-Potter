import java.util.*;

/**
 * Creating a class which implements Comparator Interface (using attackPoints)
 * Order from less to high by the attribute attackPoints
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
