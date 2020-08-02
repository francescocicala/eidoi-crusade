package francescocicala;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class EidoiXmlParser {
  
  public Eidos[] getEidoiArr(String xmlPath)
  throws SAXException, IOException, ParserConfigurationException {
    NodeList nodeList = getEidoiNodeList(xmlPath);
    Eidos[] eidoiArr = new Eidos[nodeList.getLength()];

    for (int itr = 0; itr < nodeList.getLength(); itr++) {
      Node node = nodeList.item(itr);
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element currentElement = (Element) node;
        String name = currentElement.getElementsByTagName("name").item(0).getTextContent();
        Integer attValue = Integer.parseInt(currentElement.getElementsByTagName("attack")
            .item(0).getTextContent());
        Integer defValue = Integer.parseInt(currentElement.getElementsByTagName("defense")
            .item(0).getTextContent());
        eidoiArr[itr] = new Eidos(name, attValue, defValue);
      }
    }
    return eidoiArr;
  }

  public Integer getEidoiNum(String xmlPath) throws ParserConfigurationException, SAXException, IOException {
    NodeList nodeList = getEidoiNodeList(xmlPath);
    return nodeList.getLength();
  }

  private NodeList getEidoiNodeList(String xmlPath) throws ParserConfigurationException, SAXException, IOException {
    File file = new File(xmlPath);
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();  
    Document doc = db.parse(file);
    doc.getDocumentElement().normalize();
    NodeList nodeList = doc.getElementsByTagName("eidos");
    return nodeList;
  }
}