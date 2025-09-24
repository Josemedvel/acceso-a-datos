package ut1.xml.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EditarDOM {
    public static void main(String[] args) {

        // Cargamos archivo para editar

        Path file = Paths.get("src", "main", "java", "ut1", "xml", "dom", "juegos.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder builder = factory.newDocumentBuilder();

            if(!file.toFile().exists()){
                System.out.println("No existe el fichero!");
                return;
            }

            Document doc = builder.parse(file.toFile());


            // Editar: NodeList
            Element root = doc.getDocumentElement();
            NodeList lista = root.getChildNodes(); // recoge todos los hijos

            for(int i = 0; i < lista.getLength(); i++){
                // Cada nodo tenemos que investigar de qué tipo es
                Node node = lista.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;

                    if(element.getAttribute("title").equals("League Of Legends")){
                        element.setAttribute("title", "LoL");
                        if(element.getElementsByTagName("genre").item(0) != null){
                            element.getElementsByTagName("genre").item(0).setTextContent("Multiplayer Online Battle Arena");
                        }
                    }
                }
            }
            // Escribimos de nuevo el fichero
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            t.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource src = new DOMSource(doc);
            StreamResult result = new StreamResult(file.toFile());

            t.transform(src, result);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
}
