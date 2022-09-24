
import java.util.ArrayList;
import java.util.List;

/**
 * Написать функцию, которая по заданному целому числу, большему нуля, выдает список (ArrayList<Integer>)
 * его десятичных цифр в том порядке, в котором они были в исходном числе.
 * Например, если исходное число – 239, то результатом работы может быть, например, List.of(2, 3, 9).
 * Рекурсия опять основана на том, что можно получить список цифр меньшего числа.
 */
public class Task2 {
    private static List<Integer> digits(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        if (n < 10) {
            list.add(n);
            return list;
        }
        list.addAll(digits(n/10));
        list.add(n%10);
        return list;
    }


    public static void main(String[] args) {
        System.out.println(digits(239));
        // Напечатает [2, 3, 9]
    }
}
