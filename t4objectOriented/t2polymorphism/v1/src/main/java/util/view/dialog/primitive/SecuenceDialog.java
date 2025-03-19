package util.view.dialog.primitive;

import util.collection.list.LinkedList;

public abstract class SecuenceDialog<T> extends Dialog<T> {
    
    private final String FIXES;
    private final String SEPARATOR;
    
    protected SecuenceDialog(String title, String prefix, String element, String separator, String postfix) {
        super(title, prefix + "(" + element + "(" + separator + element + ")*)?" + postfix);
        this.FIXES = "[" + prefix + postfix + "]";
        this.SEPARATOR = separator;
    }

    protected LinkedList<String> strings(String string) {
        LinkedList<String> strings = new LinkedList<String>();
        if (!this.FIXES.equals("[]")){
            string = string.replaceAll(this.FIXES, "");
        }
        if (string.isBlank()) {
            return strings;
        }
        for (String element : string.split(this.SEPARATOR)) {
            strings.add(element);
        }
        return strings;
    }
    
}
