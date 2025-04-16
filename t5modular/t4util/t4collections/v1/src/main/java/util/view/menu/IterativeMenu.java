package util.view.menu;

public class IterativeMenu {

    private QuitMenu delegated;

    public IterativeMenu(String title) {
        this.delegated = new QuitMenu(title);
    }
    
    public void add(String subtitle, Option option) {
        this.delegated.add(subtitle, option);
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

}
