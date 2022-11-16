import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Creation {
    public static void main(String[] args) throws IOException {
        Stream<Integer> sEmpty = Stream.empty();

        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> streamOfCollection = collection.stream();

        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> streamOfArray = Stream.of("a", "b", "c");
        Stream<String> streamOfArray1 = Stream.of(arr);
        Stream<String> streamOfArrayFull = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);

        Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();

        Stream<String> streamGenerated = Stream.generate(() -> "element");
        Stream<String> streamGenerated1 = streamGenerated.limit(10);

        Stream<Integer> powers = Stream.iterate(1, n -> n << 1).limit(20);

        IntStream intStream = IntStream.range(1, 3);
        LongStream longStream = LongStream.rangeClosed(1, 3);

        IntStream streamOfChars = "abc".chars();
        Stream<String> streamOfString = Pattern.compile(", ").splitAsStream("a, b, c");

        Path path = Paths.get("C:\\WarAndWorld.txt");
        Stream<String> streamOfStrings = Files.lines(path);
        Stream<String> streamWithCharset = Files.lines(path, StandardCharsets.UTF_8);

        Stream<String> stream = Stream.of("a", "b", "c").filter(element -> element.contains("b"));
        Optional<String> anyElement = stream.findAny();
        // Cannot reuse streams!
        Optional<String> firstElement = stream.findFirst();

        Stream<String> subStream = Stream.of("ab", "bc", "cd", "da", "abcd")
                .skip(1)
                .limit(3);

        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        long size = list.stream()
                .skip(1)
                .map(element -> element.substring(0, 3))
                .sorted()
                .count();
        Optional<String> listStream = list.stream()
                .filter(element -> {
                    System.out.println("filter() was called");
                    return element.contains("2");
                })
                .map(element -> {
                    System.out.println("map() was called");
                    return element.toUpperCase();
                }).findFirst();

    }
}
