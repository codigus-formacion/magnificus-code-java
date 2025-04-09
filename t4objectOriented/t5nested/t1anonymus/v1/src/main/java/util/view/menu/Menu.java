package util.view.menu;

import util.collection.list.LinkedList;
import util.view.dialog.primitive.Console;

public class Menu<T> {

    private String title;
    private LinkedList<Option> options;
    private T target;

    public Menu(String title, T target) {
        this.title = title;
        this.options = new LinkedList<Option>();
        this.target = target;
    }

    public void add(Option option) {
        this.options.add(option);
    }

    public void interact() {
        this.showTitles();
        this.execChoosedOption();
    }

    public void showTitles() {
        this.showTitle();
        for (int i = 0; i < this.options.size(); i++) {
            Console.instance().writeln((i + 1) + ". " + this.options.get(i).getTitle());
        }
    }

    private void showTitle() {
        String string = "\n" + this.title + "\n";
        for (int i = 0; i < this.title.length(); i++) {
            string += "-";
        }
        Console.instance().writeln(string);
    }

    public void execChoosedOption() {
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

    public void removeOptions() {
        this.options = new LinkedList<Option>();
    }

    public T getTarget() {
        return this.target;
    }

    public boolean has(Option option) {
        return this.options.contains(option);
    }

}
