package tp1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.json.*;
import javax.json.stream.JsonGenerator;


import org.w3c.dom.Element;
import org.xml.sax.Attributes;

public class MainBody {
    private String m_bodyName;
    private int m_bodyID;

    private Systems m_systems;

    private Organs m_organs;


    public MainBody(Attributes l) {
        this.setBodyName(l.getValue("bodyName"));
        this.setBodyID(Integer.parseInt(l.getValue("bodyID")));
    }


    public void setSystems(Systems s){
        m_systems = s;
    }

    public void setOrgans(Organs o){
        m_organs = o;
    }

    //getter and setter methods
    public String getBodyName() {
        return m_bodyName;
    }

    public void setBodyName(String bodyName) {
        this.m_bodyName = bodyName;
    }

    public int getBodyID() {
        return m_bodyID;
    }

    public void setBodyID(int bodyID) {
        this.m_bodyID = bodyID;
    }

    public void toJson(JsonGenerator gen) throws IOException {
        gen.writeStartObject();
        gen.write("bodyName", m_bodyName);
        gen.write("bodyID", m_bodyID);
        m_systems.toJson(gen);
        m_organs.toJson(gen);
        gen.writeEnd();
        gen.close();
    }
}
