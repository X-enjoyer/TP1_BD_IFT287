package tp1;

import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class HumanBodyHandler extends DefaultHandler {

    private MainBody mainBody;
    private Systems systems;
    private System system;
    private Organs organs;
    private Organ organ;
    private Flow flow;
    private Connectible connectible;
    private Connections connections;
    private Connection connection;
    public HumanBodyHandler() {
    }

    public MainBody getMainBody() {
        return mainBody;
    }

    @Override
    public void startDocument(){
        java.lang.System.out.println("Start Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {

        //switch case for each element
        switch (qName) {
            case "MainBody":
                mainBody = new MainBody(attrs);
                break;
            case "Systems":
                systems = new Systems();
                mainBody.setSystems(systems);
                break;
            case "System":
                system = new System(attrs);
                systems.addSystem(system);
                break;
            case "Organs":
                organs = new Organs();
                mainBody.setOrgans(organs);
                break;
            case "Organ":
                organ = new Organ(attrs);
                organs.addOrgan(organ);
                break;
            case "Flow":
                flow = new Flow(attrs);
                system.addFlow(flow);
                break;
            case "Connectible":
                connectible = new Connectible();
                flow.setConnectible(connectible);
                break;
            case "Connections":
                connections = new Connections();
                flow.setConnections(connections);
                break;
            case "Connection":
                connection = new Connection(attrs);
                connections.addConnection(connection);
                break;
            case "to":
                To to = new To(attrs);
                connection.setTo(to);
                break;
            default:
                Type type = new Type(attrs, qName);
                connectible.addType(type);
                break;
        }
    }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        java.lang.System.out.println("End Element :" + qName);
    }
    public void endDocument() {
        java.lang.System.out.println("End Document");
    }
}
