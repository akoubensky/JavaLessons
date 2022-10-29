import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Consumer;

public class BinTree<K extends Comparable<K>, V> implements Iterable<Pair<K, V>> {
    private static class Node<K, V> {
        private K key;
        private V info;
        private Node<K, V> left;
        private Node<K, V> right;

        public Node(K key, V info, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.info = info;
            this.left = left;
            this.right = right;
        }
    }

    public BinTree(Comparator<K> comparator) {
       this.comparator=comparator;
    }
    private Comparator<K> comparator;

    private Node<K, V> root;

    public void add(K key, V value) {
        root = add(key, value, root);
    }

    private Node<K, V> add(K key, V value, Node<K, V> node) {
        if (node == null) {
            return new Node<>(key, value, null, null);
        }
        if (!key.equals(node.key)) {
//            if (comparator.compare(ob, node.info)>0)
            if (key.compareTo(node.key) > 0) {
                node.right = add(key, value, node.right);
            } else {
                node.left = add(key, value, node.left);
            }
        }
        return node;
    }

    public boolean contains(K obj) {
        return contains(obj, root);
    }

    private boolean contains(K key, Node<K, V> node) {
        return
            node == null ? false :
            node.key.equals(key) ? true :
            node.key.compareTo(key) > 0 ? contains(key, node.left) :
            contains(key, node.right);
    }

    public int height() {
        return height(root);
    }

    private int height(Node<K, V> node) {
        if (node == null) return 0;
        int leftHeight = height(node.left);
        int righttHeight = height(node.right);
        return Math.max(leftHeight, righttHeight) + 1;
    }

    public void iterate(Consumer<Pair<K,V>> consumer) {
        iterate(consumer, root);
    }

    private void iterate(Consumer<Pair<K,V>> consumer, Node<K, V> node) {
        if (node == null) return;
        iterate(consumer, node.left);
        consumer.accept(new Pair<>(node.key, node.info));
        iterate(consumer, node.right);
    }

    public void viewTree() {
        viewTreeRec(root);
    }

    private void viewTreeRec(Node<K, V> node) {
        if (node == null) return;
//        выражение с ?
        System.out.println(new Pair<>(node.key, node.info));

        viewTreeRec(node.left);

        viewTreeRec(node.right);

    }

    @Override
    public Iterator<Pair<K,V>> iterator() {
        return iterator(root);
    }

    private Iterator<Pair<K,V>> iterator(Node<K, V> node) {
        if (node == null) return Iterators.empty();
        return Iterators.concat(
                Iterators.concat(iterator(node.left), Iterators.singleton(new Pair<>(node.key, node.info))),
                iterator(node.right));
    }

}
