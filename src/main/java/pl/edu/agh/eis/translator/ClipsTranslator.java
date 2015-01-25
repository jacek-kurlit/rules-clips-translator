package pl.edu.agh.eis.translator;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import pl.edu.agh.eis.parser.ClipsParser;
import pl.edu.agh.eis.parser.Node;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

public class ClipsTranslator {
    private ClipsParser clipsParser = new ClipsParser();

    public void parseInputFile(Settings settings) throws IOException{
        //List<Node> parentNodes = clipsParser.parseFile(settings.getInput());
        /* first, we init the runtime engine.  Defaults are fine. */
        System.out.println(settings.getDefinitionInput().getParent());
        Velocity.addProperty("file.resource.loader.path", settings.getDefinitionInput().getParent());
        Velocity.init();
        /* lets make a Context and put data into it */

        VelocityContext context = new VelocityContext();

        context.put("name", "Velocity");
        context.put("project", "Jakarta");

        Template template = Velocity.getTemplate(settings.getDefinitionInput().getName());
        /* lets render a template */

        StringWriter w = new StringWriter();

        template.merge(context, w);
        System.out.println(" template : " + w );

        /* lets make our own string to render */

        String s = "We are using $project $name to render this.";
        w = new StringWriter();
        Velocity.evaluate( context, w, "mystring", s );
        System.out.println(" string : " + w );
    }
}
