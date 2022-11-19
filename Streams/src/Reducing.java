import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Reducing {
    private record Product(int price, String name) {}
//    private static class Product {
//        private final int price;
//        private final String name;
//        public Product(int price, String name) {
//            this.price = price;
//            this.name = name;
//        }
//
//        public int price() {
//            return price;
//        }
//
//        public String name() {
//            return name;
//        }
//    }

    public static void main(String[] args) {
        int reducedTwoParams = IntStream.range(1, 4).reduce(4, Integer::sum);
        OptionalInt reducedOneParam = IntStream.range(1, 4).reduce(Integer::sum);
        OptionalInt reduceTwoStreams = IntStream.concat(IntStream.range(1,4), IntStream.range(11, 14))
                .reduce(Integer::sum);

        List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
                new Product(14, "orange"), new Product(13, "lemon"),
                new Product(23, "bread"), new Product(13, "sugar"));

        List<String> collectorCollection =
                productList.stream()
                        .map(Product::name)
                        .collect(Collectors.toList());
        collectorCollection.add("xaxaxa");
        List<String> collectorCollection1 =
                productList.stream().map(Product::name).toList();
        String listToString = productList.stream()
                .map(Product::name)
                .collect(Collectors.joining(", ", "[", "]"));
        double averagePrice = productList.stream()
                .collect(Collectors.averagingInt(Product::price));
//        Function.identity(); x -> x;
        int summingPrice = productList.stream()
                .collect(Collectors.summingInt(Product::price));
        int summingPrice1 = productList.stream().mapToInt(Product::price).sum();
        IntSummaryStatistics statistics = productList.stream()
                .collect(Collectors.summarizingInt(Product::price));
        System.out.println(statistics.toString());
        System.out.println(statistics.getMax());

        Map<Integer, List<Product>> collectorMapOfLists = productList.stream()
                .collect(Collectors.groupingBy(Product::price));
        Map<Boolean, List<Product>> mapPartioned = productList.stream()
                .collect(Collectors.partitioningBy(element -> element.price() > 15));
        Set<Product> unmodifiableSet = productList.stream()
                .collect(Collectors.collectingAndThen(Collectors.toSet(),
                        Collections::unmodifiableSet));

        Collector<Product, ?, LinkedList<Product>> toLinkedList =
                Collector.of(LinkedList::new, LinkedList::add,
                        (first, second) -> {
                            first.addAll(second);
                            return first;
                        });

        LinkedList<Product> linkedListOfPProducts =
                productList.stream().collect(toLinkedList);
        Map<String, Integer> map = productList.stream()
                .collect(Collectors.toMap(Product::name, Product::price, Integer::max));
    }
}
