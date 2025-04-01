package app.menu;

public class App {

    public static void main(String[] args) {
        new ModelMenu(new Model()).interact();
        new ModelQuitMenu(new Model()).interact();
        new ModelIterativeMenu(new Model()).interact();
    }
    
}
