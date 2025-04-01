package util.view.dialog.primitive;

public class DoubleDialog extends Dialog<Double> {

    public DoubleDialog(String title) {
        super(title, Console.DOUBLE_regExp);
    }

    public DoubleDialog() {
        this("");
    }

    public Double create(String string) {
        return Double.parseDouble(string);
    }

    public void addContent(Double decimal) {
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