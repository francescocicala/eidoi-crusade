package francescocicala;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EidosTest {
  String name = "Sigfried";
  int attack = 4;
  int defense = 3;
  Eidos eidos = new Eidos(name, attack, defense);

  @Test
  public void correctName() {
    assertEquals(name, eidos.getName());
  }

  @Test
  public void correctAtt() {
    assertEquals(attack, eidos.getAtt());
  }

  @Test
  public void correctDef() {
    assertEquals(defense, eidos.getDef());
  }

  @Test
  public void correctInfoString() {
    assertEquals(eidos.showInfoString(), "Sigfried | ATT: 4 | DEF: 3");
  }
}