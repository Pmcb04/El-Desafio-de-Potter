
/**
 * Creating a class which implements Comparator Interface (using resistencePoints)
 * Order from less to high by the attribute resistencePoints
 */
import java.util.*;

class ResistencePointsComparator implements Comparator<Character> {
  public int compare(Character c1, Character c2) {

    if (c1.getResistencePoints() == c2.getResistencePoints())
      return 0;
    else if (c1.getResistencePoints() > c2.getResistencePoints())
      return 1;
    else
      return -1;
  }
}
