import java.util.*;

public class Test {
    /**
     * Это тестирующий метод
     *
     * @param args Этот параметр не используется
     */
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        List<Integer> list = new LinkedList<>();
        list = new ArrayList<>();
        Set<Person> set = new HashSet<>();
        set.add(new Person("Ivan", "Ivanow"));
        set.add(new Person("Ivan", "Ivanow"));
        System.out.println(set.size());
        Set<Person> set1 = new TreeSet<>();
        set1.add(new Person("Ivan", "Ivanow"));
        set1.add(new Person("Ivan", "Ivanow"));
        System.out.println(set1.size());
        Queue<String> queue = new LinkedList<>();
        LinkedList<String> lList = new LinkedList<>(collection);
        //collection.addAll(set);
        ArrayList<String> aList = new ArrayList<>();
        aList.trimToSize();
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < 1000; i++) {
            s.append(i);
        }
    }

    public <E> void func(List<E> list) {

    }
}
