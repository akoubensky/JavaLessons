import java.io.PrintStream;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ArraysDemo {
//    �������� �������, ������� �������� ������ �� ������.
//    ������ �� ����� ����� ���� int. ������� ������������ �������� � �������,
//    ����� �������, ��� �� � ������ ��� ������, � �� ���� ��������.
//    � ����������� ��������� �������.

    private static PrintStream sout = new PrintStream(System.out, true, StandardCharsets.UTF_8);

//TODO        func1 �������� �� ������� ����������� ����������.
    private static int[] func1(int[] table) {
        int size = table.length;

        int n;
        for (int a = 0; a < size; a++) {
            if ((double) (table[a]) % 2 != 0) {
                for (int b = a + 1; b < size; b++) {
                    if ((double) (table[b]) % 2 == 0) {
                        n = table[b];
                        for (int c = b; c > a; c--) {
                            table[c] = table[c - 1];
                        }
                        table[a] = n;
                        break;
                    }
                }
            }
        }
        return table;
    }

//TODO    func2 ������� ����� ������ �� ���� ���������, � ��������� ���
    private static int[] func2(int[] table) {
        sout.print("�������� ������: " + Arrays.toString(table) + "\n");
        int size = table.length;
        int[] tablef2 = new int[size];

        int n = 0;
        for (int a = 0; a < size; a++) {
            if ((double) (table[a]) % 2 == 0) {
                tablef2[n] = table[a];
                n++;
            }
        }
        for (int a = 0; a < size; a++) {
            if ((double) (table[a]) % 2 != 0) {
                tablef2[n] = table[a];
                n++;
            }
        }
        return tablef2;
    }

    public static void main(String[] args) {
        sout.println(sout.charset());
//      �������� ������
        int[] table1 = {1, 2, 3, 6, 3, 4, 6, 5, 8, 2, 3, 5, 8, 12, 11};
        sout.println(Arrays.toString(table1));
//      ������� ����� ��������� �������, ��� �� ��� �� ���������
        int[] table2 = Arrays.copyOf(table1, table1.length);
        long time = System.currentTimeMillis();

//TODO        ������� func1
        func1(table2);
        sout.println("����� ���������� 1� �������: " + (System.currentTimeMillis() - time));

        int size = table1.length;
        sout.print("���������� ������ (func1):");
        for (int i = 0; i < size; i++) {
            sout.print(" " + table2[i]);
        }
        sout.println("\n");

//TODO        ������� func2
        time = System.currentTimeMillis();
        int[] tablefunc2=func2(table1);
        sout.print("���������� ������ (func2): " + Arrays.toString(tablefunc2) + "\n");
        sout.println("����� ���������� 2� �������: " + (System.currentTimeMillis() - time));
    }
//    ������: ����������� ������, �������(������) ������ ����, �������� ������ �� �����
//    ������: �������� ������� ������� �������� ��� �� ��� arrays equals (����) ������� ��������
//    2� ������� �� ����� � �������� ��������� � ���������� �� �� ���������.
//    ������: ������� getMax �������� ������������ �������� �� ������� (2� ��������� ������ �� �����
//    � �����(����������� ������������ ���������)), �������� � �� ������. ������ ������ �� ������.
}