package pl.edu.agh.eis.model;

import pl.edu.agh.eis.converter.Const;

import java.util.ArrayList;
import java.util.List;

public class DeftemplateContruct extends Construct {
    private String name;
    private List<Slot> slots = new ArrayList<>();

    public DeftemplateContruct() {
        super(Const.DEFTEMPLATE);
    }

    public class Slot {
        private String name;
        private String type;
        private boolean isRange = false;
        private List<String> values = new ArrayList<>();
        private String def;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
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

        public boolean isRange() {
            return isRange;
        }

        public void setRange(boolean isRange) {
            this.isRange = isRange;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Slot> getSlots() {
        return slots;
    }
}
