package util.view.menu;

public abstract class IterativeMenu extends QuitMenu {

    public IterativeMenu(String title) {
        super(title);
    }
    
    public void interact() {
        do {
            super.interact();
        } while (!this.isExecutedQuitOption());
    }

}
