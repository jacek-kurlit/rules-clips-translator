package pl.edu.agh.eis.translator;

import java.io.*;

public class Settings {
    private File input;
    private OutputStream output;
    private File definitionInput;

    public File getInput() {
        return input;
    }

    public void setInput(File input) {
        this.input = input;
    }

    public OutputStream getOutput() {
        return output;
    }


    public void setOutput(OutputStream output) {
        this.output = output;
    }

    public File getDefinitionInput() {
        return definitionInput;
    }

    public void setDefinitionInput(File definitionInput) {
        this.definitionInput = definitionInput;
    }
}
