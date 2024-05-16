package tp1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.json.stream.JsonGenerator;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;

public class Systems {
    private List<System> m_systemList;

    public Systems(){
        m_systemList = new LinkedList<System>();
    }

    public Systems(JsonArray json){
        m_systemList = new LinkedList<System>();
        for(JsonValue v : json){
            m_systemList.add(new System((JsonObject)v));
        }
    }

    public void addSystem(System s){
        m_systemList.add(s);
    }

    public void toJson(JsonGenerator gen){
        gen.writeStartArray("Systems");
        for(System s : m_systemList){
            s.toJson(gen);
        }
        gen.writeEnd();
    }

    public void toXml(Document doc, Element parent){
        Element systems = doc.createElement("Systems");
        parent.appendChild(systems);
        for(System s : m_systemList){
            s.toXml(doc, systems);
        }
    }
}
