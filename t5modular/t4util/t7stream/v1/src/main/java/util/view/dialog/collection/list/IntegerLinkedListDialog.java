package util.view.dialog.collection.list;

import util.view.dialog.primitive.Console;
import util.view.dialog.primitive.IntDialog;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import util.values.Interval;

public class IntegerLinkedListDialog extends LinkedListDialog<List<Integer>> {

    public IntegerLinkedListDialog(String title) {
        super(title, new IntDialog().regExp());
    }

    public List<Integer> create(String string) {
        LinkedList<Integer> integers = new LinkedList<Integer>();
        Iterator<String> iterator = this.strings(string).iterator();
        while (iterator.hasNext()) {
            String elementString = iterator.next();
            integers.add(new IntDialog().create(elementString));
        }
        return integers;
    }

    public void addContent(LinkedList<Integer> linkedList) {
        this.addTerminalLines(linkedList);
        this.addIntermediateLines(linkedList);
    }

    private void addTerminalLines(List<Integer> list) {
        this.addLine("------------");
        this.addLine("elementos: ", toIntStream(list));
        this.addLine("- terminalTest");
        this.addToNumberLines(list);
        addToBooleanLines(list);
        addToCollectionLines(list);
        addVoidLines(list);
    }
    
    private IntStream toIntStream(List<Integer> list) {
        return list.stream().mapToInt(integer -> integer.intValue());
    }

    private void addToNumberLines(List<Integer> list) {
        this.addLine("-- toNumberTest");
        this.addLine("findFirst: " + toIntStream(list).findFirst());
        this.addLine("findAny: " + toIntStream(list).findAny());
        this.addLine("count: " + toIntStream(list).count());

        this.addLine("min: " + toIntStream(list).min());
        this.addLine("max: " + toIntStream(list).max());
        this.addLine("sum: " + toIntStream(list).sum());
        this.addLine("average: " + toIntStream(list).average());
        this.addLine("summaryStatistics getCount: " + toIntStream(list).summaryStatistics().getCount());
        this.addLine("summaryStatistics getMin: " + toIntStream(list).summaryStatistics().getMin());
        this.addLine("summaryStatistics getMax: " + toIntStream(list).summaryStatistics().getMax());
        this.addLine("summaryStatistics getSum: " + toIntStream(list).summaryStatistics().getSum());
        this.addLine("summaryStatistics getAverage: " + toIntStream(list).summaryStatistics().getAverage());
    }

    private void addToBooleanLines(List<Integer> list) {
        this.addLine("-- toBooleanTest");
        this.addLine("allMatch > 5: " + toIntStream(list).allMatch(integer -> integer > 5));
        this.addLine("anyMatch > 5: " + toIntStream(list).anyMatch(integer -> integer > 5));
        this.addLine("noneMatch > 5: " + toIntStream(list).noneMatch(integer -> integer > 5));
    }

    private void addToCollectionLines(List<Integer> list) {
        Console.instance().writeln("- toCollectionTest");
        Console.instance().writeln("collect toList: " + toIntStream(list).boxed().collect(Collectors.toList()));
        Console.instance().writeln("collect toSet: " + toIntStream(list).boxed().collect(Collectors.toSet()));
        // más de collectors desde Stream<T>!!!
        String string = "array: [";
        for (Integer integer : toIntStream(list).toArray()) {
            string += integer + ", ";
        }
        this.addLine(string.substring(0, string.length() + (list.isEmpty() ? 0 : -2)) + "]");
    }

    private void addVoidLines(List<Integer> list) {
        this.addLine("-- voidTest");
        toIntStream(list).forEach(integer -> {
            Console.instance().writeln(integer);
        });
        toIntStream(list).forEachOrdered(integer -> {
            Console.instance().writeln(integer);
        });
    }

    private void addIntermediateLines(List<Integer> list) {
        this.addLine("- intermediateTest");
        addSubstreamLines(list);
        addConverterLines(list);
    }

    private void addSubstreamLines(List<Integer> list) {
        this.addLine("-- substreamTest");
        this.addLine("filter %2==0: ", toIntStream(list).filter(integer -> integer % 2 == 0));
        this.addLine("takeWhile < 5: ", toIntStream(list).takeWhile(integer -> integer < 5));
        this.addLine("limit 5: ", toIntStream(list).limit(5));
        this.addLine("dropWhile < 5: ", toIntStream(list).dropWhile(integer -> integer < 5));
        this.addLine("skip 5: ", toIntStream(list).skip(5));
        this.addLine("distinct: ", toIntStream(list).distinct());
        this.addLine("sorted: ", toIntStream(list).sorted());
        this.addLine("unordered: ", toIntStream(list).unordered());
    }

    private void addConverterLines(List<Integer> list) {
        this.addLine("-- converterTest");

        this.addLine("boxed: ", toIntStream(list));

        this.addLine("map + 1: ", toIntStream(list).map(integer -> integer + 1));
        Console.instance()
                .writeln("mapToDouble + 1, sum: " + toIntStream(list).mapToDouble(integer -> (double) integer).sum());
        Console.instance().writeln("asDoubleStream + 1, sum: " + toIntStream(list).asDoubleStream().sum());
        Console.instance()
                .writeln("mapToLong + 1, sum: " + toIntStream(list).mapToLong(integer -> (long) integer).sum());
        Console.instance().writeln("asLongStream + 1, sum: " + toIntStream(list).asLongStream().sum());
        Console.instance().writeln(
                "mapToObj Interval: "
                        + toIntStream(list).mapToObj(integer -> new Interval(-integer, integer)).toString());
        // Console.instance().writeln("map + 1: " + intStream.flatMap(integer -> integer
        // + 1));
        // Console.instance().writeln("map + 1: " + intStream.mapMulti(integer ->
        // integer + 1));
    }

    private void addToStringLines(List<Integer> list) {
        this.addLine("toString: " + toIntStream(list).toString());
        this.addLine("joining - : " + toIntStream(list)
                .boxed()
                .map(element -> element.toString())
                .collect(Collectors.joining(" - ")));
                this.addLine("joining - [ ] : ", toIntStream(list));
    }

    private <T> void addLine(String title, IntStream stream) {
        this.addLine(title + stream
                .boxed()
                .map(element -> element.toString())
                .collect(Collectors.joining(", ", "[", "]")));
    }
    
}
