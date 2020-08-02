package francescocicala;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class ShuffledDeck {
  private final EidoiXmlParser xmlParser = new EidoiXmlParser();
  private final Eidos[] eidoiArr;
  private Deque<Eidos> internal;

  /**
   * Construct a ShuffledDeck object containing the Eidoi found in the .xml file at xmlFilename path.
   * @param xmlFilename Relative path to the .xml file
   * @throws SAXException
   * @throws IOException
   * @throws ParserConfigurationException
   */
  ShuffledDeck(final String xmlFilename) throws SAXException, IOException, ParserConfigurationException {
    eidoiArr = xmlParser.getEidoiArr(xmlFilename);
    shuffleDeck();
  }

  /**
   * Reshuffles all the Eidoi in the deck.
   */
  public void shuffleDeck() {
    final Integer[] randomNum = new Integer[eidoiArr.length];
    for (int i = 0; i < randomNum.length; i++) {
      randomNum[i] = i;
    }
    Collections.shuffle(Arrays.asList(randomNum));
    internal = new ArrayDeque<Eidos>();
    for (int i = 0; i < randomNum.length; i++) {
      internal.add(eidoiArr[i]);
    }
  }

  /** 
   * Returns the Integer number of the full deck of Eidoi.
   * @return Integer
   */
  public Integer getFullSize() {
    return eidoiArr.length;
  }

  /** 
   * Returns the Integer number of the Eidoi in the current state of the deck.
   * @return Integer
   */
  public Integer getCurrentSize() {
    return internal.size();
  }

  
  /** 
   * Returns the array containing the drawn Eidoi.
   * @param num Number of Eidoi to draw
   * @return Eidos[]
   */
  public Eidos[] draw(final int num) {
    if (num > getCurrentSize()) {
      throw new IllegalStateException();
    }
    final Eidos[] outArr = new Eidos[num];
      for (int itr = 0; itr < num; itr++) {
        outArr[itr] = internal.poll();
      }
    return outArr;
  }
}