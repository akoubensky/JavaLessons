import java.util.Arrays;

public class ArraysDemo {
//    написать функцию, которая получает ссылку на массив.
//    Массив из целых числе типа int. Функция переставляет элементы в массиве,
//    таким образом, что бы в начале шли четные, а за ними нечетные.
//    С сохранением исходного порядка.

//TODO        func1 работает по приципу пузырьковой сортировки.
    private static int[] func1(int[] table) {
        int size = table.length;

        System.out.print("Исходный массив:");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + table[i]);
        }
        System.out.println();

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
        System.out.print("Исходный массив: " + Arrays.toString(table) + "\n");
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
//      Исходный массив
        int[] table1 = {1, 2, 3, 6, 3, 4, 6, 5, 8, 2, 3, 5, 8, 12, 11};
//      Создаем копию исходного массива, что бы его не повредить
        int[] table2 = Arrays.copyOf(table1, table1.length);
        long time = System.currentTimeMillis();

//TODO        Вызывем func1
        func1(table2);
        System.out.println("Время выполнения 1й функции: " + (System.currentTimeMillis() - time));

        int size = table1.length;
        System.out.print("Измененный массив (func1):");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + table2[i]);
        }
        System.out.println("\n");

//TODO        Вызывем func2
        time = System.currentTimeMillis();
        int[] tablefunc2=func2(table1);
        System.out.print("Измененный массив (func2): " + Arrays.toString(tablefunc2) + "\n");
        System.out.println("Время выполнения 2й функции: " + (System.currentTimeMillis() - time));
    }
}