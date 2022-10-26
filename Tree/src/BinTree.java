import java.util.Comparator;
import java.util.Iterator;

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
        return null;
    }


}
