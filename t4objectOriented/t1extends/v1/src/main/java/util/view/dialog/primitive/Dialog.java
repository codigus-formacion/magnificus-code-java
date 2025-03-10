package util.view.dialog.primitive;

public abstract class Dialog<T> {

    private String title;
    private String content;

    protected Dialog(){
        this.title = "";
    }
    
    protected Dialog(String title) {
        assert !title.isBlank();

        this.title = title;
    }

    public T read() {
        String input;
        boolean valid;
        do {
            Console.instance().write(this.title + " (" + regExp() + "): ");
            input = Console.instance().readString();
            valid = this.isValid(input);
            if (!valid) {
                Console.instance().writeln("Fallo!!!" + this.errorMsg());
            }
        } while (!valid);
        return this.create(input);
    }

    protected boolean isValid(String string){
        return string.matches(this.regExp());
    }

    protected abstract String regExp();

    private String errorMsg() {
        return "Al no respetar el formato \"" + this.regExp() + "\"";
    }

    public abstract T create(String string);

    public void write(T element) {
        assert this.title != null;

        Console.instance().write(element);
    }

    public void writeln(T element) {
        this.write(element);
        Console.instance().writeln();
    }

    public void writeDetails(T element) {
        assert this.title != null;

        this.content = "===============";
        this.addContent(element);
        Console.instance().writeln(this.content);
    }

    protected abstract void addContent(T integer);

    protected void addLine(String line) {
        this.content += "\n" + line;
    }

}
