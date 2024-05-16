package tp1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;

import javax.json.JsonObject;
import javax.json.stream.JsonGenerator;
public class Connection {
    private int m_id;
    private To m_to;

    public Connection(Attributes l){
        this.setId(Integer.parseInt(l.getValue("id")));
    }

    public Connection(JsonObject json){
        this.setId(json.getInt("id"));
        m_to = new To(json.getJsonObject("to"));
    }

    public void setTo(To to){
        m_to = to;
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
        gen.writeStartObject();
        gen.write("id", m_id);
        gen.writeStartObject("to");
        m_to.toJson(gen);
        gen.writeEnd();
        gen.writeEnd();
    }

    public void toXml(Document doc, Element parent){
        Element connection = doc.createElement("Connection");
        parent.appendChild(connection);
        connection.setAttribute("id", Integer.toString(m_id));
        m_to.toXml(doc, connection);
    }
}
