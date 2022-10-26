
public class Link {
    private int info;
    private Link next;

    public Link(int info) {
        this.info = info;
        this.next = null;
    }

    public Link(int info, Link next) {
        this.info = info;
        this.next = next;
    }

    public int getInfo() {
        return info;
    }

    public Link getNext() {
        return next;
    }
}
