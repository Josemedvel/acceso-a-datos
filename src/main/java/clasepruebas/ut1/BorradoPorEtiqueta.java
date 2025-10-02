package clasepruebas.ut1;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.nio.file.Path;

public class BorradoPorEtiqueta {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory ft = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = ft.newDocumentBuilder();
            Path archivo = Path.of("src", "main", "java", "clasepruebas", "ut1", "liga.xml");
            Document doc = db.parse(archivo.toFile());
            // ya tenemos el documento creado

            NodeList nombres = doc.getElementsByTagName("nombre");
            for(int i = 0; i < nombres.getLength(); i++){
                Node nombre = nombres.item(i);
                if(nombre != null && nombre.getNodeType() == Node.ELEMENT_NODE){
                    if(nombre.getTextContent().equals("Real Valladolid")){
                        Node equipo = nombre.getParentNode();
                        Node equipos = equipo.getParentNode();
                        equipos.removeChild(equipo);
                    }
                }else{
                    System.out.println("El nodo no existe");
                }
            }

            // ya tenemos modificado el fichero, hay que guardarlo
            Path archivo_nuevo = archivo.resolveSibling("liga_mod.xml");
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            DOMSource ds = new DOMSource(doc);
            StreamResult sr = new StreamResult(archivo_nuevo.toFile());
            t.transform(ds, sr);
            // ya habríamos escrito el fichero

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
