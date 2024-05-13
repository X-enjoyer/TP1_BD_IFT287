package tp1;

import javax.json.stream.JsonGenerator;
import java.util.LinkedList;
import java.util.List;

public class Systems {
    private List<System> m_systemList;

    public Systems(){
        m_systemList = new LinkedList<System>();
    }

    public void addSystem(System s){
        m_systemList.add(s);
    }

    public void toJson(JsonGenerator gen){
        gen.writeStartArray("Systems");
        for(System s : m_systemList){
            s.toJson(gen);
        }
        gen.writeEnd();
    }

}
