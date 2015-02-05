package pl.edu.agh.eis.model;

import pl.edu.agh.eis.converter.Const;

import java.util.ArrayList;
import java.util.List;

public class DeffactsConstruct extends Construct{
    private String name;
    private List<Fact> facts = new ArrayList<>();

    public DeffactsConstruct() {
        super(Const.DEFFACTS);
    }

    public static class Fact {
        private String name;
        private String id;
        private String type;
        private List<Field> fields = new ArrayList<>();

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void addField(String attributeRef, List<String> values, String type) {
            fields.add(new Field(attributeRef, values, type));
        }

        public List<Field> getFields() {
            return fields;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Field {
        private String attributeRef;
        private List<String> values;
        private String type;

        public Field(String name, List<String> values, String type) {
            this.attributeRef = name;
            this.values = values;
            this.type = type;
        }

        public String getAttributeRef() {
            return attributeRef;
        }

        public List<String> getValues() {
            return values;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addFact(Fact fact) {
        facts.add(fact);
    }

    public List<Fact> getFacts() {
        return facts;
    }
}
