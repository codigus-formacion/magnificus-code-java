package util.view.dialog.primitive;

public class Dialog<T> {

    private String title;
    private String content;
    private String regExp;

    public Dialog(String regExp) {
        this.title = "";
        this.regExp = regExp;
    }

    public Dialog(String title, String regExp) {
        assert !title.isBlank();

        this.title = title;
        this.regExp = regExp;
    }

    public String read() {
        String input;
        boolean valid;
        do {
            Console.instance().write(this.title + " (" + this.regExp + "): ");
            input = Console.instance().readString();
            valid = this.isValid(input);
            if (!valid) {
                Console.instance().writeln("Fallo!!!" + this.errorMsg());
            }
        } while (!valid);
        return input;
    }

    public boolean isValid(String string) {
        return string.matches(this.regExp);
    }

    private String errorMsg() {
        return "Al no respetar el formato \"" + this.regExp + "\"";
    }

    public void write(T element) {
        assert this.title != null;

        Console.instance().write(element);
    }

    public void writeln(T element) {
        this.write(element);
        Console.instance().writeln();
    }

    public void addHead(T element) {
        assert this.title != null;

        this.content = "===============";
        this.addLine("toString: " + element.toString());
    }
    
    public void writeDetails(){
        Console.instance().writeln(this.content);
    }

    public void addLine(String line) {
        this.content += "\n" + line;
    }

}
