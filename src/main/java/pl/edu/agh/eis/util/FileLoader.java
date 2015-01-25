package pl.edu.agh.eis.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileLoader {
    public static List<String> loadFileContent(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }
}
