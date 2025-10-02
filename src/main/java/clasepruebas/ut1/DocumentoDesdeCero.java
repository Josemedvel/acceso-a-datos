package clasepruebas.ut1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.nio.file.Path;
import java.util.Scanner;

public class DocumentoDesdeCero {
    public static Node crearCategoria(String nombre, Document doc, Node root){
        Node nuevaCategoria = doc.createElement(nombre);
        root.appendChild(nuevaCategoria);
        return nuevaCategoria;
    }
    public static Node escribirGato(Document doc, Node root){
        Scanner sc = new Scanner(System.in);
        Node tagGato = doc.createElement("gato");
        Node tagEdad = doc.createElement("edad");
        Node tagSexo = doc.createElement("sexo");
        Node tagNombre = doc.createElement("nombre");



        int edad = 0;
        String nombre = "";
        String sexo = "";
        String codigoChip = "";

        System.out.print("Ingrese un nombre:\t");
        nombre = sc.nextLine().trim();
        System.out.println();
        System.out.print("Ingresa la edad:\t");
        edad = sc.nextInt();
        sc.nextLine();
        System.out.println();
        System.out.print("Ingrese sexo (M/H):");
        sexo = sc.nextLine().trim();
        System.out.print("Ingrese codigo chip (8 caracteres):");
        codigoChip = sc.nextLine().trim();

        tagEdad.setTextContent(String.valueOf(edad));
        tagNombre.setTextContent(nombre);
        tagSexo.setTextContent(sexo);
        if(tagGato.getNodeType() == Node.ELEMENT_NODE){
            Element elemGato = (Element) tagGato;
            elemGato.setAttribute("codigo-chip", codigoChip);
        }

        //añadir etiquetas propias del gato
        tagGato.appendChild(tagNombre);
        tagGato.appendChild(tagEdad);
        tagGato.appendChild(tagSexo);

        //añadir etiqueta de gato al root
        root.appendChild(tagGato);
        return tagGato;
    }
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = df.newDocumentBuilder();
            Document doc = db.newDocument();
            Element root = doc.createElement("mascotas");
            doc.appendChild(root);
            Node categoriaGatos = crearCategoria("Gatos", doc, root);
            escribirGato(doc,categoriaGatos);
            // Toca escribir el fichero
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            DOMSource ds = new DOMSource(doc);
            Path ruta = Path.of("src", "main", "java", "clasepruebas", "ut1", "mascotas.xml");
            StreamResult sr = new StreamResult(ruta.toFile());
            t.transform(ds, sr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
