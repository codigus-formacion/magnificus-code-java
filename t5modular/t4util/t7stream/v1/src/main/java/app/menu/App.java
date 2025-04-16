package app.menu;

import java.util.List;
import util.view.menu.Menu;

public class App {

    public static void main(String[] args) {
        List.of(
            new ModelMenu(new Model()),
            new ModelQuitMenu(new Model()),
            new ModelIterativeMenu(new Model())).stream()
                .forEach(Menu::interact);
    }

}
