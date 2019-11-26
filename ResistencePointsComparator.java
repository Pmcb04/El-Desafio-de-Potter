import java.util.*;
/**
 * Creating a class which implements Comparator Interface (using resistencePoints)
 * Order from less to high by the attribute resistencePoints
 */
class ResistencePointsComparator implements Comparator<Character> {
  public int compare(Character c1, Character c2) {

    if (c1.getResistancePoints() == c2.getResistancePoints())
      return 0;
    else if (c1.getResistancePoints() > c2.getResistancePoints())
      return 1;
    else
      return -1;
  }
}
