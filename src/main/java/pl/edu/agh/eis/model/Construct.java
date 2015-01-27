package pl.edu.agh.eis.model;

public abstract class Construct {
    private String constructName;

    public Construct(String constructName) {
        this.constructName = constructName;
    }

    public String getConstructName() {
        return constructName;
    }

    public String getTemplateName() {
        return constructName + ".vm";
    }
}
