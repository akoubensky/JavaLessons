import java.util.LinkedList;
import java.util.List;


/**
 * "������ ������ ������".
 * ������� ���� �� N ���������, �� �������� ��������������� ������ ������ ������ ������. ��������, ���� ����� ���� 8
 * ��������� (���������� �� ������� �� 1 �� 8, ����� �� ��������� ����� 8 � ����� ����� ������� ������� 1),
 * �� ������������������ ������� ���������� ��������� ����� ���������: 3, 6, 1, 5, 2, 8.
 * ������� ������������ �� ��� ���, ���� �� ��������� ������ ��� ��������.
 * ��� ������ ������� ��� ����� �������� � �������� 4 � 7.
 * ��������� �������� �������, ������� �� ��������� ����� ��������� N ������ ������
 * (� ���� ������� ��� ������ �� ���� ���������) ���������, ���������� ����������� ����� ����,
 * ��� ������� N-2 ������������, � ��������� ������ ��� ��������.
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
