package util.view.menu;

public class IterativeMenu<T> {

    private QuitMenu<T> delegated;

    public IterativeMenu(String title, T target) {
        this.delegated = new QuitMenu<T>(title, target);
    }
    
    public void add(Option option) {
        this.delegated.add(option);
    }

    public void interact() {
        do {
            this.delegated.interact();
        } while (!this.delegated.isExecutedQuitOption());
    }

    public void removeOptions() {
        this.delegated.removeOptions();
    }

    public boolean isExecutedQuitOption() {
        return this.delegated.isExecutedQuitOption();
    }

    public void execChoosedOption() {
        this.delegated.execChoosedOption();
    }

    public void showTitles() {
      this.delegated.showTitles();
    }

    public T getTarget(){
        return this.delegated.getTarget();
    }

}
