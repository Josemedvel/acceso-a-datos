package clasepruebas.ut1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.nio.file.Path;
import java.util.ArrayList;

public class BuscarAtributoGeneral {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = df.newDocumentBuilder();
            Path rutaEnt = Path.of("src", "main", "java", "clasepruebas", "ut1", "mascotas.xml");
            Document doc = db.parse(rutaEnt.toFile());
            Element root = doc.getDocumentElement();

            // buscar animales que hayan ingresado el mismo día
            String fechaObjetivo = "2024-01-18";
            NodeList animales = root.getChildNodes();
            ArrayList<Node> listaAnimales = new ArrayList<>();
            for(int i = 0; i < animales.getLength(); i++){
                Node nodo = animales.item(i);
                if(nodo != null && nodo.getNodeType() == Node.ELEMENT_NODE){
                    Element nodoElem = (Element) nodo;

                }

            }
            // Toca escribir el fichero
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            DOMSource ds = new DOMSource(doc);
            Path rutaSal = rutaEnt.resolveSibling("mascotas_mod.xml");
            StreamResult sr = new StreamResult(rutaSal.toFile());
            t.transform(ds, sr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
