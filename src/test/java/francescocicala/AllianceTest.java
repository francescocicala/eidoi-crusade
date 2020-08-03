package francescocicala;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AllianceTest {
  Eidos sigfried = new Eidos("Sigfried", 4, 3);
  Eidos hanzo = new Eidos("Hattori Hanzo", 3, 5);
  Eidos sandokan = new Eidos("Sandokan", 5, 1);
  Eidos drake = new Eidos("Francis Drake", 3, 3);

  @Test
  public void testIsEmpty() {
    Alliance alliance = new Alliance();
    assertTrue(alliance.isEmpty());
  }

  @Test
  public void testAddEidos() {
    Alliance alliance = new Alliance();
    alliance.addEidos(sandokan);
    assertEquals(1, alliance.cardinality());
  }

  @Test
  public void testContains() {
    Alliance alliance = new Alliance();
    alliance.addEidos(drake);
    assertTrue(alliance.contains(drake));
  }

  @Test
  public void testCardinality() {
    Alliance alliance = new Alliance();
    alliance.addEidos(sandokan);
    alliance.addEidos(hanzo);
    assertEquals(2, alliance.cardinality());
  }

  @Test
  public void testDoubleAddIgnored() {
    Alliance alliance = new Alliance();
    alliance.addEidos(sandokan);
    alliance.addEidos(sandokan);
    assertEquals(1, alliance.cardinality());
  }

  @Test
  public void testRemoveEidos() {
    Alliance alliance = new Alliance();
    alliance.removeEidos(sigfried);
    assertTrue(alliance.cardinality() == 0);
    
    alliance.addEidos(sigfried);
    alliance.addEidos(drake);
    alliance.removeEidos(sigfried);
    assertFalse(alliance.contains(sigfried));
  }
}