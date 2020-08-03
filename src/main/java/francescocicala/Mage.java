package francescocicala;

public class Mage {
  private Integer healthPoints = 8;
  private final Alliance alliance = new Alliance();

  
  /** 
   * Returns a String with info about mage's alliance.
   * @return String
   */
  public String allianceString() {
    return alliance.showAllianceString();
  }

  
  /** 
   * Returns the size of mage's alliance.
   * @return Integer
   */
  public Integer allianceSize() {
    return alliance.cardinality();
  }

  
  /** 
   * Adds eidos to mage's alliance.
   * @param eidos Eidos to add to alliance
   */
  public void draw(Eidos eidos) {
    alliance.addEidos(eidos);
  }

  
  /** 
   * Discard eidos from mage's alliance.
   * @param eidos Eidos to discard
   */
  public void discard(Eidos eidos) {
    alliance.removeEidos(eidos);
  }

  
  /** 
   * Returns mage's health points.
   * @return Integer
   */
  public Integer getHP() {
    return healthPoints;
  }

  
  /** 
   * Decreases mage's health points of an amount equal to dmg.
   * @param dmg Damages
   */
  public void loseHP(Integer dmg) {
    healthPoints -= dmg;
  }

  
  /** 
   * Returns a boolean for indicating if mage's health points are equal to or below zero.
   * @return boolean
   */
  public boolean isDead() {
    return healthPoints <= 0;
  }
}