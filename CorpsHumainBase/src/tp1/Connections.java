package tp1;

import org.w3c.dom.Element;

import java.util.LinkedList;
import java.util.List;
import javax.json.stream.JsonGenerator;
public class Connections {

    private List<Connection> connectionList;

    public Connections(){
        connectionList = new LinkedList<Connection>();
    }

    public void addConnection(Connection c){
        connectionList.add(c);
    }


    public void toJson(JsonGenerator gen)
    {
        for(Connection c : connectionList){
            c.toJson(gen);
        }
    }
}
