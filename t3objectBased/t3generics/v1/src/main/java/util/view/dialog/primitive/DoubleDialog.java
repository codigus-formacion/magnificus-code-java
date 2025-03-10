package util.view.dialog.primitive;

public class DoubleDialog {

    private Dialog<Double> delegated;

    public DoubleDialog() {
        this.delegated = new Dialog<Double>("", DoubleDialog.regExp());
    }

    public DoubleDialog(String title) {
        this.delegated = new Dialog<Double>(title, DoubleDialog.regExp());
    }

    public double read() {
        return DoubleDialog.create(this.delegated.read());
    }    
    
    public static String regExp() {
        return Console.DOUBLE_regExp;
    }

    public static Double create(String string) {
        return Double.parseDouble(string);
    }

    public void write(double element) {
        this.delegated.write(element);
    }

    public void writeln(double element) {
        this.delegated.writeln(element);
    }

    public void writeDetails(double element) {
        this.delegated.addHead(element);
        this.addContent(element);
        this.delegated.writeDetails();
    }

    public void addContent(Double decimal) {
        this.delegated.addLine("sum 1: " + (decimal + 1));
        this.delegated.addLine("substract 1: " + (decimal - 1));
        this.delegated.addLine("multiply 2: " + (decimal * 2));
        this.delegated.addLine("divide 2: " + (decimal * 2));
        this.delegated.addLine("module 2: " + (decimal % 2));
        this.delegated.addLine("greater 0: " + (decimal > 0));
        this.delegated.addLine("equals or greater 0: " + (decimal >= 0));
        this.delegated.addLine("equals 0: " + (decimal == 0));
        this.delegated.addLine("lesser or equals 0: " + (decimal <= 0));
        this.delegated.addLine("lesser 0: " + (decimal < 0));
    }

}