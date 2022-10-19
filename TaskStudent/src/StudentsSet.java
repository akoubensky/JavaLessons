import java.io.*;
import java.util.*;

public class StudentsSet implements  Iterable<Student>, StudentSetIterator {
    private int count;
    private final Student[] studentsGroup = new Student[10];


    /* Добавляет в множество нового студента с пустым набором оценок */
    public Student addStudent(String firstName, String name, String group) {
        Student student = new Student(firstName, name, group);
        int a = Math.abs(student.hashCode()) % 10;

        for (Student current = studentsGroup[a]; current != null; current = current.getNextStudent()) {
            if (current.equals(student)) {
                return current;
            }
        }
        student.setNextStudent(studentsGroup[a]);
        studentsGroup[a] = student;
        count++;
        return student;
    }

    /* Находит в множестве студента по имени, фамилии и группе */
    public Student findStudent(String firstName, String name, String group) {
        Student student = new Student(firstName, name, group);
        int a = Math.abs(student.hashCode()) % 10;

        Student current = studentsGroup[a];
        do {
            if (current.equals(student)) {
                return current;
            }
            current = current.getNextStudent();
        } while (current != null);
        return null; // Нулевое значение?
    }

    /* Выдает список всех студентов в множестве */
    public List<Student> listStudents() {
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (studentsGroup[i] == null) continue;
            Student current = studentsGroup[i];
            do {
                list.add(current);
                current = current.getNextStudent();
            } while (current != null);
        }
        return list;
//        return List.of(studentsGroup); // нельзя изменять
    }

    /* Добавляет или заменяет оценку заданному студенты по заданному предмету */
    public void addMark(Student s, String subject, int mark) {
        s.addMarkStudent(subject, mark);
    }

    /* Удаляет у заданного студента оценку по заданному предмету */
    public void removeMark(Student s, String subject) {
        s.removeMarkStudent(subject);
    }

    /* Выводит на консоль всех студентов, у которых все оценки - пятерки */
    public void printSet5() {
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (studentsGroup[i] == null) continue;
            Student current = studentsGroup[i];
            do {
                if (current.estimation("Java") == 5 && current.estimation("Math") == 5 &&
                        current.estimation("Physics") == 5 && current.estimation("English") == 5) {
                    list.add(current);
                }
                current = current.getNextStudent();
            } while (current != null);
        }
        System.out.println("Студенты отличныки: " + list);
    } // for each перебор

    /* Выводит на консоль студентов, у которых есть четверки и нет оценок ниже */
    public void printSet4() {
        List<Student> list = new ArrayList<Student>();
        for (int i = 0; i < 10; i++) {
            if (studentsGroup[i] == null) continue;
            Student current = studentsGroup[i];
            do {
                if (current.estimation("Java") == 5 && current.estimation("Math") == 5 &&
                        current.estimation("Physics") == 5 && current.estimation("English") == 5) {
                    current = current.getNextStudent();
                    if (current == null) continue;
                }
                if (current.estimation("Java") >= 4 && current.estimation("Math") >= 4 &&
                        current.estimation("Physics") >= 4 && current.estimation("English") >= 4) {
                    list.add(current);
                }
                current = current.getNextStudent();
            } while (current != null);
        }
        System.out.println("Студенты ударники: " + list);
    }  // Создать итератор и работать с каждым студентом.

    /* Выводит на консоль студентов, у которых есть тройки и нет двоек */
    public void printSet3() {
        Set<Student> set5 = new HashSet<Student>();
        for (int i = 0; i < 10; i++) {
            if (studentsGroup[i] == null) continue;
            Student current = studentsGroup[i];
            do {
                if (current.estimation("Java") == 5 && current.estimation("Math") == 5 &&
                        current.estimation("Physics") == 5 && current.estimation("English") == 5) {
                    set5.add(current);
                }
                current = current.getNextStudent();
            } while (current != null);
        }

        Set<Student> set4 = new HashSet<Student>();
        for (int i = 0; i < 10; i++) {
            if (studentsGroup[i] == null) continue;
            Student current = studentsGroup[i];
            do {
                if (current.estimation("Java") >= 4 && current.estimation("Math") >= 4 &&
                        current.estimation("Physics") >= 4 && current.estimation("English") >= 4) {
                    set4.add(current);
                }
                current = current.getNextStudent();
            } while (current != null);
        }
        set4.removeAll(set5);

        Set<Student> set3 = new HashSet<Student>();
        for (int i = 0; i < 10; i++) {
            if (studentsGroup[i] == null) continue;
            Student current = studentsGroup[i];
            do {
                if (current.estimation("Java") >= 3 && current.estimation("Math") >= 3 &&
                        current.estimation("Physics") >= 3 && current.estimation("English") >= 3) {
                    set3.add(current);
                }
                current = current.getNextStudent();
            } while (current != null);
        }
        set3.removeAll(set5);
        set3.removeAll(set4);
        System.out.println("Студенты с тройками: " + set3);
    }

    /* Выводит на консоль студентов, у которых есть среди оценок двойки */
    public void printSet2() {
        Set<Student> set2 = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            if (studentsGroup[i] == null) continue;
            Student current = studentsGroup[i];
            do {
                if (current.estimation("Java") == 2 || current.estimation("Math") == 2 ||
                        current.estimation("Physics") == 2 || current.estimation("English") == 2) {
                    set2.add(current);
                }
                current = current.getNextStudent();
            } while (current != null);
        }
        System.out.println("Студенты с двойками: " + set2);
    }

    /* Выводит на консоль студентов, у которых нет ни одной оценки */
    public void printSet0() {
        Set<Student> set0 = new HashSet<Student>();
        for (int i = 0; i < 10; i++) {
            if (studentsGroup[i] == null) continue;
            Student current = studentsGroup[i];
            do {
                if (current.estimation("Java") == 0 && current.estimation("Math") == 0 &&
                        current.estimation("Physics") == 0 && current.estimation("English") == 0) {
                    set0.add(current);
                }
                current = current.getNextStudent();
            } while (current != null);
        }
        System.out.println("Прогульщики: " + set0);

    }

    /* Выводит на консоль студентов */
    public void printAllSets() throws IOException {
        Set<Student> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            if (studentsGroup[i] == null) continue;
            Student current = studentsGroup[i];
            do {
                set.add(current);
                current = current.getNextStudent();
            } while (current != null);
        }
        System.out.println("Все студенты: " + set);
        writerStudents(set);
    }
    public void printAllSetsRec() {
        Set<Student> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            printAllSetsRecList(studentsGroup[i],set);
        }
        System.out.println("Студенты выведеные рекурсивно "+set);
    }
    private void printAllSetsRecList (Student st,Set<Student> set) {
        if (st==null) {
            return;
        }
        set.add(st);
        printAllSetsRecList (st.getNextStudent(),set);
    }
//    Вычислять для каждого студента минимальную оценку.
    private void writerStudents (Set <Student> hS) throws IOException {

        try (FileWriter writer = new FileWriter("C:\\IdeaProjects\\JavaLessons\\TaskStudent\\src\\student.txt")){
            for (Student s:hS) {
                writer.write(s.toString());
            }
        }
    }

    /** Здесь реализация интерфейса Итерабл */
    private int index;
    private Student studentIndex;

    @Override
    public Iterator<Student> iterator() {
        return  new StudentSetIter();
//        {
//            @Override
//            public boolean hasNext() {
//                int i =index;
//                if (studentIndex!=null&&studentIndex.getNextStudent()!=null) {
//                    return true;
//                }
//                while (studentsGroup[i]==null&&i<studentsGroup.length-1) {
//                    i++;
//                }
//                if (studentsGroup[i]!=null) {
//                    return true;
//                }
//                return false;
//            }
//
//            @Override
//            public Student next() {
//                if (index==studentsGroup.length-1&&studentIndex==null) {return null;}
//                if (index==0&&studentIndex==null) {
//                    while (studentsGroup[index]==null&&index<studentsGroup.length-1) {
//                        index++;
//                    }
//                    studentIndex=studentsGroup[index];
//                    if (studentIndex.getNextStudent()==null&&index<studentsGroup.length-1) index++;
//                    return studentIndex;
//                }
//                if (studentIndex.getNextStudent()!=null){
//                    studentIndex=studentIndex.getNextStudent();
//                    if (studentIndex.getNextStudent()==null&&index<studentsGroup.length-1) index++;
//                    return studentIndex;
//                }
//                while (studentsGroup[index]==null&&index<studentsGroup.length-1) {
//                    index++;
//                }
//                studentIndex=studentsGroup[index];
//                if (index<studentsGroup.length-1&&studentIndex.getNextStudent()==null) index++;
//                return studentIndex;
//            }
//        };
    }


    /** Здесь реализация патерна Итератор */
    @Override
    public Iterator<Student> getStudentSetIterator() {
        return new StudentSetIter();
    }
    private class StudentSetIter implements Iterator<Student>{
        private int index;
        private Student studentIndex;

        @Override
        public boolean hasNext() {
            int i =index;
            if (studentIndex!=null&&studentIndex.getNextStudent()!=null) {
                return true;
            }
            while (studentsGroup[i]==null&&i<studentsGroup.length-1) {
                i++;
            }
            if (studentsGroup[i]!=null) {
                return true;
            }
            return false;
        }

        @Override
        public Student next() {
            if (index==studentsGroup.length-1&&studentIndex==null) {return null;}
            if (index==0&&studentIndex==null) {
                while (studentsGroup[index]==null&&index<studentsGroup.length-1) {
                    index++;
                }
                studentIndex=studentsGroup[index];
                if (studentIndex.getNextStudent()==null&&index<studentsGroup.length-1) index++;
                return studentIndex;
            }
            if (studentIndex.getNextStudent()!=null){
                studentIndex=studentIndex.getNextStudent();
                if (studentIndex.getNextStudent()==null&&index<studentsGroup.length-1) index++;
                return studentIndex;
            }
            while (studentsGroup[index]==null&&index<studentsGroup.length-1) {
                index++;
            }
            studentIndex=studentsGroup[index];
            if (index<studentsGroup.length-1&&studentIndex.getNextStudent()==null) index++;
            return studentIndex;
        }
    }
}

