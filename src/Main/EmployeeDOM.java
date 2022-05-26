package Main;

import org.w3c.dom.*;
import javax.xml.parsers.*;

public class EmployeeDOM {
    
    public void Add(String idE, String nombreE, String apellidoE, String tituloE, 
            String divisionE, String buildingE, String roomE){
        try{
            Document d =  DOMHelper.getDocument("src\\Main\\archivo.xml");
            
            Element students = d.getDocumentElement();
            Element student = d.createElement("employee");
            
            //ID
            Element id = d.createElement("id");
            id.appendChild(d.createTextNode(idE));
            student.appendChild(id);
            
            //Nombre
            Element name = d.createElement("firstname");
            name.appendChild(d.createTextNode(nombreE));
            student.appendChild(name);
            
            //Apellido
            Element last = d.createElement("lastname");
            last.appendChild(d.createTextNode(apellidoE));
            student.appendChild(last);
            
            //Title
            Element title = d.createElement("title");
            title.appendChild(d.createTextNode(tituloE));
            student.appendChild(title);
            
            //Division
            Element division = d.createElement("division");
            division.appendChild(d.createTextNode(divisionE));
            student.appendChild(division);
            
            //Building
            Element building = d.createElement("building");
            building.appendChild(d.createTextNode(buildingE));
            student.appendChild(building);
            
            //Room
            Element room = d.createElement("room");
            room.appendChild(d.createTextNode(roomE));
            student.appendChild(room);
            
            students.appendChild(student);
            
            DOMHelper.saveXMLContent(d, "src\\Main\\archivo.xml");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void Delete(String id){
         try {
            Document d =  DOMHelper.getDocument("src\\Main\\archivo.xml");
            NodeList nl = d.getElementsByTagName("employee");
             for (int i = 0; i < nl.getLength(); i++) {
                 Element estudent = (Element) nl.item(i);
                 if(estudent.getElementsByTagName("id").item(0).getTextContent().equals(id)){
                     estudent.getParentNode().removeChild(estudent);
                 }
             }
             DOMHelper.saveXMLContent(d, "src\\Main\\archivo.xml");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
