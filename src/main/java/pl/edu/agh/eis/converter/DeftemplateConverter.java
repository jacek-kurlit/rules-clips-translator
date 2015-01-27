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
            deftemplateContruct.getSlots().add(convertToSlot(child, deftemplateContruct.new Slot()));
        }

        return deftemplateContruct;
    }

    private DeftemplateContruct.Slot convertToSlot(Node child, DeftemplateContruct.Slot slot) {
        final String name = child.getValues().get(0);
        slot.setName(name);

        child.getChildren().forEach(new Consumer<Node>() {

            @Override
            public void accept(Node node) {
                final String key = node.getKey();
                if(TYPE.equals(key)) {
                  slot.setType(node.getValues().get(0));
                } else if(RANGE.equals(key)) {
                    slot.getValues().add(node.getValues().get(0));
                    slot.getValues().add(node.getValues().get(1));
                    slot.setRange(true);
                } else if (DEFAULT.equals(key)) {
                    slot.setDef(node.getValues().get(0));
                } else if(ALLOWED_SYMBOLS.equals(key)) {
                    for(String value : node.getValues()) {
                        slot.getValues().add(value);
                    }
                }
            }
        });

        return slot;
    }
}
