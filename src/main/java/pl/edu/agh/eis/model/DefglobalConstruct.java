package pl.edu.agh.eis.model;

import pl.edu.agh.eis.converter.Const;

import java.util.ArrayList;
import java.util.List;

public class DefglobalConstruct extends Construct {
    private String typeref;
    private List<String> items = new ArrayList<>();

    public DefglobalConstruct() {
        super(Const.DEFGLOBAL);
    }

    public void setTyperef(String typeref) {
        this.typeref = typeref;
    }

    public String getTyperef() {
        return typeref;
    }

    public List<String> getItems() {
        return items;
    }

    public void addItem(String expression) {
        items.add(expression);
    }
}
