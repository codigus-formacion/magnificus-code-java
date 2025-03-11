package util.view.dialog.values;

import util.values.Date;
import util.view.dialog.primitive.Dialog;
import util.view.dialog.primitive.IntDialog;

public class DateDialog {

    private static String SEPARATOR = "/";

    private Dialog<Date> delegated;

    public DateDialog(String title) {
        this.delegated = new Dialog<Date>(title, DateDialog.regExp());
    }

    public Date read() {
        String input;
        do {
            input = this.delegated.read();
        } while (!DateDialog.isValid(input));
        return DateDialog.create(input);
    }

    public static String regExp() {
        return IntDialog.regExp() + SEPARATOR + IntDialog.regExp() + SEPARATOR + IntDialog.regExp();
    }

    private static boolean isValid(String string) {
        Integer[] integers = DateDialog.values(string);
        return Date.isValidMonth(integers[1])
            && Date.isValidDay(integers[2]);
    }

    private static Integer[] values(String string) {
        assert DateDialog.isValid(string);

        String[] strings = string.split(SEPARATOR);
        Integer[] integers = new Integer[strings.length];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = IntDialog.create(strings[i]);
        }
        return integers;
    }

    public static Date create(String string) {
        assert DateDialog.isValid(string);

        Integer[] integers = values(string);
        return new Date(integers[0], integers[1], integers[2]);
    }

    public void write(Date date) {
        this.delegated.write(date);
    }

    public void writeln(Date date) {
        this.delegated.writeln(date);
    }

    public void writeDetails(Date element) {
        this.delegated.addHead(element);
        this.addContent(element);
        this.delegated.writeDetails();
    }

    public void addContent(Date date) {
        this.delegated.addLine("next: " + date.next());
        Date pivot = new Date(2025,6,6);
        this.delegated.addLine("before: " + date.before(pivot));
        this.delegated.addLine("equals: " + date.equals(pivot));
        this.delegated.addLine("after: " + date.after(pivot));
    }

}
