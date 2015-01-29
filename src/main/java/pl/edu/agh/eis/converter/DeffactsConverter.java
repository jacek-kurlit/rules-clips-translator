package pl.edu.agh.eis.converter;

import pl.edu.agh.eis.model.Construct;
import pl.edu.agh.eis.model.DeffactsConstruct;
import pl.edu.agh.eis.parser.Node;

import java.util.function.Consumer;

public class DeffactsConverter implements Converter {

    @Override
    public Construct convertParentNode(Node parentNode) {
        final DeffactsConstruct deffactsConstruct = new DeffactsConstruct();
        final String name = parentNode.getValues().get(0);
        deffactsConstruct.setName(name);

        parentNode.getChildren().forEach(new Consumer<Node>() {
            @Override
            public void accept(Node node) {
                deffactsConstruct.addFact(convertToFact(node, deffactsConstruct.new Fact(name)));
            }
        });

        return deffactsConstruct;
    }

    private DeffactsConstruct.Fact convertToFact(Node child, final DeffactsConstruct.Fact fact) {
        final String type = child.getKey().toLowerCase();
        fact.setType(type);

        fact.setId(fact.getName().toLowerCase() + "_" + fact.getType().toLowerCase());
        child.getChildren().forEach(n -> fact.addField(type.toLowerCase() + "_" + n.getKey().toLowerCase() , n.getValues(), fact.getType()));

        return fact;
    }
}
