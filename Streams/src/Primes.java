import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Primes {
    /**
     * Эта рекурсивная функция не работает, поскольку src.findFirst(), пытаясь извлечь элемент из потока,
     * "закрывает" поток.
     * @param src
     * @return
     */
    public static Stream<Integer> erato(Stream<Integer> src) {
        return Stream.concat(src.limit(1), src.filter(n -> n % src.findFirst().get() != 0));
    }

    public static Stream<Integer> primes() {
        return erato(Stream.iterate(2, n -> n+1));
    }

    public static void main(String[] args) {
        System.out.println(primes().limit(10).collect(Collectors.toList()));
    }
}
