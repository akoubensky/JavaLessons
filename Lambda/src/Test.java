import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Test {
    private static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(4, 2, 6, 8, 10, 1, 12));
//        Collections.sort(list, new MyComparator());
        // Анонимный класс
//        Collections.sort(list, new Comparator<Integer>() {
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
        // Lambda-выражение
//        Collections.sort(list, (Integer o1, Integer o2) -> { return o2 - o1; });
        Collections.sort(list, (o1, o2) -> o2 - o1);
        System.out.println(list);

        Comparator<Integer> c = (o1, o2) -> o2 - o1;
        c.compare(2, 5);
        Function<String, Integer> f = s -> s.length();
        int n = f.apply("Hello");
    }
}
