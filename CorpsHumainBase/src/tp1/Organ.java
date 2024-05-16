package tp1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.json.JsonObject;
import javax.json.stream.JsonGenerator;
import org.xml.sax.Attributes;

import java.io.FileWriter;


public class Organ {
    private String m_name;
    private int m_id;
    private int m_systemId;

    public Organ(Attributes l){
        this.setId(Integer.parseInt(l.getValue("id")));
        this.setName(l.getValue("name"));
        this.setSystemId(Integer.parseInt(l.getValue("systemID")));
    }

    public Organ(JsonObject json){
        this.setId(json.getInt("id"));
        this.setName(json.getString("name"));
        this.setSystemId(json.getInt("systemId"));
    }

    //getters and setters
    public String getName() {
        return m_name;
    }

    public void setName(String name) {
        this.m_name = name;
    }

    public Integer getId() {
        return m_id;
    }

    public void setId(Integer id) {
        this.m_id = id;
    }

    public Integer getSystemId() {
        return m_systemId;
    }

    public void setSystemId(Integer systemId) {
        this.m_systemId = systemId;
    }

    public void toJson(JsonGenerator gen)
    {
        gen.writeStartObject();
        gen.write("id", m_id);
        gen.write("name", m_name);
        gen.write("systemId", m_systemId);
        gen.writeEnd();
    }

    public void toXml(Document doc, Element parent){
        Element organ = doc.createElement("Organ");
        parent.appendChild(organ);
        organ.setAttribute("id", Integer.toString(m_id));
        organ.setAttribute("name", m_name);
        organ.setAttribute("systemID", Integer.toString(m_systemId));
    }
}
