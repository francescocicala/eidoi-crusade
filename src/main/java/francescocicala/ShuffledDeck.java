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

  ShuffledDeck(final String xmlFilename) throws SAXException, IOException, ParserConfigurationException {
    eidoiArr = xmlParser.getEidoiArr(xmlFilename);
    shuffleDeck();
  }

  private void shuffleDeck() {
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

  public Integer getFullSize() {
    return eidoiArr.length;
  }

  public Integer getCurrentSize() {
    return internal.size();
  }

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