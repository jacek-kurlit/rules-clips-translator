package pl.edu.agh.eis.parser;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String key;
    private List<String> values = new ArrayList<String>();
    private List<Node> children = new ArrayList<Node>();

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getValues() {
        return values;
    }

    public void addValue(String value) {
        values.add(value);
    }

    public List<Node> getChildren() {
        return children;
    }

    public void addChild(Node child) {
        children.add(child);
    }
}
