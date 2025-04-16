package util.view.dialog.collection.list;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import util.values.Interval;
import util.values.Time;
import util.view.dialog.values.TimeDialog;

public class TimeLinkedListDialog extends LinkedListDialog<List<Time>> {

    public TimeLinkedListDialog(String title) {
        super(title, new TimeDialog().regExp());
    }
    
    public List<Time> create(String string) {
        return this.strings(string).stream()
                .map(elementString -> new TimeDialog().create(elementString))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public void addContent(List<Time> linkedList) {
        this.addTerminalLines(linkedList);
        this.addIntermediateLines(linkedList);
    }

    private void addTerminalLines(List<Time> list) {
        this.addLine("------------");
        this.addLine("elementos: ", list.stream());
        this.addLine("- terminalTest");
        this.addToNumberLines(list);
        this.addToBooleanLines(list);
        this.addToCollectionLines(list);
        this.addVoidLines(list);
    }

    private void addToNumberLines(List<Time> list) {
        this.addLine("-- toNumberTest");
        this.addLine("findFirst: " + list.stream().findFirst());
        this.addLine("findAny: " + list.stream().findAny());
        this.addLine("count: " + list.stream().count());
    }

    private void addToBooleanLines(List<Time> list) {
        this.addLine("-- toBooleanTest");
        this.addLine("allMatch > 12:0:0: " + list.stream().allMatch(time -> time.after(new Time(12,0,0))));
        this.addLine("anyMatch > 12:0:0: " + list.stream().anyMatch(time -> time.after(new Time(12,0,0))));
        this.addLine("noneMatch > 12:0:0: " + list.stream().noneMatch(time -> time.after(new Time(12,0,0))));
    }

    private void addToCollectionLines(List<Time> list) {
        this.addLine("- toCollectionTest");
        this.addLine("collect toList: " + list.stream().collect(Collectors.toList()));
        this.addLine("collect toSet: " + list.stream().collect(Collectors.toSet()));
        String string = "array: [";
        for (Time time : list.stream().toArray(Time[]::new)) {
            string += time.toString() + ", ";
        }
        this.addLine(string.substring(0, string.length() + (list.isEmpty() ? 0 : -2)) + "]");
    }

    private void addVoidLines(List<Time> list) {
        this.addLine("-- voidTest");
        list.stream().forEach(integer -> {
            this.addLine("" + integer);
        });
        list.stream().forEachOrdered(integer -> {
            this.addLine("" + integer);
        });
    }

    private void addIntermediateLines(List<Time> list) {
        this.addLine("- intermediateTest");
        this.addSubstreamLines(list);
        this.addConverterLines(list);
        this.addToStringLines(list);
    }

    private void addSubstreamLines(List<Time> list) {
        this.addLine("-- substreamTest");
        this.addLine("filter %2==0: ", list.stream().filter(time -> time.after(new Time(12,0,0))));
        this.addLine("takeWhile < 5: ", list.stream().takeWhile(time -> time.after(new Time(12,0,0))));
        this.addLine("limit 5: ", list.stream().limit(5));
        this.addLine("dropWhile < 5: ", list.stream().dropWhile(time -> time.after(new Time(12,0,0))));
        this.addLine("skip 5: ", list.stream().skip(5));
        this.addLine("distinct: ", list.stream().distinct());
        this.addLine("sorted: ", list.stream().sorted());
        this.addLine("unordered: ", list.stream().unordered());
    }

    private void addConverterLines(List<Time> list) {
        this.addLine("-- converterTest");

        this.addLine("boxed: ", list.stream());

        this.addLine("map totalSeconds: " + list.stream().map(time -> time.totalSeconds()).toString());
        this.addLine("map Interval: " + list.stream().map(time -> new Interval(time, time.next())).toString());
        this.addLine("mapToDouble + 1, sum: " + list.stream().mapToDouble(time -> time.totalSeconds()).sum());
        this.addLine("mapToLong + 1, sum: " + list.stream().mapToLong(time -> time.totalSeconds()).sum());
        // this.addLine("map + 1: " + intStream.flatMap(integer -> integer
        // + 1));
        // this.addLine("map + 1: " + intStream.mapMulti(integer ->
        // integer + 1));
    }

    private void addToStringLines(List<Time> list) {
        this.addLine("toString: " + list.stream().toString());
        this.addLine("joining - : " + list.stream()
                .map(element -> element.toString())
                .collect(Collectors.joining(" - ")));
        this.addLine("joining - [ ] : ", list.stream());
    }

    private <T> void addLine(String title, Stream<Time> stream) {
        this.addLine(title + stream
                .map(element -> element.toString())
                .collect(Collectors.joining(", ", "[", "]")));
    }

}
