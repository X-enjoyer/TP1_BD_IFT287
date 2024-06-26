package tp1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import java.io.FileWriter;
import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.LinkedList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.json.stream.JsonGenerator;

public class System {
    public String m_name;
    public int m_id;
    public int m_type;

    public List<Flow> m_flowList;

    public System(Attributes l){
        this.setId(Integer.parseInt(l.getValue("id")));
        this.setName(l.getValue("name"));
        this.setType(Integer.parseInt(l.getValue("type")));
        m_flowList = new LinkedList<Flow>();
    }

    public System(JsonObject json){
        this.setId(json.getInt("id"));
        this.setName(json.getString("name"));
        this.setType(json.getInt("type"));
        m_flowList = new LinkedList<Flow>();
        for(JsonValue v : json.getJsonArray("Flows")){
            m_flowList.add(new Flow((JsonObject)v));
        }
    }

    public void addFlow(Flow f){
        m_flowList.add(f);
    }

    //getter and setter methods
    public String getName() {
        return m_name;
    }

    public void setName(String name) {
        this.m_name = name;
    }

    public int getId() {
        return m_id;
    }

    public void setId(int id) {
        this.m_id = id;
    }

    public int getType() {
        return m_type;
    }

    public void setType(int type) {
        this.m_type = type;
    }

    public void toJson(JsonGenerator gen)
    {
        gen.writeStartObject();
        gen.write("name", m_name);
        gen.write("id", m_id);
        gen.write("type", m_type);
        gen.writeStartArray("Flows");
        for(Flow f : m_flowList){
            f.toJson(gen);
        }
        gen.writeEnd();
        gen.writeEnd();
    }

    public void toXml(Document doc, Element parent){
        Element system = doc.createElement("System");
        parent.appendChild(system);
        system.setAttribute("id", Integer.toString(m_id));
        system.setAttribute("name", m_name);
        system.setAttribute("type", Integer.toString(m_type));
        for(Flow f : m_flowList){
            f.toXml(doc, system);
        }

    }
}




