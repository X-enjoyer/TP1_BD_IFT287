package tp1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.LinkedList;
import java.util.List;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.json.stream.JsonGenerator;

import java.io.FileWriter;
public class Connections {

    private List<Connection> connectionList;

    public Connections(){
        connectionList = new LinkedList<Connection>();
    }

    public void addConnection(Connection c){
        connectionList.add(c);
    }

    public void addConnectionXml(JsonObject json){
        connectionList.add(new Connection(json));
    }


    public void toJson(JsonGenerator gen)
    {
        for(Connection c : connectionList){
            c.toJson(gen);
        }
    }

    public void toXml(Document doc, Element parent)
    {
        Element connections = doc.createElement("Connections");
        parent.appendChild(connections);
        for(Connection c : connectionList){
            c.toXml(doc, connections);
        }
    }
}
