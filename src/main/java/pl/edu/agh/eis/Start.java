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

public class Start {
    private static final String DEFAULT_DEFINITION_FILE = "default_template.vm";

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
            System.exit(0);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could not perform translation. See output for more details.");
            System.out.println(e.getMessage());
        }
    }

    private static Settings validateFilesExist(Arguments parsedArguments) throws FileNotFoundException {
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

    private static void setUpDefinitionFile(Settings settings, File definition) throws FileNotFoundException {
        checkExistence(definition, "Definition file does not exist!");

        if(definition != null) {
            settings.setDefinitionInput(definition);
        } else {
            settings.setDefinitionInput(getDefaultDefinitionFile());
        }
    }

    private static void checkExistence(File file, String errorMessage) throws FileNotFoundException {
        if(file != null && !file.exists()) {
            throw new FileNotFoundException(errorMessage);
        }
    }

    private static File getDefaultDefinitionFile() {
        return new File(Start.class.getClassLoader().getResource(DEFAULT_DEFINITION_FILE).getPath());
    }

}
