/**
 * �������� ������� ��� "��������" ���������� ������ ����� � ����������� �������.
 * �������� �������� �� ���, ��� ��� ������ ������� a ^ (2n) = (a ^ 2) ^ n, � ��� �������� ������� a ^ (2n + 1) = a * a^2n     2^3=2^(2+1)=2^1*2^2=2*2^2
 * ����� �������� ^ ���������� �������� ���������� � ������� (����� �������� � Java ���!)
 */
public class Task4 {
    private static int pow(int base, int power) {
        if (power==0) {
            return 1;
        }
        if (power%2!=0) {
            return base*pow(base,power-1);
        } else {
            return pow(base*base,power/2);
        }
    }

    public static void main(String[] args) {
        System.out.println(pow(3, 10));
        // ������ ���������� 59049 : 3 � ������� �������
    }
}
