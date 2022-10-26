
import java.util.ArrayList;
import java.util.List;

/**
 * �������� �������, ������� �� ��������� ������ �����, �������� ����, ������ ������ (ArrayList<Integer>)
 * ��� ���������� ���� � ��� �������, � ������� ��� ���� � �������� �����.
 * ��������, ���� �������� ����� � 239, �� ����������� ������ ����� ����, ��������, List.of(2, 3, 9).
 * �������� ����� �������� �� ���, ��� ����� �������� ������ ���� �������� �����.
 */
public class Task2 {
    private static List<Integer> digits(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        if (n < 10) {
            list.add(n);
            return list;
        }
        list.addAll(digits(n/10));
        list.add(n%10);
        return list;
    }


    public static void main(String[] args) {
        System.out.println(digits(239));
        // ���������� [2, 3, 9]
    }
}
