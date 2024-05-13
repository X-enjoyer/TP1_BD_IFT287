package tp1;

import javax.json.stream.JsonGenerator;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;

public class To {
    private int m_id;

    public To(Attributes l){
        this.setId(Integer.parseInt(l.getValue("id")));
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
}
