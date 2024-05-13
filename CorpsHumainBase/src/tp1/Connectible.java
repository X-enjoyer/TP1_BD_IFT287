package tp1;

import java.util.LinkedList;
import java.util.List;
import org.w3c.dom.Element;

import javax.json.stream.JsonGenerator;


public class Connectible {
    private List<Type> m_typeList;

    public Connectible(){
        m_typeList = new LinkedList<Type>();
    }

    public void addType(Type t){
        m_typeList.add(t);
    }

    public void toJson(JsonGenerator gen)
    {
        gen.writeStartObject();
        for(Type t : m_typeList){
            t.toJson(gen);
        }
        gen.writeEnd();
    }
}
