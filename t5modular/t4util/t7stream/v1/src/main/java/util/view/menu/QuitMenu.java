package util.view.menu;

public abstract class QuitMenu extends Menu{

    private QuitOption quitOption;

    public QuitMenu(String title) {
        super(title);
        this.quitOption = null;
    }

    public void showTitles() {
        this.addQuitOption();
        super.showTitles();
    }

    public boolean isExecutedQuitOption() {
        return this.quitOption.isExecuted();
    }

    public void interact() {
        this.addQuitOption();
        super.interact();
    }

    private void addQuitOption() {
        if (!this.has(this.quitOption)) {
            this.quitOption = new QuitOption();
            this.add("Salir", this.quitOption);
        }
    }

}
