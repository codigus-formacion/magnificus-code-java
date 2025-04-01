package app.menu;

import util.view.dialog.primitive.Console;
import util.view.menu.Menu;
import util.view.menu.Option;

class ModelMenu extends Menu<Model> {

    public ModelMenu(Model target) {
        super("Model Menu", target);
        this.add(new ListModelOption(this.getTarget()));
        this.add(new InverseListModelOption(this.getTarget()));
        this.add(new FindModelOption(this.getTarget()));
    }

    class ListModelOption extends ModelOption {

        public ListModelOption(Model model) {
            super("Listar", model);
        }

        public void interact() {
            for (int i = 0; i < this.getTarget().size(); i++) {
                Console.instance().writeln((i + 1) + ". " + this.getTarget().get(i));
            }
            Console.instance().writeln();
        }

    }

    class InverseListModelOption extends ModelOption {

        public InverseListModelOption(Model model) {
            super("Listar inverso", model);
        }
    
        public void interact() {
            for (int i = this.getTarget().size() - 1; i >= 0; i--) {
                Console.instance().writeln((i + 1) + ". " + this.getTarget().get(i));
            }
            Console.instance().writeln();
        }
    
    }

    class FindModelOption extends ModelOption {

        public FindModelOption(Model model) {
            super("Buscar", model);
        }

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

    }

}
