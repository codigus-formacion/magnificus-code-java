import utils.interval.Interval;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import utils.Console;

public class IntegerStreamsApp {

    public static void main(String[] args) {
        creationTest();
        List<List<Integer>> integerListList = List.of(
                List.of(),
                List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9),
                List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                List.of(0, 1, 2, 3),
                List.of(32, 65, 3, 77));
        integerListList.forEach(list -> {
            terminalTest(list);
            intermediateTest(list);
        });
    }

    private static void creationTest() {
        writeln("- creationTest");
        writeln("Stream Integer Arrays: ", Arrays.stream(new Integer[]{1, 2, 3}));
        writeln("Stream Integer List 1, 1, 1: ", List.of(1, 1, 1).stream());
        writeln("Stream Integer Set 1, 2, 3: ", Set.of(1, 2, 3).stream());
        writeln("Stream Integer 0, 1, 2, 3: ", Stream.of(0, 1, 2, 3));
        writeln("Stream Integer empty: ", Stream.empty());
        writeln("Stream Integer Random: ", Stream.generate(() -> new Random().nextInt(10)).limit(10));
   //        list.stream().peek(integer -> Console.instance().writeln(integer));
    }
    
    private static void writeln(String string) {
        Console.instance().writeln(string);
    }

    private static void terminalTest(List<Integer> list) {
        writeln("------------");
        writeln("elementos: ", list.stream());
        writeln("- terminalTest");
        toLongTest(list);
        toIntegerTest(list);
        toBooleanTest(list);
        toStringTest(list);
        toCollectionTest(list);
        voidTest(list);
    }
    
    private static void toLongTest(List<Integer> list) {
        writeln("-- toNumberTest");
        writeln("count: " + list.stream().count());
    }

    private static void toIntegerTest(List<Integer> list) {
        writeln("-- toIntegerTest");
        writeln("findFirst: " + list.stream().findFirst());
        writeln("findAny: " + list.stream().findAny());
        writeln("reduce +: " + list.stream().reduce((left, right) -> left + right));
        writeln("reduce +: " + list.stream().reduce(0, (left, right) -> left + right));
        writeln("reduce +: " + list.stream().reduce(0, (acc, num) -> acc + (num * 2), (left, right) -> left + right));
    }

    private static void toBooleanTest(List<Integer> list) {
        writeln("-- toBooleanTest");
        writeln("allMatch > 5: " + list.stream().allMatch(integer -> integer > 5));
        writeln("anyMatch > 5: " + list.stream().anyMatch(integer -> integer > 5));
        writeln("noneMatch > 5: " + list.stream().noneMatch(integer -> integer > 5));
    }

    private static void toStringTest(List<Integer> list) {
        writeln("toString: " + list.stream().toString());
        writeln("joining - : " + list.stream()
                .map(element -> element.toString())
                .collect(Collectors.joining(" - ")));
        writeln("joining - [ ] : ", list.stream());
    }

    private static <T> void writeln(String title, Stream<T> stream) {
        writeln(title + stream
                .map(element -> element.toString())
                .collect(Collectors.joining(", ", "[", "]")));
    }

    private static void toCollectionTest(List<Integer> list) {
        Console.instance().writeln("- toCollectionTest");
        Console.instance().writeln("collect toList: " + list.stream().collect(Collectors.toList()));
        Console.instance().writeln("collect toSet: " + list.stream().collect(Collectors.toSet()));
    }

    private static void voidTest(List<Integer> list) {
        writeln("-- voidTest");
        list.stream().forEach(integer -> {
            Console.instance().writeln(integer);
        });
        list.stream().forEachOrdered(integer -> {
            Console.instance().writeln(integer);
        });
    }

    private static void intermediateTest(List<Integer> list) {
        writeln("- intermediateTest");
        substreamTest(list);
        converterTest(list);
    }

    private static void substreamTest(List<Integer> list) {
        writeln("-- substreamTest");
        writeln("filter %2==0: ", list.stream().filter(integer -> integer % 2 == 0));
        writeln("takeWhile < 5: ", list.stream().takeWhile(integer -> integer < 5));
        writeln("limit 5: ", list.stream().limit(5));
        writeln("dropWhile < 5: ", list.stream().dropWhile(integer -> integer < 5));
        writeln("skip 5: ", list.stream().skip(5));
        writeln("distinct: ", list.stream().distinct());
        writeln("sorted: ", list.stream().sorted());
        writeln("unordered: ", list.stream().unordered());//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }

    private static void converterTest(List<Integer> list) {
        writeln("-- converterTest");
        writeln("map + 1: ", list.stream().map(integer -> integer + 1));
        writeln("map Interval: ", list.stream().map(integer -> new Interval(-integer, integer)));
        writeln("mapToDouble + 1, sum: " + list.stream().mapToDouble(integer -> integer.doubleValue()).sum());
        writeln("mapToLong + 1, sum: " + list.stream().mapToLong(integer -> integer.longValue()).sum());
    }

}
