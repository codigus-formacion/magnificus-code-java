package util.view.dialog.collection.list;

import util.values.Interval;
import util.view.dialog.primitive.DoubleDialog;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class DoubleLinkedListDialog extends LinkedListDialog<List<Double>> {

    public DoubleLinkedListDialog(String title) {
        super(title, new DoubleDialog().regExp());
    }

    public List<Double> create(String string) {
        return this.strings(string).stream()
                .map(element -> new DoubleDialog().create(element))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public void addContent(List<Double> linkedList) {
        this.addTerminalLines(linkedList);
        this.addIntermediateLines(linkedList);
    }

    private void addTerminalLines(List<Double> list) {
        this.addLine("------------");
        this.addLine("elementos: ", this.toDoubleStream(list));
        this.addLine("- terminalTest");
        this.addToNumberLines(list);
        this.addToBooleanLines(list);
        this.addToCollectionLines(list);
        this.addVoidLines(list);
    }

    private DoubleStream toDoubleStream(List<Double> list) {
        return list.stream().mapToDouble(decimal -> decimal.doubleValue());
    }

    private void addToNumberLines(List<Double> list) {
        this.addLine("-- toNumberTest");
        this.addLine("findFirst: " + this.toDoubleStream(list).findFirst());
        this.addLine("findAny: " + this.toDoubleStream(list).findAny());
        this.addLine("count: " + this.toDoubleStream(list).count());

        this.addLine("min: " + this.toDoubleStream(list).min());
        this.addLine("max: " + this.toDoubleStream(list).max());
        this.addLine("sum: " + this.toDoubleStream(list).sum());
        this.addLine("average: " + this.toDoubleStream(list).average());
        this.addLine("summaryStatistics getCount: " + this.toDoubleStream(list).summaryStatistics().getCount());
        this.addLine("summaryStatistics getMin: " + this.toDoubleStream(list).summaryStatistics().getMin());
        this.addLine("summaryStatistics getMax: " + this.toDoubleStream(list).summaryStatistics().getMax());
        this.addLine("summaryStatistics getSum: " + this.toDoubleStream(list).summaryStatistics().getSum());
        this.addLine("summaryStatistics getAverage: " + this.toDoubleStream(list).summaryStatistics().getAverage());
    }

    private void addToBooleanLines(List<Double> list) {
        this.addLine("-- toBooleanTest");
        this.addLine("allMatch > 5: " + this.toDoubleStream(list).allMatch(decimal -> decimal > 5));
        this.addLine("anyMatch > 5: " + this.toDoubleStream(list).anyMatch(decimal -> decimal > 5));
        this.addLine("noneMatch > 5: " + this.toDoubleStream(list).noneMatch(decimal -> decimal > 5));
    }

    private void addToCollectionLines(List<Double> list) {
        this.addLine("- toCollectionTest");
        this.addLine("collect toList: " + this.toDoubleStream(list).boxed().collect(Collectors.toList()));
        this.addLine("collect toSet: " + this.toDoubleStream(list).boxed().collect(Collectors.toSet()));
        String string = "array: [";
        for (Double decimal : this.toDoubleStream(list).toArray()) {
            string += decimal + ", ";
        }
        this.addLine(string.substring(0, string.length() + (list.isEmpty() ? 0 : -2)) + "]");
    }

    private void addVoidLines(List<Double> list) {
        this.addLine("-- voidTest");
        this.toDoubleStream(list).forEach(decimal -> {
            this.addLine("" + decimal);
        });
        this.toDoubleStream(list).forEachOrdered(decimal -> {
            this.addLine("" + decimal);
        });
    }

    private void addIntermediateLines(List<Double> list) {
        this.addLine("- intermediateTest");
        this.addSubstreamLines(list);
        this.addConverterLines(list);
        this.addToStringLines(list);
    }

    private void addSubstreamLines(List<Double> list) {
        this.addLine("-- substreamTest");
        this.addLine("filter %2==0: ", this.toDoubleStream(list).filter(decimal -> decimal % 2 == 0));
        this.addLine("takeWhile < 5: ", this.toDoubleStream(list).takeWhile(decimal -> decimal < 5));
        this.addLine("limit 5: ", this.toDoubleStream(list).limit(5));
        this.addLine("dropWhile < 5: ", this.toDoubleStream(list).dropWhile(decimal -> decimal < 5));
        this.addLine("skip 5: ", this.toDoubleStream(list).skip(5));
        this.addLine("distinct: ", this.toDoubleStream(list).distinct());
        this.addLine("sorted: ", this.toDoubleStream(list).sorted());
        this.addLine("unordered: ", this.toDoubleStream(list).unordered());
    }

    private void addConverterLines(List<Double> list) {
        this.addLine("-- converterTest");

        this.addLine("boxed: ", this.toDoubleStream(list));

        this.addLine("map + 1: ", this.toDoubleStream(list).map(decimal -> decimal + 1));
        this.addLine("map + 1, sum: " + this.toDoubleStream(list).map(decimal -> decimal + 1).sum());
        this.addLine("asDoubleStream + 1, sum: " + this.toDoubleStream(list).sum());
        this.addLine("mapToLong + 1, sum: " + this.toDoubleStream(list).mapToLong(decimal -> (long) decimal).sum());
        this.addLine("mapToObj Interval: " + this.toDoubleStream(list).mapToObj(decimal -> new Interval(-decimal, decimal)).toString());
        // this.addLine("map + 1: " + intStream.flatMap(decimal -> decimal
        // + 1));
        // this.addLine("map + 1: " + intStream.mapMulti(decimal ->
        // decimal + 1));
    }

    private void addToStringLines(List<Double> list) {
        this.addLine("toString: " + this.toDoubleStream(list).toString());
        this.addLine("joining - : " + this.toDoubleStream(list)
                .boxed()
                .map(element -> element.toString())
                .collect(Collectors.joining(" - ")));
        this.addLine("joining - [ ] : ", this.toDoubleStream(list));
    }

    private <T> void addLine(String title, DoubleStream stream) {
        this.addLine(title + stream
                .boxed()
                .map(element -> element.toString())
                .collect(Collectors.joining(", ", "[", "]")));
    }

}
