package org.example;

public class Mark {
    private final String subject;
    private final int mark;

    public Mark(String subject, int mark) {
        this.subject = subject;
        this.mark = mark;
    }

    public String getSubject() {
        return subject;
    }

    public int getMark() {
        return mark;
    }
}
