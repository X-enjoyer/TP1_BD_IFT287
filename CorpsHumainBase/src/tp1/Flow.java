package tp1;

import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;
import javax.json.JsonValue;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import javax.json.JsonObject;
import javax.json.stream.JsonGenerator;

public class Flow {
    private int m_id;
    private String m_name;

    private List<Connections> m_connectionsList;
    private Connections m_connections;
    private Connectible m_connectible;

    public Flow(Attributes l){
        this.setId(Integer.parseInt(l.getValue("id")));
        this.setName(l.getValue("name"));
        this.setName(l.getValue("name"));
        m_connectible = new Connectible();
        m_connections = new Connections();
    }

    public Flow(JsonObject json){
        this.setId(json.getInt("id"));
        this.setName(json.getString("name"));
        m_connectible = new Connectible();
        m_connections = new Connections();
        for (JsonValue v : json.getJsonArray("connectibles")){
            m_connectible.addTypeXml((JsonObject)v);
        }
        for (JsonValue v : json.getJsonArray("connections")){
            m_connections.addConnectionXml((JsonObject) v);
        }
    }

    public void setConnectible(Connectible c){
        m_connectible = c;
    }

    public void setConnections(Connections c){
        m_connections = c;
    }


    //getter and setter methods
    public int getId() {
        return m_id;
    }

    public void setId(int id) {
        this.m_id = id;
    }

    public String getName() {
        return m_name;
    }

    public void setName(String name) {
        this.m_name = name;
    }

    public void toJson(JsonGenerator gen)
    {
        gen.writeStartObject();
        gen.write("id", m_id);
        gen.write("name", m_name);
        gen.writeStartArray("connectibles");
        m_connectible.toJson(gen);
        gen.writeEnd();
        gen.writeStartArray("connections");
        m_connections.toJson(gen);
        gen.writeEnd();
        gen.writeEnd();
    }

    public void toXml(Document doc, Element parent){
        Element flow = doc.createElement("Flow");
        parent.appendChild(flow);
        flow.setAttribute("id", Integer.toString(m_id));
        flow.setAttribute("name", m_name);
        m_connectible.toXml(doc, flow);
        m_connections.toXml(doc, flow);
    }


}
