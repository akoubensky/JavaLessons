import java.io.PrintStream;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ArraysDemo {
//    написать функцию, которая получает ссылку на массив.
//    Массив из целых числе типа int. Функция переставляет элементы в массиве,
//    таким образом, что бы в начале шли четные, а за ними нечетные.
//    С сохранением исходного порядка.

    private static PrintStream sout = new PrintStream(System.out, true, StandardCharsets.UTF_8);

//TODO        func1 работает по приципу пузырьковой сортировки.
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

//TODO    func2 создает новый массив на базе исходного, и заполняет его
    private static int[] func2(int[] table) {
        sout.print("Исходный массив: " + Arrays.toString(table) + "\n");
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
//      Исходный массив
        int[] table1 = {1, 2, 3, 6, 3, 4, 6, 5, 8, 2, 3, 5, 8, 12, 11};
        sout.println(Arrays.toString(table1));
//      Создаем копию исходного массива, что бы его не повредить
        int[] table2 = Arrays.copyOf(table1, table1.length);
        long time = System.currentTimeMillis();

//TODO        Вызывем func1
        func1(table2);
        sout.println("Время выполнения 1й функции: " + (System.currentTimeMillis() - time));

        int size = table1.length;
        sout.print("Измененный массив (func1):");
        for (int i = 0; i < size; i++) {
            sout.print(" " + table2[i]);
        }
        sout.println("\n");

//TODO        Вызывем func2
        time = System.currentTimeMillis();
        int[] tablefunc2=func2(table1);
        sout.print("Измененный массив (func2): " + Arrays.toString(tablefunc2) + "\n");
        sout.println("Время выполнения 2й функции: " + (System.currentTimeMillis() - time));
    }
}