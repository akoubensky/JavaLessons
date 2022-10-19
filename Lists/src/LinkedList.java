import ru.lesson.cards.Card;

import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {
    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E> {
        Link<E> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E result = current.getInfo();
            current = current.next;
            return result;
        }
    }

    private static class Link<T> {
        T info;
        Link<T> next;

        Link(T info) {
            this.info = info;
            this.next = null;
        }

        Link(T info, Link<T> next) {
            this.info = info;
            this.next = next;
        }

        T getInfo() {
            return info;
        }

        Link<T> getNext() {
            return next;
        }
    }

    private Link<E> first;
    private int count = 0;

    public LinkedList() {
        first = null;
    }

    public void add(E n) {
        Link<E> newLink = new Link<>(n, first);
        first = newLink;
        count++;
    }

    public void remove(E toRemove) {
        if (first != null && first.info.equals(toRemove)) {
            remove();
        } else {
            for (Link<E> current = first; current.next != null; current = current.next) {
                if (current.next.info == toRemove) {
                    current.next = current.next.next;
                    count--;
                    return;
                }
            }
        }
    }

    public void removeRec(E toRemove) {
        if (first != null) removeRec(toRemove, first);
    }

    private void removeRec(E toRemove, Link<E> current) {
        if (current.next == null) return;
        if (current.next.info.equals(toRemove)) {
            current.next = current.next.next;
            count--;
        } else {
            removeRec(toRemove, current.next);
        }
    }


    public E remove() {
        if (first == null) throw new IllegalStateException("Пустой список");
        E result = first.info;
        first = first.next;
        count--;
        return result;
    }

    public int size() {
//        int count = 0;
////        Link current = first;
////        while (current != null) {
////            count++;
////            current = current.getNext();
////        }
//        for(Link current = first; current != null; current = current.getNext()) {
//            count++;
//        }
        return count;
    }

    public int sizeRec() {
        return sizeRecRec(first);
    }

    private int sizeRecRec(Link<E> link) {
        return link == null ? 0 : 1 + sizeRecRec(link.next);
    }

//    public int sum() {
//        int result = 0;
//        for(Link current = first; current != null; current = current.getNext()) {
//            result += current.getInfo();
//        }
//        return result;
//    }

//    public int sum1() {
//        return sum2(first);
//    }
//
//    private int sum2(Link link) {
//        if (link == null) return 0;
//        return sum2(link.next) + link.info;
//    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        Link<E> current;
        for (current = first; current.next != null; current = current.next) {
            sb.append(current.info);
            sb.append(", ");
        }
        sb.append(current.info);
        sb.append("]");
        return sb.toString();
    }

    public String toStringRec() {
        StringBuilder sb=new StringBuilder();
//        sb.delete(0,sb.length()); Очистить Стрингбилдер
        sb.append("[ ");
        if (first != null) toStringRec(first, sb);
        sb.append("]");
        return  sb.toString();
    }
    private void toStringRec(Link <E> current, StringBuilder builder) {
        builder.append(current.info);
        builder.append(" ");
        if (current.next == null) {
            return;
        }
        toStringRec(current.next, builder);
    }
}
