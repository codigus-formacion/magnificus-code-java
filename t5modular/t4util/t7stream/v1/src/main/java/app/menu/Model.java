package app.menu;

import java.util.LinkedList;
import java.util.List;

public class Model {

    private List<String> strings;

    public Model() {
        this.strings = new LinkedList<String>();
        List.of("Ana", "Beatriz", "Carmen")
                .forEach(this::add);
    }

    public void add(String string) {
        this.strings.add(string);
    }

    public void remove(int index) {
        assert 0 <= index && index < this.size();

        this.remove(index);
    }

    public String get(int index) {
        assert 0 <= index && index < this.size();

        return this.strings.get(index);
    }

    public int size() {
        return this.strings.size();
    }

    public boolean find(String string) {
        return this.strings.stream().anyMatch(s -> s.equals(string));
    }

}
