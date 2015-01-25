package pl.edu.agh.eis.parser;

import pl.edu.agh.eis.util.FileLoader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClipsParser {
    private LineDecoder lineDecoder = new LineDecoder();

    public List<Node> parseFile(File input) throws IOException {
        List<String> fileLines = FileLoader.loadFileContent(input);

        return createParentsNodes(fileLines);
    }

    private List<Node> createParentsNodes(List<String> fileLines) {
        List<Node> parentNodes = new ArrayList<Node>();

        for(String line : fileLines) {
            if(isNotEmptyLine(line)) {
                decodeLine(line, parentNodes);
            }
        }

        return parentNodes;
    }

    private void decodeLine(String line, List<Node> parentNodes) {
        lineDecoder.decodeLine(line.trim());
        if(lineDecoder.isParentNodeReady()) {
            parentNodes.add(lineDecoder.getParentNode());
        }
    }

    private boolean isNotEmptyLine(String line) {
        return !line.trim().isEmpty();
    }
}
