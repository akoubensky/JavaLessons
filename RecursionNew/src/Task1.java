/**
 * �������� �������, ������� �� ��������� ������ �����, �������� ����, ��������� ����� ��� ���������� ����.
 * �������� �������� �� ���, ��� ������ ����� ������ � ��� �� �����, �� ��� ����� � ������� ������ ����.
 */
public class Task1 {
    private static int digits(int n) {
        int result;
        if (n < 10) return n;
        result= digits(n/10)+n%10;

        return result;
    }

    public static void main(String[] args) {
        System.out.println(digits(1239));
        // ���������� 14
    }
}
