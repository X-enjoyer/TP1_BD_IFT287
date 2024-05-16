package tp1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.json.*;
import javax.json.stream.JsonGenerator;


public class Organs {
    private List<Organ> organList;
    public Organs() {
        organList = new LinkedList<Organ>();
    }

    public Organs(JsonArray json){
        organList = new LinkedList<Organ>();
        for(JsonValue v : json){
            organList.add(new Organ((JsonObject)v));
        }
    }

    public void addOrgan(Organ o){
        organList.add(o);
    }

    public void toJson(JsonGenerator gen) {
        gen.writeStartArray("Organs");
        for(Organ o : organList){
            o.toJson(gen);
        }
        gen.writeEnd();
    }

    public void toXml(Document doc, Element parent) {
        Element organs = doc.createElement("Organs");
        parent.appendChild(organs);
        for(Organ o : organList){
            o.toXml(doc, organs);
        }
    }
}
