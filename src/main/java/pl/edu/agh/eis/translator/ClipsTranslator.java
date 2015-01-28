package pl.edu.agh.eis.translator;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import pl.edu.agh.eis.converter.Const;
import pl.edu.agh.eis.converter.ConstructBuilder;
import pl.edu.agh.eis.model.Construct;
import pl.edu.agh.eis.parser.ClipsParser;
import pl.edu.agh.eis.parser.Node;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ClipsTranslator {
    private ClipsParser clipsParser = new ClipsParser();

    public void parseInputFile(Settings settings) throws IOException{
        List<Node> parentNodes = clipsParser.parseFile(settings.getInput());
        List<Construct> constructs = convertToConstruct(parentNodes);

        buildXmlOutput(constructs, settings);
    }

    private void initVelocity(Settings settings) {
        Velocity.addProperty("file.resource.loader.path", settings.getDefinitionInput().getPath());
        Velocity.init();
    }

    private List<Construct> convertToConstruct(List<Node> parentNodes) {
        return parentNodes.stream().map(ConstructBuilder::convertToConstruct).filter(construct -> construct != null).collect(Collectors.toList());
    }

    private void buildXmlOutput(List<Construct> constructs, Settings settings) {
        initVelocity(settings);

        String deftemplateOutput = createDeftemplateOutput(constructs);
        String output = createFinalOutput(deftemplateOutput);

        printOutput(output, settings);
    }

    private String createDeftemplateOutput(final List<Construct> constructs) {
        List<Construct> types = constructs.stream().filter(construct -> construct.getConstructName().equals(Const.DEFTEMPLATE)).collect(Collectors.toList());

        VelocityContext context = new VelocityContext();
        context.put("types", types);

        Template template = Velocity.getTemplate(Const.DEFTEMPLATE + ".vm");

        StringWriter w = new StringWriter();

        template.merge(context, w);

        return w.toString();
    }

    private String createFinalOutput(String deftemplateOutput) {
        VelocityContext context = new VelocityContext();
        context.put("deftemplateOutput", deftemplateOutput);

        Template template = Velocity.getTemplate("finaloutput.vm");

        StringWriter w = new StringWriter();

        template.merge(context, w);

        return w.toString();
    }

    private void printOutput(String output, Settings settings) {
        PrintWriter out = new PrintWriter(settings.getOutput());

        out.write(output);
        out.close();
    }
}
