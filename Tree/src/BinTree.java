import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Consumer;

public class BinTree<E extends Comparable<E>> implements Iterable<E> {
    private static class Node<E> {
        private E info;
        private Node<E> left;
        private Node<E> right;

        public Node(E info, Node<E> left, Node<E> right) {
            this.info = info;
            this.left = left;
            this.right = right;
        }
    }

    public BinTree(Comparator<E> comparator) {
       this.comparator=comparator;
    }
    private Comparator<E> comparator;

    private Node<E> root;

    public void add(E ob) {
        root = add(ob, root);
    }

    private Node<E> add(E ob, Node<E> node) {
        if (node == null) {
            return new Node<>(ob, null, null);
        }
        if (!ob.equals(node.info)) {
//            if (comparator.compare(ob, node.info)>0)
            if (ob.compareTo(node.info) > 0) {
                node.right = add(ob, node.right);
            } else {
                node.left = add(ob, node.left);
            }
        }
        return node;
    }

    public boolean contains(E obj) {
        return contains(obj, root);
    }

    private boolean contains(E obj, Node<E> node) {
        return
            node == null ? false :
            node.info.equals(obj) ? true :
            node.info.compareTo(obj) > 0 ? contains(obj, node.left) :
            contains(obj, node.right);
    }

    public int height() {
        return height(root);
    }

    private int height(Node<E> node) {
        if (node == null) return 0;
        int leftHeight = height(node.left);
        int righttHeight = height(node.right);
        return Math.max(leftHeight, righttHeight) + 1;
    }

    public void iterate(Consumer<E> consumer) {
        iterate(consumer, root);
    }

    private void iterate(Consumer<E> consumer, Node<E> node) {
        if (node == null) return;
        iterate(consumer, node.left);
        consumer.accept(node.info);
        iterate(consumer, node.right);
    }

    public void viewTree() {
        viewTreeRec(root);
    }

    private void viewTreeRec(Node<E> node) {
        if (node == null) return;
//        выражение с ?
        System.out.println(node.info);

        viewTreeRec(node.left);

        viewTreeRec(node.right);

    }

    @Override
    public Iterator<E> iterator() {
        return iterator(root);
    }

    private Iterator<E> iterator(Node<E> node) {
        if (node == null) return Iterators.empty();
        return Iterators.concat(
                Iterators.concat(iterator(node.left), Iterators.singleton(node.info)),
                iterator(node.right));
    }

}
