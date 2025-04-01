package util.view.menu;

public class QuitMenu<T> {

    private Menu<T> delegated;
    private QuitOption quitOption;

    public QuitMenu(String title, T target) {
        this.delegated = new Menu<T>(title, target);
        this.quitOption = null;
    }

    public void add(Option option) {
        this.delegated.add(option);
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
            this.delegated.add(this.quitOption);
        }
    }

    public T getTarget() {
        return this.delegated.getTarget();
    }

}
