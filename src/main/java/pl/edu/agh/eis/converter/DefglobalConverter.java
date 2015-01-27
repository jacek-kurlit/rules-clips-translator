package pl.edu.agh.eis.converter;

import pl.edu.agh.eis.model.Construct;
import pl.edu.agh.eis.model.DefglobalConstruct;
import pl.edu.agh.eis.parser.Node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class DefglobalConverter implements Converter {

    @Override
    public Construct convertParentNode(Node parentNode) {
        List<String> values = parentNode.getValues();
        Map<Integer, String> mapping = mapChildrenToValues(parentNode.getChildren());
        int startIndex = 0;

        DefglobalConstruct defglobalConstruct = new DefglobalConstruct();

        if(hasModuleName(values.size())) {
            defglobalConstruct.setModuleName(values.get(startIndex));
            startIndex++;
        }

        for(int i = startIndex; i < values.size();) {

            String value;
            String expression = values.get(i);

            if(mapping.containsKey(i + 1)) {
                value = mapping.get(i + 1);
                i +=2;
            } else {
                value = values.get(i + 2);
                i+=3;
            }


            defglobalConstruct.addAssignment(expression, value);
        }

        return defglobalConstruct;
    }

    private boolean hasModuleName(int valuesSize) {
        return valuesSize % 3 != 0;
    }

    private Map<Integer, String> mapChildrenToValues(List<Node> children) {
        Map<Integer, String > mapping = new HashMap<>();

        children.forEach(mapToSingleValue(mapping));

        return mapping;
    }


    private Consumer<Node> mapToSingleValue(Map<Integer, String > mapping) {
        return node -> {
            String singleValue = node.getKey() + " " + node.getValues().stream().collect(Collectors.joining(" "));
            mapping.put(node.getValuesSuccession(), singleValue);
        };
    }

}
