
/**
 * Class Character
 *
 * @author Pedro Miguel Carmona Broncano & Rubén Marín Lucas & Adrián Ruiz Parra
 * @version 12/11/2019
 */
public class Character {
  private String name;
  private float energy;
  private float attackPoints;
  private float resistencePoints;

  /**
   * Constructor for objects of class Character
   */
  public Character(String name) {

    this.name = name;
    energy = 20;
    attackPoints = 20;
    resistencePoints = 20;

  }

  /***
  *
  */
  public void setName(String name) {
    this.name = name;
  }

  /***
  *
  */
  public void setEnergyPoints(float energy) {
    this.energy = energy;
  }

  /***
  *
  */
  public void setAttackPoints(float attackPoints) {
    this.attackPoints = attackPoints;
  }

  /***
  *
  */
  public void setResistencePoints(float resistencePoints) {
    this.resistencePoints = resistencePoints;
  }

  /***
  *
  */
  public String getName() {
    return name;
  }

  /***
  *
  */
  public float getEnergyPoints() {
    return energy;
  }

  /***
  *
  */
  public float getAttackPoints() {
    return attackPoints;
  }

  /***
  *
  */
  public float getResistencePoints() {
    return resistencePoints;
  }

  /***
  *
  */
  public void fight() {

  }

}
