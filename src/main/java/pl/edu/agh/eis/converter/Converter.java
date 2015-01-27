package pl.edu.agh.eis.converter;

import pl.edu.agh.eis.model.Construct;
import pl.edu.agh.eis.parser.Node;

public interface Converter {
    Construct convertParentNode(Node parentNode);
}
