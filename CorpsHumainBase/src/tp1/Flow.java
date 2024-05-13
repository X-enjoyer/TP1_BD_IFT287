package tp1;

import java.util.LinkedList;
import java.util.List;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;

import javax.json.stream.JsonGenerator;

public class Flow {
    private int m_id;
    private String m_name;

    private List<Connectible> m_connectibleList;
    private List<Connections> m_connectionsList;

    public Flow(Attributes l){
        this.setId(Integer.parseInt(l.getValue("id")));
        this.setName(l.getValue("name"));
        this.setName(l.getValue("name"));
        m_connectibleList = new LinkedList<Connectible>();
        m_connectionsList = new LinkedList<Connections>();
    }

    public void addConnectible(Connectible c){
        m_connectibleList.add(c);
    }

    public void addConnections(Connections c){
        m_connectionsList.add(c);
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
        for(Connectible c : m_connectibleList){
            c.toJson(gen);
        }
        gen.writeEnd();
        gen.writeStartArray("connections");
        for(Connections c : m_connectionsList){
            c.toJson(gen);
        }
        gen.writeEnd();
        gen.writeEnd();
    }


}
