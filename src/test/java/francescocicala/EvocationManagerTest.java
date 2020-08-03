package francescocicala;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

public class EvocationManagerTest {
  String pathToXml = "src/main/java/francescocicala/eidoiPool.xml";
  Integer numOfDrafts = 4;
  private EvocationManager em = new EvocationManager(pathToXml, numOfDrafts);

  @Test
  public void testDrafts() throws SAXException, IOException, ParserConfigurationException {
    em.startDraft();
    Mage mage1 = em.getMage1();
    Mage mage2 = em.getMage2();
    System.out.println(mage1.allianceString());
    System.out.println(mage2.allianceString());
    assertEquals(numOfDrafts, mage1.allianceSize());
    assertEquals(numOfDrafts, mage2.allianceSize());
  }
}