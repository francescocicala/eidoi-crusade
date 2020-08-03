package francescocicala;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MageTest {
  Eidos eidos = new Eidos("Dante", 3, 6);

  @Test
  public void testShowAlliance() {
    final Mage pl = new Mage("Merlin");
    assertEquals("Empty alliance.", pl.allianceString());
  }

  @Test
  public void testAllianceSize() {
    final Mage pl = new Mage("Merlin");
    assertEquals(0, pl.allianceSize());
  }

  @Test
  public void testDrawDiscard() {
    final Mage pl = new Mage("Merlin");
    pl.draw(eidos);
    assertEquals(1, pl.allianceSize());
    pl.discard(eidos);
    assertEquals(0, pl.allianceSize());
  }

  @Test
  public void testHP() {
    final Mage pl = new Mage("Merlin");
    assertEquals(8, pl.getHP());
  }

  @Test
  public void testLoseHP() {
    final Mage pl = new Mage("Merlin");
    pl.loseHP(2);
    assertEquals(6, pl.getHP());
  }
  
  @Test
  public void testIsDead() {
    final Mage pl = new Mage("Merlin");
    pl.loseHP(8);
    assertTrue(pl.isDead());
  }
}