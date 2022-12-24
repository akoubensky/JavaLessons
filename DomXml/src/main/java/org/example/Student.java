package org.example;


import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String name;
    private final String firstName;
    private final List<Mark> marks = new ArrayList<>();

    public Student(String name, String firstName) {
        this.name = name;
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public Student addMark(Mark mark) {
        marks.add(mark);
        return this;
    }

    public Student removeMark(Mark mark) {
        marks.remove(mark);
        return this;
    }
}
