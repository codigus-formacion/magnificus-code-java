package util.view.dialog.values;

import java.util.LinkedList;
import java.util.List;

import util.values.Pair;
import util.view.dialog.primitive.Dialog;

public abstract class PairDialog<K, V> extends Dialog<Pair<K, V>> {

  private static final String PREFIX = "<";
  private static final String SEPARATOR = "\\|";
  private static final String POSTFIX = ">";
  private static final String FIXES = "[" + PREFIX + POSTFIX + "]";

  protected PairDialog(String title, String keyRegExp, String valueRegExp) {
    super(title, PREFIX + "(" + keyRegExp + ")" + SEPARATOR + "(" + valueRegExp + ")" + POSTFIX);
  }

  protected PairDialog(String keyRegExp, String valueRegExp) {
    this("", keyRegExp, valueRegExp);
  }

  protected LinkedList<String> strings(String string) {
    string = string.replaceAll(FIXES, "");
    return string.isBlank() 
        ? new LinkedList<String>() 
        : new LinkedList<String>(List.of(string.split(SEPARATOR)));
  }

}
