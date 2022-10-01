import java.util.Objects;

public class Person implements Comparable<Person> {
    private String firstName;
    private String name;

    public Person(String firstName, String name) {
        this.firstName = firstName;
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(name, person.name);
    }

    @Override
    public int compareTo(Person other) {
        int result = name.compareTo(other.name);
        return result != 0 ? result : firstName.compareTo(other.firstName);
    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(firstName, name);
//    }
}
