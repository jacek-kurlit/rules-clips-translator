package pl.edu.agh.eis.converter;

import pl.edu.agh.eis.model.DeftemplateContruct;
import pl.edu.agh.eis.parser.Node;

import java.util.function.Consumer;

public class DeftemplateConverter implements Converter {
    private static final String TYPE = "type";
    private static final String RANGE = "range";
    private static final String DEFAULT = "default";
    private static final String ALLOWED_SYMBOLS = "allowed-symbols";

    @Override
    public DeftemplateContruct convertParentNode(Node parentNode) {
        final String name = parentNode.getValues().get(0);
        DeftemplateContruct deftemplateContruct = new DeftemplateContruct();
        deftemplateContruct.setName(name);

        for(Node child : parentNode.getChildren()) {
            convertToSlot(child, deftemplateContruct);
        }

        return deftemplateContruct;
    }

    private void convertToSlot(Node child, DeftemplateContruct deftemplateContruct) {
        DeftemplateContruct.Slot slot = deftemplateContruct.new Slot();
        final String name = child.getValues().get(0);
        slot.setName(name);
        slot.setId(deftemplateContruct.getName().toLowerCase() + "_" + name.toLowerCase());
        child.getChildren().forEach(new Consumer<Node>() {

            @Override
            public void accept(Node node) {
                final String key = node.getKey();
                if(TYPE.equals(key)) {
                  slot.setBaseType(convertBaseType(node.getValues().get(0)));
                } else if(RANGE.equals(key)) {
                    slot.addRange(node.getValues().get(0), node.getValues().get(1));
                } else if (DEFAULT.equals(key)) {
                    slot.setDef(node.getValues().get(0));
                } else if(ALLOWED_SYMBOLS.equals(key)) {
                    for(String value : node.getValues()) {
                        slot.getValues().add(value);
                    }
                }
            }
        });

        deftemplateContruct.getSlots().add(slot);
    }

    private String convertBaseType(String baseType) {
        if(baseType.equalsIgnoreCase("integer")) {
            return "Integer";
        }

        if(baseType.equalsIgnoreCase("float")) {
            return "Decimal";
        }

        if(baseType.equalsIgnoreCase("number")) {
            return "Decimal";
        }

        return "String";
    }
}
