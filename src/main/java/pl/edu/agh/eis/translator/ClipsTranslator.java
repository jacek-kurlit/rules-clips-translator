package pl.edu.agh.eis.translator;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import pl.edu.agh.eis.converter.Const;
import pl.edu.agh.eis.converter.ConstructBuilder;
import pl.edu.agh.eis.model.Construct;
import pl.edu.agh.eis.model.DeffactsConstruct;
import pl.edu.agh.eis.parser.ClipsParser;
import pl.edu.agh.eis.parser.Node;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
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

        String deftemplateOutput = createOutput(constructs, Const.DEFTEMPLATE, "types");
        String deffactsOutput = createDeffactsOutput(constructs);
        String output = createFinalOutput(deftemplateOutput, deffactsOutput);

        printOutput(output, settings);
    }


    private String createOutput(List<Construct> constructs, String constructName, String variableName) {
        List<Construct> filteredConstructs = constructs.stream().filter(construct -> construct.getConstructName().equals(constructName)).collect(Collectors.toList());

        VelocityContext context = new VelocityContext();
        context.put(variableName, filteredConstructs);

        Template template = Velocity.getTemplate(constructName + ".vm");

        StringWriter w = new StringWriter();

        template.merge(context, w);

        return w.toString();

    }

    private String createDeffactsOutput(List<Construct> constructs) {
        List<Construct> filteredConstructs = constructs.stream().filter(construct -> construct.getConstructName().equals(Const.DEFFACTS)).collect(Collectors.toList());
        final List<DeffactsConstruct.Fact> allObjects = collectsAllFacts(filteredConstructs);

        String deffactsObjectOutput = createDeffactsObjectOutput(allObjects);
        String deffactsFactsOutput = createDeffactFactsOutput(allObjects);

        return deffactsObjectOutput + "\n" + deffactsFactsOutput;
    }

    private String createDeffactsObjectOutput(List<DeffactsConstruct.Fact> allObjects) {
        VelocityContext context = new VelocityContext();
        context.put("allObjects", allObjects);

        Template template = Velocity.getTemplate("defobject.vm");

        StringWriter w = new StringWriter();

        template.merge(context, w);

        return w.toString();
    }

    private String createDeffactFactsOutput(List<DeffactsConstruct.Fact> allFacts) {
        VelocityContext context = new VelocityContext();
        context.put("allFacts", allFacts);

        Template template = Velocity.getTemplate("deffacts.vm");

        StringWriter w = new StringWriter();

        template.merge(context, w);

        return w.toString();
    }

    private List<DeffactsConstruct.Fact> collectsAllFacts(List<Construct> filteredConstructs) {
        final List<DeffactsConstruct.Fact> allFacts = new ArrayList<>();
        filteredConstructs.stream().map(new Function<Construct, List<DeffactsConstruct.Fact>>() {

            @Override
            public List<DeffactsConstruct.Fact> apply(Construct construct) {
                DeffactsConstruct deffactsConstruct = (DeffactsConstruct) construct;
                return deffactsConstruct.getFacts();
            }
        }).forEach(new Consumer<List<DeffactsConstruct.Fact>>() {
            @Override
            public void accept(List<DeffactsConstruct.Fact> facts) {
                allFacts.addAll(facts);
            }
        });

        return allFacts;
    }

    private String createFinalOutput(String deftemplateOutput, String deffactsOutput) {
        VelocityContext context = new VelocityContext();
        context.put("deftemplateOutput", deftemplateOutput);
        context.put("deffactsOutput", deffactsOutput);

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
