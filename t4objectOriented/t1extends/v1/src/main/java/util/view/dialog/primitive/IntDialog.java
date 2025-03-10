package util.view.dialog.primitive;

public class IntDialog extends Dialog<Integer> {

    public IntDialog() {
        super();
    }

    public IntDialog(String title) {
        super(title);
    }

    public String regExp() {
        return Console.INTEGER_regExp;
    }

    public Integer create(String string) {
        assert string.matches(regExp());

        return Integer.parseInt(string);
    }

    public void addContent(Integer integer) {
        this.addLine("toString: " + integer.toString());
        this.addLine("sum 1: " + (integer + 1));
        this.addLine("substract 1: " + (integer - 1));
        this.addLine("multiply 2: " + (integer * 2));
        this.addLine("divide 2: " + (integer * 2));
        this.addLine("module 2: " + (integer % 2));
        this.addLine("greater 0: " + (integer > 0));
        this.addLine("equals or greater 0: " + (integer >= 0));
        this.addLine("equals 0: " + (integer == 0));
        this.addLine("lesser or equals 0: " + (integer <= 0));
        this.addLine("lesser 0: " + (integer < 0));
    }

}
