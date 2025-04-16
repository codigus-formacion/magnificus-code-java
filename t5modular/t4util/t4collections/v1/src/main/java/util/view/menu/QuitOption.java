package util.view.menu;

import util.view.dialog.primitive.Console;

public class QuitOption implements Option {

    private boolean executed;

    public QuitOption() {
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
