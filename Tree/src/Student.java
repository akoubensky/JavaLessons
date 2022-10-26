import java.util.Comparator;

public class Student implements Comparable<Student> {
    private final String firstName;
    private final String name;
    private final Integer group;

    public String getFirstName() {
        return firstName;
    }

    public String getName() {
        return name;
    }

    public Integer getGroup() {
        return group;
    }

    public Student(String firstName, String name, Integer group) {
        this.firstName = firstName;
        this.name = name;
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return Comparator.comparing(Student::getFirstName)
                .thenComparing(Student::getName)
                .thenComparing(Student::getGroup).compare(this, o);
//        if (firstName.compareTo(o.firstName)==0) {
//            if (name.compareTo(o.name)==0) {
//                return group.compareTo(o.group);
//            } return name.compareTo(o.name);
//        } return firstName.compareTo(o.firstName);
    }
}
