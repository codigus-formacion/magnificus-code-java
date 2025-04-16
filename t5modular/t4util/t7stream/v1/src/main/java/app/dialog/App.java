package app.dialog;

import java.util.stream.Stream;

import util.view.dialog.primitive.Dialog;

public class App {
  
    public static <T> void writeDetails(Stream<T> stream, Dialog<T> dialog) {
        stream.forEach(element -> {
            dialog.writeDetails(element);
        });
    }
    
}
