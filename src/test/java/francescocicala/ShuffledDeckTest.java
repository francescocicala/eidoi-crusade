package francescocicala;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

public class ShuffledDeckTest {
  String xmlFilename = "src/main/java/francescocicala/eidoiPool.xml";
  
  @Test
  public void testDraw2() throws SAXException, IOException, ParserConfigurationException {
    ShuffledDeck deck = new ShuffledDeck(xmlFilename);
    Eidos[] drawArray = deck.draw(2);
    assertEquals(2, drawArray.length);
  }

  @Test
  public void testDrawEidoi() throws SAXException, IOException, ParserConfigurationException {
    ShuffledDeck deck = new ShuffledDeck(xmlFilename);
    Eidos[] drawArray = deck.draw(2);
    assertTrue((drawArray[0] instanceof Eidos) && (drawArray[1] instanceof Eidos));
  }
}