package util.view.menu;

import util.view.dialog.primitive.Console;

public class QuitOption<T> extends Option<T> {

    private boolean executed;

    public QuitOption(T target) {
        super("Salir", target);
        this.executed = false;
    }

    public void interact() {
        this.executed = true;
        Console.instance().writeln("Adios");
    }

    protected boolean isExecuted(){
        return this.executed;
    }

}
