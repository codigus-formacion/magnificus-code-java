package util.view.menu;

import util.collection.list.LinkedList;
import util.view.dialog.primitive.Console;

public abstract class Menu<T> {

    private String title;
    private LinkedList<Option<T>> options;
    private T target;

    public Menu(String title, T target) {
        this.title = title;
        this.options = new LinkedList<Option<T>>();
        this.target = target;
    }

    public void interact() {
        this.addOptions();
        this.interact_();
    }

    protected abstract void addOptions();

    protected void interact_() {
        this.showTitles();
        this.execChoosedOption();
    }

    protected void showTitles() {
        this.showTitle();
        for (int i = 0; i < this.options.size(); i++) {
            this.options.get(i).showTitle(i + 1);
        }
    }

    private void showTitle() {
        String string = "\n" + this.title + "\n";
        for (int i = 0; i < this.title.length(); i++) {
            string += "-";
        }
        Console.instance().writeln(string);
    }

    protected void execChoosedOption() {
        int answer;
        boolean ok;
        do {
            answer = Console.instance().readInt("Opción? [1-" + this.options.size() + "]: ") - 1;
            ok = 0 <= answer && answer < this.options.size();
            if (!ok) {
                Console.instance().writeln("Error!!!");
            }
        } while (!ok);
        this.options.get(answer).interact();
    }

    protected void add(Option<T> option) {
        this.options.add(option);
    }

    protected boolean hasOption(Option<T> option) {
        for (int i = 0; i < this.options.size(); i++) {
            if (this.options.get(i) == option) {
                return true;
            }
        }
        return false;
    }

    protected void removeOptions() {
        this.options = new LinkedList<Option<T>>();
    }

    protected T getTarget(){
        return this.target;
    }

}
