public class Test {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.add(12);
        ll.add(8);
        ll.add(2);
        System.out.println(ll.size());
        System.out.println(ll); // [2, 8, 12] - StringBuilder (можно и рекурсивно, но сложнее)
    }
}
