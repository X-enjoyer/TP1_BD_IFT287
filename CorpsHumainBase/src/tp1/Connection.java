package tp1;

import org.w3c.dom.Element;
import org.xml.sax.Attributes;

import javax.json.stream.JsonGenerator;

public class Connection {
    private int m_id;
    private To m_to;

    public Connection(Attributes l){
        this.setId(Integer.parseInt(l.getValue("id")));
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
}
