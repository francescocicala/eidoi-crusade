package francescocicala;

public class Mage {
  private Integer healthPoints = 8;
  private final Alliance alliance = new Alliance();

  public String allianceString() {
    return alliance.showAllianceString();
  }

  public Integer allianceSize() {
    return alliance.cardinality();
  }

  public void draw(Eidos eidos) {
    alliance.addEidos(eidos);
  }

  public void discard(Eidos eidos) {
    alliance.removeEidos(eidos);
  }

  public Integer getHP() {
    return healthPoints;
  }

  public void loseHP(Integer dmg) {
    healthPoints -= dmg;
  }

  public boolean isDead() {
    return healthPoints <= 0;
  }
}