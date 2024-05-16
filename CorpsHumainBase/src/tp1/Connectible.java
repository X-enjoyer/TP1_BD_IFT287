package tp1;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.json.stream.JsonGenerator;


public class Connectible {
    private List<Type> m_typeList;

    public Connectible(){
        m_typeList = new LinkedList<Type>();
    }

    public void addType(Type t){
        m_typeList.add(t);
    }

    public void addTypeXml(JsonObject json){
        m_typeList.add(new Type(json));
    }

    public void toJson(JsonGenerator gen)
    {
        for(Type t : m_typeList){
            t.toJson(gen);
        }
    }

    public void toXml(Document doc, Element parent)
    {
        Element connectible = doc.createElement("Connectible");
        parent.appendChild(connectible);
        for(Type t : m_typeList){
            t.toXml(doc, connectible);
        }
    }
}
