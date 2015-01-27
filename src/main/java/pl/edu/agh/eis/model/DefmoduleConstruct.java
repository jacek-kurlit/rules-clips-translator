package pl.edu.agh.eis.model;

import pl.edu.agh.eis.converter.Const;

import java.util.ArrayList;
import java.util.List;

public class DefmoduleConstruct extends Construct {

    private String moduleName;
    private List<PortSpecification> portSpecifications = new ArrayList<>();

    public DefmoduleConstruct() {
        super(Const.DEFMODULE);
    }

    public class PortSpecification {
        private String type;
        private String moduleName;
        private String construct;
        private List<String> items = new ArrayList<>();

        public void setType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public List<String> getItems() {
            return items;
        }

        public void addItem(String item) {
            items.add(item);
        }

        public String getModuleName() {
            return moduleName;
        }

        public void setModuleName(String moduleName) {
            this.moduleName = moduleName;
        }

        public String getConstruct() {
            return construct;
        }

        public void setConstruct(String construct) {
            this.construct = construct;
        }
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public List<PortSpecification> getPortSpecifications() {
        return portSpecifications;
    }

    public void addPortSpecification(PortSpecification portSpecification) {
        this.portSpecifications.add(portSpecification);
    }
}
