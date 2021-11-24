/*
* Title: Feedback 2 Creación archivo XML mediante DOM
* Author: Anas Nali
* Date: 20/10/2021
*/

import java.io.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


public class departamentosXML {

    public static void main(String[] args) {
        try {
            //Creamos un docmuento
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            //El elemento raiz del documento es "departamentos"
            Element eRaiz = doc.createElement("departamentos");
            doc.appendChild(eRaiz);

            //Añadimos los departamentos
            add_departamento(doc, eRaiz, "1", "Atencion al cliente", "Sabadell");
            add_departamento(doc, eRaiz, "2", "Recursos Humanos", "Madrid");
            add_departamento(doc, eRaiz, "3", "IT", "Málaga");
            add_departamento(doc, eRaiz, "4", "I+D+I", "Bilbao");
    
    
                //Estas instancias crean el archivo desde el DOM y obtinenes como resultado el archivo XML
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("departamentos.xml"));
            transformer.transform(source, result);
    
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   

    public static void add_departamento(Document doc, Element root, String id, String nombre, String localidad){
        
        //El elemento departamento pertenece al nodo Departamentos
        Element eDepartamento = doc.createElement("departamento");
        root.appendChild(eDepartamento);


        //Creamos los elementos hijos del nodo padre "Departamento", en este caso id, nombre y localidad son atributos hijo diferentes.
        Attr attr = doc.createAttribute("id");
        attr.setValue(id);
        eDepartamento.setAttributeNode(attr);

        Element eNombre= doc.createElement("nombre");
        eNombre.appendChild(doc.createTextNode(nombre));
        eDepartamento.appendChild(eNombre);

        Element eLocalidad = doc.createElement("localidad");
        eLocalidad.appendChild(doc.createTextNode(localidad));
        eDepartamento.appendChild(eLocalidad);

    }

}
