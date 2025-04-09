package app.menu;

import util.view.dialog.primitive.Console;
import util.view.menu.QuitMenu;

class ModelQuitMenu extends QuitMenu {

    public ModelQuitMenu(Model model) {
        super("Model Quit Menu");
        this.add("Listar", () ->{
                for (int i = 0; i < model.size(); i++) {
                    Console.instance().writeln((i + 1) + ". " + model.get(i));
                }
                Console.instance().writeln();
            });
        this.add("Listar inverso", () -> {
                for (int i = model.size() - 1; i >= 0; i--) {
                    Console.instance().writeln((i + 1) + ". " + model.get(i));
                }
                Console.instance().writeln();
            });
        this.add("Buscar", () -> {
                String string;
                boolean ok;
                do {
                    string = Console.instance().readString("Dame una cadena de caracteres: ").trim();
                    ok = !string.equals("");
                    if (!ok) {
                        Console.instance().writeln("Error! Introduce algún caracter");
                    }
                } while (!ok);
                Console.instance().writeln((model.find(string) ? "Si" : "No") + " se encuentra");
            });
    }

}
