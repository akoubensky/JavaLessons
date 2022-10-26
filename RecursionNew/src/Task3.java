import java.util.ArrayList;
import java.util.List;

/**
 * �������� �������, ������� �� ��������� ������ ����� ����� ������ ������ ��� �������� ���������
 * � ��� �������, � ������� ��� ����������� � �������� ������.
 * � ����������� ������ ������� �� ������ � ��� ����� ����� � ������� ������ subList ��� �������.
 * ��������, ���� �������� ������ ��� List<Integer> list = List.of(1, 2, 3, 4); �� �����
 * list.subList(2, 4) ������ ������ �� ���� ��������� 3 � 4, ��������� �������� �������� [2, 4)
 * ������ ������ ���� ���������
 */
public class Task3 {
    private static List<Integer> oddNumbers(List<Integer> src) {
        ArrayList<Integer> list = new ArrayList<>();
        if (src.size()==0) {
            return list;
        }
        list.addAll(oddNumbers(src.subList(0, src.size()-1)));
        if (src.get(src.size()-1)%2!=0) {
            list.add(src.get(src.size()-1));
        }

        return list;
    }
    private static List<Integer> oddNumbers1(List<Integer> src) {
        ArrayList<Integer> list = new ArrayList<>();
        if (src.size() == 0) {
            return list;
        }
        if (src.get(0)%2!=0) {
            list.add(src.get(0));
        }
        list.addAll(oddNumbers1(src.subList(1, src.size())));
        return list;
    }

    public static void main(String[] args) {
        System.out.println(oddNumbers1(List.of(4, 2, 1, 5, 6, 10, 3)));
        // ���������� [1, 5, 3]
    }
}
