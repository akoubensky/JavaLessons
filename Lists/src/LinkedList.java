public class LinkedList {
    private static class Link {
        int info;
        Link next;

        Link(int info) {
            this.info = info;
            this.next = null;
        }

        Link(int info, Link next) {
            this.info = info;
            this.next = next;
        }

        int getInfo() {
            return info;
        }

        Link getNext() {
            return next;
        }
    }

    private Link first;

    public LinkedList() {
        first = null;
    }

    public void add(int n) {
        Link newLink = new Link(n, first);
        first = newLink;
    }

    public int size() {
        int count = 0;
//        Link current = first;
//        while (current != null) {
//            count++;
//            current = current.getNext();
//        }
        for(Link current = first; current != null; current = current.getNext()) {
            count++;
        }
        return count;
    }

    public int sizeRec() {
        return sizeRecRec(first);
    }

    private int sizeRecRec(Link link) {
        return link == null ? 0 : 1 + sizeRecRec(link.next);
    }

    public int sum() {
        int result = 0;
        for(Link current = first; current != null; current = current.getNext()) {
            result += current.getInfo();
        }
        return result;
    }

    public int sum1() {
        return sum2(first);
    }

    private int sum2(Link link) {
        if (link == null) return 0;
        return sum2(link.next) + link.info;
    }
}
