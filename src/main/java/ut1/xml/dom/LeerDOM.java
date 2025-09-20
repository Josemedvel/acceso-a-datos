package ut1.xml.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
import java.io.File;


public class LeerDOM {
    public static void main(String[] args) {
        try {
            // Creamos el builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parseamos el archivo XML
            Document doc = builder.parse(new File("src/main/java/ut1/xml/dom/customers.xml"));
            // Limpiamos el documento
            doc.getDocumentElement().normalize();

            // Imprimimos raíz
            System.out.println(doc.getDocumentElement().getNodeName());

            // Obtenemos todos los clientes
            NodeList lista = doc.getElementsByTagName("customer");
            for(int i = 0; i < lista.getLength(); i++){
                Node nodo = lista.item(i);
                // Miramos que cada elemento sea una ETIQUETA y no texto, por ejemplo
                if(nodo.getNodeType() == Node.ELEMENT_NODE){
                    Element cliente = (Element) nodo;
                    String id = cliente.getAttribute("id");
                    String name = cliente.getElementsByTagName("name").item(0).getTextContent();
                    NodeList direcciones = cliente.getElementsByTagName("address");
                    // falta hacer el bucle de las direcciones
                }
            }
        }catch(Exception e){
            e.printStackTrace();

        }
    }
}
