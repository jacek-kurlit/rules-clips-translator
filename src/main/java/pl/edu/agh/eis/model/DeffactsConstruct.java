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

    public class Fact {
        private String type;
        private List<Field> fields = new ArrayList<>();

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void addField(String name, String value) {
            fields.add(new Field(name, value));
        }

        public List<Field> getFields() {
            return fields;
        }
    }

    public class Field {
        private String name;
        private String value;

        public Field(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
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
