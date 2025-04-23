package util.view.menu;

import util.collection.list.LinkedList;
import util.view.dialog.primitive.Console;

public class Menu {

    private String title;
    private LinkedList<String> subtitles;
    private LinkedList<Option> options;

    public Menu(String title) {
        this.title = title;
        this.subtitles = new LinkedList<String>();
        this.options = new LinkedList<Option>();
    }

    public void add(String title, Option option) {
        this.subtitles.add(title);
        this.options.add(option);
    }

    public void interact() {
        this.showTitles();
        this.execChoosedOption();
    }

    public void showTitles() {
        this.showTitle();
        for (int i = 0; i < this.options.size(); i++) {
            Console.instance().writeln((i + 1) + ". " + this.subtitles.get(i));
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

    public boolean has(Option option) {
        return this.options.contains(option);
    }

}
