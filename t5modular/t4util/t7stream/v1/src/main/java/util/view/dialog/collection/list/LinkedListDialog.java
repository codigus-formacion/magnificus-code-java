package util.view.dialog.collection.list;

import util.view.dialog.primitive.SecuenceDialog;

public abstract class LinkedListDialog<T> extends SecuenceDialog<T> {

    protected LinkedListDialog(String title, String regExp) {
        super(title, "\\{", regExp, ",", "\\}");
    }

}
