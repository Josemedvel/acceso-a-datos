package ut1.xml.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

import java.nio.file.Paths;

public class EscribirDOM {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            // Lo que se escribe en los documentos son elementos Element

            Element root = doc.createElement("juegos");
            doc.appendChild(root);

            // generamos información estructurada y lo añadimos al DOM

            Element lol = doc.createElement("juego");
            lol.setAttribute("title", "League of Legends");
            Element launchDate = doc.createElement("launchDate");
            launchDate.setTextContent("26-09-2009");
            lol.appendChild(launchDate);
            Element genre = doc.createElement("genre");
            genre.setTextContent("MOBA");
            lol.appendChild(genre);

            root.appendChild(lol);

            // al escribir el fichero necesitamos el transformer

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();

            // Fuente y resultado

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(Paths.get("src", "main", "java", "ut1", "xml", "dom", "juegos.xml").toFile());

            t.setOutputProperty(OutputKeys.INDENT,"yes");
            t.transform(source, result);

        } catch(ParserConfigurationException e){
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
             e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
