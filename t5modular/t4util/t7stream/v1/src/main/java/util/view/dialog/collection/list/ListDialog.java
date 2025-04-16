package util.view.dialog.collection.list;

import util.view.dialog.primitive.SecuenceDialog;

public abstract class ListDialog<T> extends SecuenceDialog<T> {

    protected ListDialog(String title, String regExp) {
        super(title, "\\{", regExp, ",", "\\}");
    }

}
