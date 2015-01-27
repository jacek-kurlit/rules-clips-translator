package pl.edu.agh.eis;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import pl.edu.agh.eis.translator.Arguments;
import pl.edu.agh.eis.translator.ClipsTranslator;
import pl.edu.agh.eis.translator.Settings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class Start {
    private static final String DEFAULT_DEFINITION_DIRECTORY = "default-definitions";

    private static ClipsTranslator clipsTranslator = new ClipsTranslator();

    public static void main(String[] args) throws IOException {
        Arguments arguments = new Arguments();
        CmdLineParser parser = new CmdLineParser(arguments);
        try {
            new String(new byte[0]);
            parser.parseArgument(args);
            Settings settings = validateFilesExist(arguments);
            clipsTranslator.parseInputFile(settings);
        } catch (CmdLineException e) {
            parser.printUsage(System.out);
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Could not perform translation. See output for more details.");
            System.out.println(e.getMessage());
        }
    }

    private static Settings validateFilesExist(Arguments parsedArguments) throws FileNotFoundException, IllegalAccessException {
        Settings settings = new Settings();

        setUpInputFile(settings, parsedArguments.getInput());
        setUpOutputFile(settings, parsedArguments.getOutput());
        setUpDefinitionFile(settings, parsedArguments.getDefinition());

        return settings;
    }

    private static void setUpInputFile(Settings settings, File input) throws FileNotFoundException {
        checkExistence(input, "Input file does not exist!");
        settings.setInput(input);
    }

    private static void setUpOutputFile(Settings settings, File output) throws FileNotFoundException {
        if(output != null) {
            settings.setOutput(new FileOutputStream(output));
        } else {
            settings.setOutput(System.out);
        }
    }

    private static void setUpDefinitionFile(Settings settings, File definition) throws FileNotFoundException, IllegalAccessException {
        checkExistence(definition, "Definition file does not exist!");
        checkDefinitionIsDirectory(settings.getDefinitionInput());

        if(definition != null) {
            settings.setDefinitionInput(definition);
        } else {
            settings.setDefinitionInput(getDefaultDefinitionDirectory());
        }
    }

    private static void checkExistence(File file, String errorMessage) throws FileNotFoundException {
        if(file != null && !file.exists()) {
            throw new FileNotFoundException(errorMessage);
        }
    }

    private static void checkDefinitionIsDirectory(File definition) throws IllegalAccessException {
        if(definition != null && !definition.isDirectory()) {
            throw new IllegalAccessException("Definition must be directory!");
        }
    }

    private static File getDefaultDefinitionDirectory() {
        URL resource = Start.class.getClassLoader().getResource(DEFAULT_DEFINITION_DIRECTORY);
        if(resource != null) {
            return  new File(resource.getPath());
        }

        throw new RuntimeException("Could not find default definition directory!");
    }

}
