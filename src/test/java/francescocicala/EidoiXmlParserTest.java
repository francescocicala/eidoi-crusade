package francescocicala;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

public class EidoiXmlParserTest {
  String pathName = "src/main/java/francescocicala/eidoiPool.xml";

  @Test
  public void testGetEidoiArr() throws SAXException, IOException, ParserConfigurationException {
    EidoiXmlParser eidoiParser = new EidoiXmlParser();
    Eidos[] eidoiArr = eidoiParser.getEidoiArr(pathName);
    assertEquals(10, eidoiArr.length);
  }

  @Test
  public void testGetEidoiNum() throws ParserConfigurationException, SAXException, IOException {
    EidoiXmlParser eidoiParser = new EidoiXmlParser();
    assertEquals(10, eidoiParser.getEidoiNum(pathName));
  }
}