package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class Menu<T> {

    private String title;
    private List<String> subtitles;
    private List<Consumer<T>> actions;
    private T target;

    public Menu(String title, T target) {
        assert title != null && !title.isBlank();
        assert target != null;

        this.title = title;
        this.subtitles = new ArrayList<String>();
        this.actions = new ArrayList<Consumer<T>>();
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
        for (int i = 0; i < this.subtitles.size(); i++) {
            Console.instance().writeln((i+1) + ". " + this.subtitles.get(i));
        }
    }

    protected void showTitle() {
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
            answer = Console.instance().readInt("Opción? [1-" + this.subtitles.size() + "]: ") - 1;
            ok = 0 <= answer && answer < this.subtitles.size();
            if (!ok) {
                Console.instance().writeln("Error!!!");
            }
        } while (!ok);
        this.actions.get(answer).accept(this.target);
    }

    protected void add(String subtitle, Consumer<T> action) {
        assert subtitle != null && !subtitle.isBlank();
        assert action != null;
  
        this.subtitles.add(subtitle);
        this.actions.add(action);
    }

    protected boolean hasAction(Consumer<T> action) {
        assert action != null;

        for (int i = 0; i < this.actions.size(); i++) {
            if (this.actions.get(i) == action) {
                return true;
            }
        }
        return false;
    }

    protected void removeOptions() {
        this.subtitles.clear();
        this.actions.clear();
    }

    protected T target(){
        return this.target;
    }

}
