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
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

public class ClipsTranslator {
    private ClipsParser clipsParser = new ClipsParser();

    public void parseInputFile(Settings settings) throws IOException{
        List<Node> parentNodes = clipsParser.parseFile(settings.getInput());
        List<Construct> constructs = convertToConstruct(parentNodes);

        initVelocity(settings);

        VelocityContext context = new VelocityContext();

        context.put(Const.DEFMODULE, constructs.get(0));

        Template template = Velocity.getTemplate("defmodule.vm");
        /* lets render a template */

        StringWriter w = new StringWriter();

        template.merge(context, w);
        System.out.println( w );
    }

    private void initVelocity(Settings settings) {
        Velocity.addProperty("file.resource.loader.path", settings.getDefinitionInput().getPath());
        Velocity.init();
    }

    private List<Construct> convertToConstruct(List<Node> parentNodes) {
        return Arrays.asList(ConstructBuilder.convertToConstruct(parentNodes.get(0)));
    }
}
