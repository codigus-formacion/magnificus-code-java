package util.view.dialog.primitive;

import util.view.Console;

public abstract class Dialog<T> {

    // protected String title;
    // private final String regexp;
    // protected T element;
    // private String content;

    // protected Dialog(String regexp) {
    //     assert !regexp.isBlank();

    //     this.title = "";
    //     this.regexp = regexp;
    // }

    // protected Dialog(String title, String regexp) {
    //     this(regexp);

    //     assert !title.isBlank();

    //     this.title = title;
    // }

    // public T read() {
    //     String input;
    //     boolean valid;
    //     do {
    //         Console.instance().write(this.title + " (" + this.regexp + "): ");
    //         input = Console.instance().readString();
    //         valid = this.isValid(input);
    //         if (!valid) {
    //             Console.instance().writeln("Fallo!!!" + this.errorMsg());
    //         }
    //     } while (!valid);
    //     return this.of(input);
    // }

    // protected String errorMsg() {
    //     return "Al no respetar el formato \"" + this.regexp + "\"";
    // }

    // protected boolean isValid(String string) {
    //     if (!string.matches(this.regexp)) {
    //         return false;
    //     }
    //     return isSemanticValid(string);
    // }

    // protected boolean isSemanticValid(String string) {
    //     return true;
    // }

    // protected abstract T of(String input);

    // public void write(T element) {
    //     assert this.title != null;

    //     Console.instance().write(element);
    // }

    // public void writeln(T element) {
    //     this.write(element);
    //     Console.instance().writeln();
    // }

    // public void writeDetails(T element) {
    //     assert this.title != null;

    //     this.content = "===============";
    //     this.addContent(element);
    //     Console.instance().writeln(this.content);
    // }

    // protected abstract void addContent(T element);

    // protected void addLine(String line) {
    //     this.content += "\n" + line;
    // }

}
