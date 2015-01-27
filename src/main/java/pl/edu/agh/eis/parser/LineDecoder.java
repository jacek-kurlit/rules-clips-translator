package pl.edu.agh.eis.parser;

import java.util.LinkedList;

public class LineDecoder {
    private static final String ASSIGNMENT_SIGN = "=";

    private LinkedList<Node> context;
    private Node parent = null;

    public LineDecoder() {
        context = new LinkedList<>();
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
        int processedSize = 0;
        for(String param : params) {
            processedSize += param.length();
            if(isNodeParam(param)) {
                createNode(param);
            } else if(hasEndingParam(param)) {
                int endingBracket = param.indexOf(')');
                String value = param.substring(0, endingBracket);
                addValueIfNotEmpty(value);
                String otherValues = closeNodes(param);
                addValueIfNotEmpty(otherValues);
            } else {
                addValueIfNotEmpty(param);
            }
        }
    }

    private boolean isAssignmentParam(String param) {
        return ASSIGNMENT_SIGN.equals(param);
    }

    private String closeNodes(String param) {
        String otherValues = "";
        int occurrence = -1;
        while((occurrence = param.indexOf(')', occurrence + 1)) != -1) {
            if(occurrence < param.length()) {
                otherValues = param.substring(occurrence);
            }
            closeNode();
        }

        if(otherValues.equals(")")) {
            return "";
        }

        return otherValues;
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

    private void createNode(String param) {
        Node node = new Node();
        boolean hasEndingParam = hasEndingParam(param);
        //remove first bracket
        String key = nodeKey(param, hasEndingParam);

        if(hasEndingParam) {
            //remove last bracket
            key = key.substring(0, key.length());
        }

        node.setKey(key);

        //add if there is any parent
        if(!context.isEmpty()) {
            Node parent = context.getLast();
            node.setValuesSuccession(parent.getValues().size() - 1);

            parent.addChild(node);
        }

        context.add(node);

        //skip adding if param is already closed
        if(hasEndingParam(param)) {
           closeNodes(param) ;
        }
    }

    private boolean hasEndingParam(String param) {
        return param.contains(")");
    }

    private String nodeKey(String param, boolean hasEndingParam) {
        if(hasEndingParam) {
            int endParamPos = param.indexOf(')');
            return param.substring(1, endParamPos);
        }

        return param.substring(1);
    }
}
