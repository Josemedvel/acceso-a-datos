package ut1.xml.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;


public class LeerDOM {
    public static String leerValorOUnknown(Element e, String tag){
        Node n = e.getElementsByTagName(tag).item(0);
        return n != null ? n.getTextContent() : "UNKNOWN";
    }
    public static void leerClientes(Document doc){
        // Obtenemos todos los clientes
        NodeList lista = doc.getElementsByTagName("customer");
        for(int i = 0; i < lista.getLength(); i++){
            Node nodo = lista.item(i);
            // Miramos que cada elemento sea una ETIQUETA y no texto, por ejemplo
            if(nodo.getNodeType() == Node.ELEMENT_NODE){
                Element cliente = (Element) nodo;
                String id = cliente.getAttribute("id");
                String name = cliente.getElementsByTagName("name").item(0).getTextContent();
                System.out.println("Cliente con id '" + id+"'. Nombre: "+name+" ");
                NodeList direcciones = cliente.getElementsByTagName("address");
                // Recorremos las direcciones del cliente
                for(int j = 0; j < direcciones.getLength(); j++){
                    Node direccionNodo = direcciones.item(j);
                    if(direccionNodo.getNodeType() == Element.ELEMENT_NODE){
                        Element direccionElem = (Element) direccionNodo;
                        String street = leerValorOUnknown(direccionElem, "street");
                        String city = leerValorOUnknown(direccionElem, "city");
                        String state = leerValorOUnknown(direccionElem, "state");
                        String zip = leerValorOUnknown(direccionElem, "zip");
                        System.out.println("\t- Dirección " + j+":\t" + street+ "\t" + city + "\t" + state + "\t" + zip);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        try {
            // Creamos el builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parseamos el archivo XML
            Path ruta = Paths.get("src","main","java","ut1", "xml", "dom", "customers.xml");
            Document doc = builder.parse(ruta.toFile());

            // Limpiamos el documento
            doc.getDocumentElement().normalize();

            // Imprimimos raíz
            System.out.println(doc.getDocumentElement().getNodeName());

            leerClientes(doc);

        }catch(Exception e){
            e.printStackTrace();

        }
    }
}
