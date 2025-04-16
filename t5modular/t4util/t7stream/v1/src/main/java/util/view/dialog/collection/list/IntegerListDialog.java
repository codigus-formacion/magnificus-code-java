package util.view.dialog.collection.list;

import util.view.dialog.primitive.IntDialog;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import util.values.Interval;

public class IntegerListDialog extends ListDialog<List<Integer>> {

    public IntegerListDialog(String title) {
        super(title, new IntDialog().regExp());
    }

    public List<Integer> create(String string) {
        return this.strings(string).stream()
                .map(elementString -> new IntDialog().create(elementString))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public void addContent(List<Integer> linkedList) {
        this.addTerminalLines(linkedList);
        this.addIntermediateLines(linkedList);
    }

    private void addTerminalLines(List<Integer> list) {
        this.addLine("------------");
        this.addLine("elementos: ", toIntStream(list));
        this.addLine("- terminalTest");
        this.addToNumberLines(list);
        this.addToBooleanLines(list);
        this.addToCollectionLines(list);
        this.addVoidLines(list);
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
        this.addLine("- toCollectionTest");
        this.addLine("collect toList: " + toIntStream(list).boxed().collect(Collectors.toList()));
        this.addLine("collect toSet: " + toIntStream(list).boxed().collect(Collectors.toSet()));
        String string = "array: [";
        for (Integer integer : toIntStream(list).toArray()) {
            string += integer + ", ";
        }
        this.addLine(string.substring(0, string.length() + (list.isEmpty() ? 0 : -2)) + "]");
    }

    private void addVoidLines(List<Integer> list) {
        this.addLine("-- voidTest");
        this.toIntStream(list).forEach(integer -> {
            this.addLine("" + integer);
        });
        this.toIntStream(list).forEachOrdered(integer -> {
            this.addLine("" + integer);
        });
    }

    private void addIntermediateLines(List<Integer> list) {
        this.addLine("- intermediateTest");
        this.addSubstreamLines(list);
        this.addConverterLines(list);
        this.addToStringLines(list);
    }

    private void addSubstreamLines(List<Integer> list) {
        this.addLine("-- substreamTest");
        this.addLine("filter %2==0: ", this.toIntStream(list).filter(integer -> integer % 2 == 0));
        this.addLine("takeWhile < 5: ", this.toIntStream(list).takeWhile(integer -> integer < 5));
        this.addLine("limit 5: ", this.toIntStream(list).limit(5));
        this.addLine("dropWhile < 5: ", this.toIntStream(list).dropWhile(integer -> integer < 5));
        this.addLine("skip 5: ", this.toIntStream(list).skip(5));
        this.addLine("distinct: ", this.toIntStream(list).distinct());
        this.addLine("sorted: ", this.toIntStream(list).sorted());
        this.addLine("unordered: ", this.toIntStream(list).unordered());
    }

    private void addConverterLines(List<Integer> list) {
        this.addLine("-- converterTest");

        this.addLine("boxed: ", this.toIntStream(list));

        this.addLine("map + 1: ", this.toIntStream(list).map(integer -> integer + 1));
        this.addLine("mapToDouble + 1, sum: " + this.toIntStream(list).mapToDouble(integer -> (double) integer).sum());
        this.addLine("asDoubleStream + 1, sum: " + this.toIntStream(list).asDoubleStream().sum());
        this.addLine("mapToLong + 1, sum: " + this.toIntStream(list).mapToLong(integer -> (long) integer).sum());
        this.addLine("asLongStream + 1, sum: " + this.toIntStream(list).asLongStream().sum());
        this.addLine("mapToObj Interval: " + this.toIntStream(list).mapToObj(integer -> new Interval<Integer>(-integer, integer)).toString());
        // this.addLine("map + 1: " + intStream.flatMap(integer -> integer
        // + 1));
        // this.addLine("map + 1: " + intStream.mapMulti(integer ->
        // integer + 1));
    }

    private void addToStringLines(List<Integer> list) {
        this.addLine("toString: " + this.toIntStream(list).toString());
        this.addLine("joining - : " + this.toIntStream(list)
                .boxed()
                .map(element -> element.toString())
                .collect(Collectors.joining(" - ")));
        this.addLine("joining - [ ] : ", this.toIntStream(list));
    }

    private <T> void addLine(String title, IntStream stream) {
        this.addLine(title + stream
                .boxed()
                .map(element -> element.toString())
                .collect(Collectors.joining(", ", "[", "]")));
    }

}
