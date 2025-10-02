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
import java.util.Scanner;

public class ModificarPorAtributo {
    public static void cumplirAnno(Element gato){
        Element edad = (Element) gato.getElementsByTagName("edad").item(0);
        int edadActual = Integer.parseInt(edad.getTextContent());
        edad.setTextContent(String.valueOf(edadActual + 1));
    }
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = df.newDocumentBuilder();
            Path rutaEnt = Path.of("src", "main", "java", "clasepruebas", "ut1", "mascotas.xml");
            Document doc = db.parse(rutaEnt.toFile());
            Element root = doc.getDocumentElement();
            NodeList listaGatos = root.getElementsByTagName("gato");
            for(int i = 0; i < listaGatos.getLength(); i++){
                Node gato = listaGatos.item(i);
                if(gato != null && gato.getNodeType() == Node.ELEMENT_NODE){
                    Element gatoElem = (Element) gato;
                    if(gatoElem.hasAttribute("codigo-chip") &&
                            gatoElem.getAttribute("codigo-chip").equals("23456235")){
                            cumplirAnno(gatoElem);
                    }
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
