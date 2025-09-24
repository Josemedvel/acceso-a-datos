package ut1.xml.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

import java.nio.file.Paths;

public class RecorrerDOM {

    // Función recursiva para recorrer en orden
    public static void recorrerNodos(Node nodo, int nivel) {
        // Imprimir indentación para ver jerarquía
        for (int i = 0; i < nivel; i++) {
            System.out.print("\t");
        }

        // Mostrar información del nodo
        System.out.println("Nodo: " + nodo.getNodeName() + " - Valor: " + nodo.getTextContent().trim());

        // Obtener hijos
        NodeList hijos = nodo.getChildNodes();
        for (int i = 0; i < hijos.getLength(); i++) {
            Node hijo = hijos.item(i);
            // Evitar nodos de tipo texto vacío o saltos de línea
            if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                recorrerNodos(hijo, nivel + 1);
            }
        }
    }

    public static void main(String[] args) {
        try {
            // Cargar el XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(Paths.get("src", "main","java", "ut1", "xml", "dom", "customers.xml").toFile());

            // Limpiar el documento
            doc.getDocumentElement().normalize();

            // Obtener el nodo raíz
            Element root = doc.getDocumentElement();

            // Llamar a la función recursiva
            recorrerNodos(root, 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
