package francescocicala;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class EvocationManager {
  private final Mage[] mages;
  private final Integer numberOfDrafts;
  private final String pathToXmlFile;

  /**
   * Constructs the EvocationManager.
   * @param pathToXml Relative path to the xml file storing the Eidoi properties.
   * @param numOfDrafts Number of Eidoi to draw for each Mage. Must be less or equal to the half 
   *      of the total Eidoi in the xml file (rounded down).
   */
  public EvocationManager(String pathToXml, Integer numOfDrafts) {
    mages = new Mage[2];
    mages[0] = new Mage();
    mages[1] = new Mage();
    numberOfDrafts = numOfDrafts;
    pathToXmlFile = pathToXml;
  }

  
  /** 
   * Starts the Evocation Phase, where every Mage will draw an alliance.
   * @throws SAXException
   * @throws IOException
   * @throws ParserConfigurationException
   */
  public void startDraft() throws SAXException, IOException, ParserConfigurationException {
    ShuffledDeck deck = new ShuffledDeck(pathToXmlFile);
    for (Integer i = 1; i <= numberOfDrafts; i++) {
      Eidos[] eidoiDraft = deck.draw(2);
      System.out.println("Mage 1 draws " + eidoiDraft[0].showInfoString() + "\nMage 2 draws " 
          + eidoiDraft[1].showInfoString() + "\n");
      mages[0].draw(eidoiDraft[0]);
      mages[1].draw(eidoiDraft[1]);
    }
  }
  
  
  /** 
   * Returns the first Mage.
   * @return Mage
   */
  public Mage getMage1() {
    return mages[0];
  }

  
  /** 
   * Returns the second Mage.
   * @return Mage
   */
  public Mage getMage2() {
    return mages[1];
  }

}
