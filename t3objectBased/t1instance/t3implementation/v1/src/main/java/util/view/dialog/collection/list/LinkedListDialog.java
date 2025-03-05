package util.view.dialog.collection.list;

public abstract class LinkedListDialog<T> {

    // protected static final String PREFIX = "\\{";
    // protected static final String SEPARATOR = ",";
    // protected static final String POSTFIX = "\\}";

    // protected static String REGEXP(String regexp) {
    //     return PREFIX + "(" + regexp + "(" + SEPARATOR + regexp + ")*)?" + POSTFIX;
    // }

    //     protected String title;
    // protected T element;
    // private String content;

    // protected LinkedListDialog() {
    //     this.title = "";
    // }

    // protected LinkedListDialog(String title) {
    //     assert title != null && !title.isBlank() : "Title cannot be null or blank";

    //     this.title = title;
    // }

    // public T read() {
    //     String input;
    //     boolean valid;
    //     do {
    //         Console.instance().write(this.title + " (" + REGEXP() + "): ");
    //         input = Console.instance().readString();
    //         valid = this.isValid(input);
    //         if (!valid) {
    //             Console.instance().writeln("Fallo!!!" + this.errorMsg());
    //         }
    //     } while (!valid);
    //     return this.of(input);
    // }

    // protected String errorMsg() {
    //     return "Al no respetar el formato \"" + REGEXP() + "\"";
    // }

    // protected boolean isValid(String string) {
    //     if (!string.matches(REGEXP())) {
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


    // protected StringLinkedList strings(String string) {
    //     assert string != null : "Input string cannot be null";
    
    //     StringLinkedList strings = new StringLinkedList();
    //     String withoutBrackets = string.replaceAll("[" + PREFIX + POSTFIX + "]", "");
    //     if (withoutBrackets.isBlank()) {
    //         return strings;
    //     }
    //     for (String elementString : withoutBrackets.split(SEPARATOR)) {
    //         strings.add(elementString);
    //     }
    //     return strings;
    // }

    // public void addContent(LinkedList<T> element) {
    //     assert element != null : "Element cannot be null";

    //     this.addLine("toString: " + element.toString());
    // }

}