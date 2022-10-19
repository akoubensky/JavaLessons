import java.util.LinkedList;
import java.util.List;


/**
 * "Задача Иосифа Флавия".
 * Имеется круг из N предметов, из которого последовательно убирют каждый третий прдмет. Например, если всего было 8
 * предметов (занумеруем их числами от 1 до 8, вслед за предметом номер 8 в круге снова следует предмет 1),
 * то последовательности номеров выбывающих предметов будет следующей: 3, 6, 1, 5, 2, 8.
 * Процесс продолжается до тех пор, пока не останутся только два предмета.
 * Для нашего примера это будут предметы с номерами 4 и 7.
 * Требуется написать функцию, которая по заданному числу предметов N выдает номера
 * (в виде массива или списка из двух элементов) предметов, оставшихся неубранными после того,
 * как пройдет N-2 вычеркивания, и останутся только два предмета.
 */
public class Josephus <E> {
    private int count;
    public LinkedList<E> nTwo(E... v) {

       LinkedList<E> circle = new LinkedList<>(List.of(v));

        nTwoRec(circle);
        return circle;
    }

    private void nTwoRec(LinkedList<E> list) {
        int a=list.size();
        int b = 0;
        for (int i = 0; i < a; i++) {
            if (list.size() == 2) return;
            count++;
            if (count == 3) {
                list.remove(i - b);
                count = 0;
                b++;
            }
        }
        nTwoRec(list);
    }

    public static void main(String[] args) {
        Josephus<Integer> intJ = new Josephus<>();
        System.out.println(intJ.nTwo(1, 2, 3, 4, 5, 6, 7, 8));
        Josephus<String> stJ = new Josephus<>();
        System.out.println(stJ.nTwo("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight"));
        Josephus<Student> studJ = new Josephus<>();
        System.out.println(studJ.nTwo(new Student(1,"One"), new Student(2,"Two"), new Student(3,"Three"), new Student(4,"Four"),
                new Student(5,"Five"), new Student(7,"Six"), new Student(7,"Seven"), new Student(8,"Eight")));
    }
}
