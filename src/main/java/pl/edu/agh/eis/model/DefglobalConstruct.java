package pl.edu.agh.eis.model;

import pl.edu.agh.eis.converter.Const;

import java.util.ArrayList;
import java.util.List;

public class DefglobalConstruct extends Construct {
    private String moduleName;
    private List<Assignment> assignments = new ArrayList<>();

    public DefglobalConstruct() {
        super(Const.DEFGLOBAL);
    }

    public class Assignment {
        private String expression;
        private String value;

        public Assignment(String expression, String value) {
            this.expression = expression;
            this.value = value;
        }

        public String getExpression() {
            return expression;
        }

        public String getValue() {
            return value;
        }
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void addAssignment(String expression, String value) {
        assignments.add(new Assignment(expression, value));
    }
}
