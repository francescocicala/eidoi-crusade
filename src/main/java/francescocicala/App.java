package francescocicala;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class App {
  public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
    String pathToXml = "src/main/java/francescocicala/eidoiPool.xml";
    Integer numOfDrafts = 4;
    Mage mage1;
    Mage mage2;

    System.out.println("EIDOI CRUSADE");
    EvocationManager em = new EvocationManager(pathToXml, numOfDrafts);
    em.startDraft();
    mage1 = em.getMage1();
    mage2 = em.getMage2();

    CrusadeManager cm = new CrusadeManager(mage1, mage2);
    cm.startCrusade();
  }
}