package pl.edu.agh.eis.model;

import pl.edu.agh.eis.converter.Const;
import pl.edu.agh.xsd.Settype;

import java.util.ArrayList;
import java.util.List;

public class DeftemplateContruct extends Construct {
    private String name;
    private String id;
    private List<Slot> slots = new ArrayList<>();

    public DeftemplateContruct() {
        super(Const.DEFTEMPLATE);
    }

    public class Slot {
        private String name;
        private String id;
        private String baseType;
        private String type = "simple";
        private List<String> values = new ArrayList<>();
        private List<Range> ranges = new ArrayList<>();
        private String def;


        public String getBaseType() {
            return baseType;
        }

        public void setBaseType(String baseType) {
            this.baseType = baseType;
        }

        public List<String> getValues() {
            return values;
        }

        public String getDef() {
            return def;
        }

        public void setDef(String def) {
            this.def = def;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public String getType() {
            return type;
        }

        public List<Range> getRanges() {
            return ranges;
        }

        public void addRange(String from , String to) {
            ranges.add(new Range(from, to));
        }
    }

    public class Range {
        private String from;
        private String to;

        public Range(String from, String to) {
            this.from = from;
            this.to = to;
        }

        public String getFrom() {
            return from;
        }

        public String getTo() {
            return to;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.id = name.toLowerCase();
        this.name = name;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public String getId() {
        return id;
    }
}
