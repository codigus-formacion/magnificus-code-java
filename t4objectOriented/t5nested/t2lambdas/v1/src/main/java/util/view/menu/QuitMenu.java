package util.view.menu;

public class QuitMenu {

    private Menu delegated;
    private QuitOption quitOption;

    public QuitMenu(String title) {
        this.delegated = new Menu(title);
        this.quitOption = null;
    }

    public void add(String subtitle, Option option) {
        this.delegated.add(subtitle, option);
    }

    protected void showTitles() {
        this.addQuitOption();
        this.delegated.showTitles();
    }

    public void execChoosedOption() {
        this.delegated.execChoosedOption();
    }

    public boolean isExecutedQuitOption() {
        return this.quitOption.isExecuted();
    }

    public void removeOptions() {
        this.delegated.removeOptions();
    }

    public void interact() {
        this.addQuitOption();
        this.delegated.interact();
    }

    private void addQuitOption() {
        if (!this.delegated.has(this.quitOption)) {
            this.quitOption = new QuitOption();
            this.delegated.add("Salir", this.quitOption);
        }
    }

}
