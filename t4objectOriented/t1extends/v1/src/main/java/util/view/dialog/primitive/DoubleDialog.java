package util.view.dialog.primitive;

public class DoubleDialog extends Dialog<Double>{

    public DoubleDialog() {
        super();
    }

    public DoubleDialog(String title) {
        super(title);
    }

    public String regExp() {
        return Console.DOUBLE_regExp;
    }

    public Double create(String string) {
        assert string.matches(regExp());

        return Double.parseDouble(string);
    }

    public void addContent(Double decimal) {
        this.addLine("toString: " + decimal.toString());
        this.addLine("sum 1: " + (decimal + 1));
        this.addLine("substract 1: " + (decimal - 1));
        this.addLine("multiply 2: " + (decimal * 2));
        this.addLine("divide 2: " + (decimal * 2));
        this.addLine("module 2: " + (decimal % 2));
        this.addLine("greater 0: " + (decimal > 0));
        this.addLine("equals or greater 0: " + (decimal >= 0));
        this.addLine("equals 0: " + (decimal == 0));
        this.addLine("lesser or equals 0: " + (decimal <= 0));
        this.addLine("lesser 0: " + (decimal < 0));
    }

}