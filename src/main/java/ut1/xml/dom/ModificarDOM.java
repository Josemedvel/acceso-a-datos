package ut1.xml.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.dom.DOMSource;

import org.w3c.dom.*;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ModificarDOM {

    public static void borrarDireccion(int posicion, Document doc){
        NodeList lista = doc.getElementsByTagName("address");
        Node nodo = lista.item(posicion);
        if(nodo == null || nodo.getNodeType() != Node.ELEMENT_NODE) {
            System.out.println("No existe la dirección " + posicion);
            return;
        }
        Element direccion = (Element) nodo;
        // borramos la dirección
        Node parent = direccion.getParentNode();
        parent.removeChild(direccion);
    }

    public static void main(String[] args) {
        try{
            // Creamos el builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parseamos el archivo XML
            Path ruta = Paths.get("src", "main", "java", "ut1", "xml", "dom", "customers.xml");
            Document doc = builder.parse(ruta.toFile());

            // Limpiamos el documento
            doc.getDocumentElement().normalize();

            // Borramos la primera dirección
            borrarDireccion(23, doc);

            // Reescribimos el fichero
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(ruta.resolveSibling("customers_borrado.xml").toFile());
            transformer.transform(source, result);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
