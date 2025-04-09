package app.menu;

import util.view.dialog.primitive.Console;
import util.view.menu.IterativeMenu;

class ModelIterativeMenu extends IterativeMenu<Model> {

    public ModelIterativeMenu(Model model) {
        super("Model Iterative Menu", model);
        this.add(new ModelOption("Listar", model) {
            public void interact() {
                for (int i = 0; i < this.getTarget().size(); i++) {
                    Console.instance().writeln((i + 1) + ". " + this.getTarget().get(i));
                }
                Console.instance().writeln();
            }

        });
        this.add(new ModelOption("Listar inverso", model) {

            public void interact() {
                for (int i = this.getTarget().size() - 1; i >= 0; i--) {
                    Console.instance().writeln((i + 1) + ". " + this.getTarget().get(i));
                }
                Console.instance().writeln();
            }

        });
        this.add(new ModelOption("Buscar", model) {

            public void interact() {
                String string;
                boolean ok;
                do {
                    string = Console.instance().readString("Dame una cadena de caracteres: ").trim();
                    ok = !string.equals("");
                    if (!ok) {
                        Console.instance().writeln("Error! Introduce algún caracter");
                    }
                } while (!ok);
                Console.instance().writeln((this.getTarget().find(string) ? "Si" : "No") + " se encuentra");
            }

        });
        this.add(new ModelOption("Añadir", model) {

            public void interact() {
                String string;
                do {
                    string = Console.instance().readString("Dame una cadena de caracteres: ");
                } while (string.trim().equals(""));
                this.getTarget().add(string.trim());
            }

        });
        this.add(new ModelDynamicMenu(this.getTarget()));
    }
    
}
