package pl.edu.agh.eis.translator;

import org.kohsuke.args4j.*;
import org.kohsuke.args4j.spi.OptionHandler;
import org.kohsuke.args4j.spi.Parameters;
import org.kohsuke.args4j.spi.Setter;

import java.io.File;

public class Arguments {
    private static final String INPUT_USAGE = "Path to CLIPS file that will be translated to representation model notation. This argument is mandatory!";
    private static final String OUTPUT_USAGE = "(Optional) Specify path for output file. If not set, translation will be printed on console.";
    private static final String DEFINITION_USAGE = "(Optional) Specify path for definition file. If not set, translation will be based on default definition file." +
            "Definition file describes how CLIPS should be translated into representation model.";

    @Argument(usage = INPUT_USAGE, required = true, metaVar = "input")
    private File input = null;

    @Option(usage = OUTPUT_USAGE, name = "-output", metaVar = "<path>")
    private File output = null;

    @Option(usage = DEFINITION_USAGE, name = "-definition", metaVar = "<path>")
    private File definition = null;

    public File getInput() {
        return input;
    }

    public File getOutput() {
        return output;
    }

    public File getDefinition() {
        return definition;
    }
}
