package tp1;

import javax.json.JsonObject;
import javax.json.stream.JsonGenerator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;

import java.io.FileWriter;

public class To {
    private int m_id;

    public To(Attributes l){
        this.setId(Integer.parseInt(l.getValue("id")));
    }

    public To(JsonObject json){
        this.setId(json.getInt("id"));
    }

    //getter and setter methods
    public int getId() {
        return m_id;
    }

    public void setId(int id) {
        this.m_id = id;
    }

    public void toJson(JsonGenerator gen)
    {
        gen.write("id", m_id);
    }

    public void toXml(Document doc, Element parent){
        Element to = doc.createElement("To");
        parent.appendChild(to);
        to.setAttribute("id", Integer.toString(m_id));
    }
}
