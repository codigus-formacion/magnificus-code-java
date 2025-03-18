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
        String withoutBrackets = string.replaceAll(this.FIXES, "");
        if (withoutBrackets.isBlank()) {
            return strings;
        }
        String[] elements = withoutBrackets.split(this.SEPARATOR);
        for (String element : elements) {
            strings.add(element);
        }
        return strings;
    }
    

}
