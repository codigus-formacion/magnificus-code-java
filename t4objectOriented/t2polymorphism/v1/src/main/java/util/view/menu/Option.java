package util.view.menu;

import util.view.dialog.primitive.Console;

public abstract class Option<T> {

    private String title;
    private T target;
    
    protected Option(String title, T target) {
        this.title = title;
        this.target = target;
    }

    public abstract void interact();

    public void showTitle(int index) {
        Console.instance().writeln(index + ". " + this.title);
    }

    protected T getTarget() {
        return this.target;
    }

    protected String getTitle(){
        return this.title;
    }

}
