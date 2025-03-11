package util.view.dialog.primitive;

public class IntDialog {

    private Dialog<Integer> delegated;

    public IntDialog() {
        this.delegated = new Dialog<Integer>("", IntDialog.regExp());
    }

    public IntDialog(String title) {
        this.delegated = new Dialog<Integer>(title, IntDialog.regExp());
    }

    public int read() {
        return IntDialog.create(this.delegated.read());
    }

    public static String regExp() {
        return Console.INTEGER_regExp;
    }

    public static Integer create(String string) {
        assert string.matches(regExp());

        return Integer.parseInt(string);
    }

    public void write(int element) {
        this.delegated.write(element);
    }

    public void writeln(int element) {
        this.delegated.writeln(element);
    }

    public void writeDetails(int element) {
        this.delegated.addHead(element);
        this.addContent(element);
        this.delegated.writeDetails();
    }

    public void addContent(Integer integer) {
        this.delegated.addLine("sum 1: " + (integer + 1));
        this.delegated.addLine("substract 1: " + (integer - 1));
        this.delegated.addLine("multiply 2: " + (integer * 2));
        this.delegated.addLine("divide 2: " + (integer * 2));
        this.delegated.addLine("module 2: " + (integer % 2));
        this.delegated.addLine("greater 0: " + (integer > 0));
        this.delegated.addLine("equals or greater 0: " + (integer >= 0));
        this.delegated.addLine("equals 0: " + (integer == 0));
        this.delegated.addLine("lesser or equals 0: " + (integer <= 0));
        this.delegated.addLine("lesser 0: " + (integer < 0));
    }

}
