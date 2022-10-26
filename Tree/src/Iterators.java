import java.util.Iterator;
import java.util.NoSuchElementException;

public class Iterators {
    public static <E> Iterator<E> empty() {
        return new Iterator<E> () {

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public E next() {
                throw new NoSuchElementException();
            }
        };
    }

    public static <E> Iterator<E> singleton(E obj) {
        return new Iterator<E>() {
            E o = obj;

            @Override
            public boolean hasNext() {
                return o != null;
            }

            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                E result = o;
                o = null;
                return result;
            }
        };
    }

    public static <E> Iterator<E> concat(Iterator<E> iter1, Iterator<E> iter2) {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return iter1.hasNext() || iter2.hasNext();
            }

            @Override
            public E next() {
                if (iter1.hasNext()) return iter1.next();
                if (iter2.hasNext()) return iter2.next();
                throw new NoSuchElementException();
            }
        };
    }

    public static <E> Iterator<E> concatMany(Iterator<E>... iters) {
        return null;
    }
}
