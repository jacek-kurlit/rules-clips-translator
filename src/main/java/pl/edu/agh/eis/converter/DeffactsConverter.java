package pl.edu.agh.eis.converter;

import pl.edu.agh.eis.model.Construct;
import pl.edu.agh.eis.model.DeffactsConstruct;
import pl.edu.agh.eis.parser.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DeffactsConverter implements Converter {

    public static final String QUOTE_STRING = "\"";

    @Override
    public Construct convertParentNode(Node parentNode) {
        final DeffactsConstruct deffactsConstruct = new DeffactsConstruct();
        final String parentName = parentNode.getValues().get(0);
        deffactsConstruct.setName(parentName);

        int index = 1;
        for(Node child : parentNode.getChildren()) {
            deffactsConstruct.addFact(convertToFact(child, parentName.toLowerCase(), index));
            index++;
        }

        return deffactsConstruct;
    }

    private DeffactsConstruct.Fact convertToFact(Node child, String parentName, int index) {
        final String type = child.getKey().toLowerCase();

        DeffactsConstruct.Fact fact = new DeffactsConstruct.Fact();
        fact.setType(type);
        fact.setId(parentName + "_" + type + "_" + index);
        fact.setName(parentName + "_" + type);

        if(!child.getChildren().isEmpty()) {
            child.getChildren().forEach(n -> fact.addField(type.toLowerCase() + "_" + n.getKey().toLowerCase(), filterQuotedValues(n.getValues()), fact.getType()));
        } else if(!child.getValues().isEmpty()) {
            fact.addField("global_variable_value", child.getValues(), "global_variable");
        }

        return fact;
    }

    private List<String> filterQuotedValues(List<String> values) {
        List<String> filteredValues = new ArrayList<>();

        boolean quoted = false;
        StringBuilder sb = new StringBuilder();

        for(String value : values) {
            if(!quoted && !value.contains(QUOTE_STRING)) {
                filteredValues.add(value);
            } else{
                sb.append(value + " ");
                if(!quoted && value.startsWith(QUOTE_STRING)) {
                    quoted = true;
                } else if(quoted && value.endsWith(QUOTE_STRING)) {
                    quoted = false;
                    filteredValues.add(sb.toString().trim());
                    sb = new StringBuilder();
                }
            }
        }

        if(sb.length() != 0) {
            filteredValues.add(sb.toString().trim());
        }

        return filteredValues;
    }
}
