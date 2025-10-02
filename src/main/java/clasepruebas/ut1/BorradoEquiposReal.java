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
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BorradoEquiposReal {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory ft = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = ft.newDocumentBuilder();
            Path archivo = Path.of("src", "main", "java", "clasepruebas", "ut1", "liga.xml");
            Document doc = db.parse(archivo.toFile());
            // ya tenemos el documento creado
            Node equipos = null;
            NodeList nombres = doc.getElementsByTagName("nombre");
            List<Node> aBorrar = new ArrayList<Node>();
            System.out.println(nombres.getLength());
            for(int i = 0; i < nombres.getLength(); i++){
                Node nombre = nombres.item(i);
                if(nombre != null && nombre.getNodeType() == Node.ELEMENT_NODE){
                    System.out.println(nombre.getTextContent().toLowerCase(Locale.ROOT));
                    if(nombre.getTextContent().toLowerCase(Locale.ROOT).contains("real")){
                        Node equipo = nombre.getParentNode();
                        aBorrar.add(equipo);
                    }
                }else{
                    System.out.println("El nodo no existe");
                }
            }
            equipos = aBorrar.getFirst().getParentNode();
            for(int i = 0; i < aBorrar.size(); i++){
                equipos.removeChild(aBorrar.get(i));
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
