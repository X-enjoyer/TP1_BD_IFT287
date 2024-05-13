package tp1;

import org.w3c.dom.Element;
import org.xml.sax.Attributes;

import javax.json.stream.JsonGenerator;

public class Type {
    private String m_name;
    private int m_id;
    private float m_volume = 0;
    private float m_length = 0;
    private float m_startRadius = 0;
    private float m_endRadius = 0;
    private String m_typeName;

    public Type(Attributes l, String typeName){
        this.setId(Integer.parseInt(l.getValue("id")));
        this.setName(l.getValue("name"));
        if (l.getIndex("volume") != -1)
            this.setVolume(Float.parseFloat(l.getValue("volume")));
        if (l.getIndex("length") != -1)
            this.setLength(Float.parseFloat(l.getValue("length")));
        if (l.getIndex("startRadius") != -1)
            this.setStartRadius(Float.parseFloat(l.getValue("startRadius")));
        if (l.getIndex("endRadius") != -1)
            this.setEndRadius(Float.parseFloat(l.getValue("endRadius")));
        this.setTypeName(typeName);
    }

    public void toJson(JsonGenerator gen)
    {
        gen.writeStartObject(m_typeName);
        gen.write("id", m_id);
        gen.write("name", m_name);
        if (m_volume != 0)
            gen.write("volume", m_volume);
        if (m_length != 0)
            gen.write("length", m_length);
        if (m_startRadius != 0)
            gen.write("startRadius", m_startRadius);
        if (m_endRadius != 0)
            gen.write("endRadius", m_endRadius);
        gen.writeEnd();
    }
    //getters and setters

    public String getName() {
        return m_name;
    }

    public void setName(String name) {
        this.m_name = name;
    }

    public Integer getId() {
        return m_id;
    }

    public void setId(Integer id) {
        this.m_id = id;
    }

    public float getVolume() {
        return m_volume;
    }

    public void setVolume(float volume) {
        this.m_volume = volume;
    }

    public float getLength() {
        return m_length;
    }

    public void setLength(float length) {
        this.m_length = length;
    }

    public float getStartRadius() {
        return m_startRadius;
    }

    public void setStartRadius(float startRadius) {
        this.m_startRadius = startRadius;
    }

    public float getEndRadius() {
        return m_endRadius;
    }

    public void setEndRadius(float endRadius) {
        this.m_endRadius = endRadius;
    }

    public String getTypeName() {
        return m_typeName;
    }

    public void setTypeName(String TypeName) {
        this.m_typeName = TypeName;
    }
}
