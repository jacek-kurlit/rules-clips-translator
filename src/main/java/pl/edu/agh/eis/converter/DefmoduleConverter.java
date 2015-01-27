package pl.edu.agh.eis.converter;

import pl.edu.agh.eis.model.Construct;
import pl.edu.agh.eis.model.DefmoduleConstruct;
import pl.edu.agh.eis.parser.Node;

import java.util.List;

public class DefmoduleConverter implements  Converter {
    private static final String IMPORT = "import";
    private static final String ALL = "?ALL";
    private static final String NONE = "?NONE";

    @Override
    public Construct convertParentNode(Node parentNode) {
        DefmoduleConstruct defmoduleConstruct = new DefmoduleConstruct();
        defmoduleConstruct.setModuleName(parentNode.getValues().get(0));

        for(Node child : parentNode.getChildren()) {
            defmoduleConstruct.addPortSpecification(convertToPortSpecification(child, defmoduleConstruct.new PortSpecification()));
        }

        return defmoduleConstruct;
    }

    private DefmoduleConstruct.PortSpecification convertToPortSpecification(Node child, DefmoduleConstruct.PortSpecification portSpecification) {
        List<String> values = child.getValues();

        String type = child.getKey();
        portSpecification.setType(type);

        int lastIndex = 0;
        String construct = null;

        //if import type then add mandatory module name
        if(IMPORT.equals(type)) {
            portSpecification.setModuleName(values.get(lastIndex));
            lastIndex++;
        }

        String value = values.get(lastIndex);

        //if it has construct add it
        if(!ALL.equals(value) && !NONE.equals(value)) {
            portSpecification.setConstruct(value);
            lastIndex++;
        }

        for(int i = lastIndex; i < values.size(); i++) {
            portSpecification.addItem(values.get(i));
        }

        return portSpecification;
    }
}
