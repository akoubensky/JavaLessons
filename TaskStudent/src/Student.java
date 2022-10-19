import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Student {
    private final String firstName;
    private final String name;
    private final String group;
    private Student nextStudent;

    private final Map<String, Integer> marks = new HashMap<>();

    public Student(String firstName, String name, String group) {
        this.firstName = firstName;
        this.name = name;
        this.group = group;
    }

    public Student getNextStudent() {
        return nextStudent;
    }

    public void setNextStudent(Student nextStudent) {
        this.nextStudent = nextStudent;
    }
    public void addMarkStudent (String subject, int mark) {
        marks.put(subject,mark);
    }
    public void removeMarkStudent(String subject) {
        marks.remove(subject);
    }
    public void marksStudent() {
        System.out.println("Отметки студента: "+marks);
    }
    public int estimation (String subject) {
        if (marks.containsKey(subject)) {
       return marks.get(subject);
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return firstName.equals(student.firstName) && name.equals(student.name) && group.equals(student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, name, group);
    }

    @Override
    public String toString() {
        return "\n"+"Student{" +
                "firstName='" + firstName + '\'' +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
