import java.util.ArrayList;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(12);
        ll.add(8);
        ll.add(2);
        for (Integer i : ll) {
            System.out.println("Элемент: " + i);
        }
        System.out.println(ll.size());
        ll.remove(8);
        System.out.println(ll.size());
        System.out.println(ll); // [2, 8, 12] - StringBuilder (можно и рекурсивно, но сложнее)
        LinkedList<String> ll1 = new LinkedList<>();
        ll1.add("Hello");
        for (String s : ll1) {

        }
        for (Iterator<String> iterator = ll1.iterator(); iterator.hasNext(); ) {
            String s = iterator.next();

        }
    }
}
