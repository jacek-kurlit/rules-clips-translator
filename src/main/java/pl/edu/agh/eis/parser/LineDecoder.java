package pl.edu.agh.eis.parser;

import java.util.LinkedList;

public class LineDecoder {
    private LinkedList<Node> context;
    private Node parent = null;

    public LineDecoder() {
        context = new LinkedList<Node>();
    }

    public boolean isParentNodeReady() {
        return parent != null;
    }

    public Node getParentNode() {
        Node temp = parent;
        parent = null;

        return temp;
    }

    public void decodeLine(String line) {
        String[] params = line.split(" ");
        for(String param : params) {
            if(isNodeParam(param)) {
                createNode(param);
            } else {
                if(hasEndingParam(param)) {
                    int endingBracket = param.indexOf(')');
                    String value = param.substring(0, endingBracket);
                    addValueIfNotEmpty(value);
                    closeNodes(param);
                } else {
                    addValueIfNotEmpty(param);
                }

            }
        }
    }

    private void closeNodes(String param) {
        int occurrence = -1;
        while((occurrence = param.indexOf(')', occurrence + 1)) != -1) {
            closeNode();
        }
    }

    private void addValueIfNotEmpty(String value) {
        int bracketPos = value.indexOf('(');

        if(bracketPos != -1) {
            String realValue = value.substring(0, bracketPos);
            String key = value.substring(bracketPos);
            addValueIfNotEmpty(realValue);
            createNode(key);
        } else if(!value.trim().isEmpty()) {
            context.getLast().addValue(value);
        }
    }

    private Node closeNode() {
        if(context.size() == 1) {
            parent = context.getLast();
        }
        return context.pollLast();
    }

    private boolean isNodeParam(String param) {
        return param.startsWith("(");
    }

    private boolean hasEndingParam(String param) {
        return param.endsWith(")");
    }

    private String nodeKey(String param) {
        return param.substring(1);
    }

    private void createNode(String param) {
        Node node = new Node();
        boolean hasEndingParam = hasEndingParam(param);
        //remove first bracket
        String key = nodeKey(param);

        if(hasEndingParam) {
            //remove last bracket
            key = key.substring(0, key.length());
        }

        node.setKey(key);

        //add if there is any parent
        if(!context.isEmpty()) {
            context.getLast().addChild(node);
        }

        //skip adding if param is already closed
        if(!hasEndingParam(param)) {
            context.add(node);
        }
    }
}
