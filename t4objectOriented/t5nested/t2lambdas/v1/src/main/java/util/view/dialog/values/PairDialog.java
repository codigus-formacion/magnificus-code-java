package util.view.dialog.values;

import util.collection.list.LinkedList;
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

  protected boolean isSemanticValid(String string) {
    LinkedList<String> values = this.strings(string);
    return values.size() == 2 
        && new DateDialog().isSemanticValid(values.get(0))
        && new TimeIntervalDialog().isSemanticValid(values.get(1));
  }

  protected LinkedList<String> strings(String string) {
    LinkedList<String> strings = new LinkedList<String>();
    string = string.replaceAll(FIXES, "");
    if (string.isBlank()) {
      return strings;
    }
    for (String element : string.split(SEPARATOR)) {
      strings.add(element);
    }
    return strings;
  }

}
