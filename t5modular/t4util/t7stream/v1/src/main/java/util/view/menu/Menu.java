package util.view.menu;

import java.util.LinkedList;
import java.util.stream.IntStream;

import util.view.dialog.primitive.Console;

public abstract class Menu {

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
        IntStream.range(0, this.options.size())
                .mapToObj(index -> (index + 1) + ". " + this.subtitles.get(index))
                .forEach(Console.instance()::writeln);
    }

    private void showTitle() {
        Console.instance().writeln("\n" + this.title + "\n" +
                "-".repeat(this.title.length()));
    }

    public void execChoosedOption() {
        IntStream
                .generate(() -> Console.instance().readInt("Opción? [1-" + this.options.size() + "]: ") - 1)
                .filter(answer -> {
                    boolean ok = 0 <= answer && answer < this.options.size();
                    if (!ok) {
                        Console.instance().writeln("Error!!!");
                    }
                    return ok;
                })
                .findFirst()
                .ifPresent(answer -> this.options.get(answer).interact());
    }

    public void removeOptions() {
        this.options = new LinkedList<Option>();
    }

    public boolean has(Option option) {
        return this.options.contains(option);
    }

}
