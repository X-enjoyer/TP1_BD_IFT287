package tp1;

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
}
