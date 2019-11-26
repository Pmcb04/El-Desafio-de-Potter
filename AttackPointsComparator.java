import java.util.*;

/**
 * Creating a class which implements Comparator Interface (using attackPoints)
 * Order from less to high by the attribute attackPoints
 */
class AttackPointsComparator implements Comparator<Character> {
  public int compare(Character c1, Character c2) {

    if (c1.getAttackPoints() == c2.getAttackPoints())
      return 0;
    else if (c1.getAttackPoints() > c2.getAttackPoints())
      return 1;
    else
      return -1;
  }
}
