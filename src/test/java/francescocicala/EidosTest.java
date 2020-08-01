package francescocicala;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class EidosTest {
    @Test
    public void correctAtt(){
        int attack = 4, defense = 3;
        Eidos eidos = new Eidos(attack, defense);
        assertEquals(attack, eidos.getAtt());
    }

    @Test
    public void correctDef(){
        int attack = 4, defense = 3;
        Eidos eidos = new Eidos(attack, defense);
        assertEquals(defense, eidos.getDef());
    }
}