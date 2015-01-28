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
                deffactsConstruct.addFact(convertToFact(node, deffactsConstruct.new Fact()));
            }
        });

        return deffactsConstruct;
    }

    private DeffactsConstruct.Fact convertToFact(Node child, final DeffactsConstruct.Fact fact) {
        fact.setType(child.getKey());

        child.getChildren().forEach(n -> fact.addField(n.getKey(), n.getValues().get(0)));

        return fact;
    }
}
