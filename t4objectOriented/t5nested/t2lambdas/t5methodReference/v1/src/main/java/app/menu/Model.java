package app.menu;

public class Model {

    private String[] strings;
    private static final int MAX = 100;
    private int size;

    public Model() {
        this.strings = new String[Model.MAX];
        this.size = 0;        
        for (String string : new String[] { "Ana", "Beatriz", "Carmen" }) {
            this.add(string);
        }
    }

    public void add(String string) {
        assert this.size < Model.MAX;

        this.strings[this.size] = string;
        this.size++;
    }

    public void remove(int index) {
        assert 0 <= index && index < this.size;

        for(int i = index; i < this.size; i++){
            this.strings[i] = this.strings[i+1];
        }
        this.size--;
    }

    public String get(int index) {
        assert 0 <= index && index < this.size;

        return this.strings[index];
    }

    public int size() {
        return this.size;
    }

    public boolean find(String string){
        for(int i=0; i<this.size; i++){
            if (this.strings[i].equals(string)){
                return true;
            }
        }
        return false;
    }

}
