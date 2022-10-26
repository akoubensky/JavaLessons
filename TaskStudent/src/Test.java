import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Iterator;


public class Test {
    public static void main(String[] args) throws IOException {
        StudentsSet ss = new StudentsSet();
        ss.addStudent("Ivan", "Ivanov", "6");
        ss.addStudent("Petr", "Petrov", "6");
        ss.addStudent("Oleg", "Olegov", "6");
        ss.addStudent("Maks", "Maksimov", "6");
        ss.addStudent("Kiril", "Kirilov", "6");
        ss.addStudent("Sergey", "Sergey", "5");

////        System.out.println(ss.listStudents());
//        Student s=ss.findStudent("Ivan","Ivanov","6");
//        System.out.println("Искомый студент:"+s);
//
//        ss.addMark(s,"Java",5); // Вместо s можно вставить ss.findStudent("Ivan","Ivanov","6")
//        ss.addMark(s,"Math",5);
//        ss.addMark(s,"Physics",5);
//        ss.addMark(s,"English",5);
//
//        s=ss.findStudent("Petr","Petrov","6");
//        ss.addMark(s,"Java",5);
//        ss.addMark(s,"Math",4);
//        ss.addMark(s,"Physics",5);
//        ss.addMark(s,"English",4);
//
//        s=ss.findStudent("Oleg","Olegov","6");
//        ss.addMark(s,"Java",5);
//        ss.addMark(s,"Math",3);
//        ss.addMark(s,"Physics",5);
//        ss.addMark(s,"English",5);
//
//        s=ss.findStudent("Maks","Maksimov","6");
//        ss.addMark(s,"Java",5);
//        ss.addMark(s,"Math",4);
//        ss.addMark(s,"Physics",2);
//        ss.addMark(s,"English",4);
//
//        s=ss.findStudent("Kiril","Kirilov","6");
//        ss.addMark(s,"Java",0);
//        ss.addMark(s,"Math",0);
//        ss.addMark(s,"Physics",0);
//        ss.addMark(s,"English",0);
//
////        s.marksStudent();
////        ss.removeMark(s,"English");
////        s.marksStudent();
//
//        ss.printSet5();
//        ss.printSet4();
//        ss.printSet3();
//        // на 149 нужно Set <Student> set5=new HashSet<Student>(); указывать <Student> параметризацию? можно убрать, но не <>.
//        ss.printSet2();
//        ss.printSet0();
//        ss.printAllSets();
//        ss.printAllSetsRec();
////        listStudents должент был выдавать ссылку на множество Set? Или List?

        System.out.println("Итератор");
         Iterator<Student> it=ss.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("for-each");
        for (Student student : ss) {
            System.out.println(student);
        }
    }
}
