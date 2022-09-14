import java.util.Arrays;

public class TaskArray {
//TODO    Задача: Перевернуть массив, функция(массив) статик воид, получает массив из целых
    private static void func1(int [] table) {
        int size = table.length;
        for (int i=0; i< size/2;i++) {
            int n=table[i];
            table[i]=table[size-1-i];
            table[size-1-i]=n;
        }
    }
//TODO    Задача: Написать функцию которая работает так же как arrays equals (свою) которая получает
//        2а массива из целых в качестве параметра и сравнивает их на равенство.

    private static boolean func2 (int [] table1,int [] table2) {
        if (table1.length!=table2.length) return false;
        int size = table1.length;
        for (int i=0;i<size;i++) {
            if (table1[i]!=table2[i]) return false;
        }
        return true;
    }

//TODO  Задача: Функция getMax выбирает максимальные элементы из массива (2а аргумента массив из целых
//      и число(колличество максимальных элементов)), помещает в др массив. Ретерн ссылку на массив.

    private static int[] getMax (int[] table, int x) {
        int [] tableX=new int[x];
        int size = table.length;
        int[] tablex = Arrays.copyOf(table, table.length);

        for (int a = 1; a < size; a++) {
            for (int b = size - 1; b >= a; b--) {
                if (tablex[b - 1] < tablex[b]) {
                    int t = tablex[b - 1];
                    tablex[b - 1] = tablex[b];
                    tablex[b] = t;
                }
            }
        }
        for (int i =0;i<x;i++) {
            tableX[i]=tablex[i];
        }
        return tableX;
    }
//TODO  Улучшенная версия getMax

    private static int[] getMax1 (int[] table, int x) {
        int[] tableX = new int[x];
        int size = table.length;
        int[] tablex = Arrays.copyOf(table, table.length);
        int c=0;

        for (int a=0;a<x;a++) {
            for (int b = a; b < size; b++) {
                if (tableX[a]<tablex[b]) {
                    tableX[a]=tablex[b];
                    c=b;
                }
            }
            tablex[c]=tablex[a];
            tablex[a]=tableX[a];
        }
        return tableX;
    }

    /**
     * Мой вариант функции - А.К.
     * @param table Исходный массив
     * @param x     Количество элементов, полагаем x < table.length
     * @return      Результат
     */
    private static int[] getMax2(int[] table, int x) {
        // Первые x элементов
        int[] result = Arrays.copyOf(table, x);
        // Сортируем их. Можно и пузырьком
//        Arrays.sort(result);
//        for (int i = x; i < table.length; i++) {
        Arrays.fill(result, Integer.MIN_VALUE);
        for (int i = 0; i < table.length; i++) {
            int element = table[i];
            if (element > result[0]) {
                // Вставляем новый элемент в упорядоченный массив
                int j = 1;
                while (j < x && result[j] < element) {
                    // Сдвигаем элементы
                    result[j-1] = result[j];
                    j++;
                }
                result[j-1] = element;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[] table1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11};
        System.out.println(Arrays.toString(table1));
//      Создаем копию исходного массива, что бы его не повредить
        int[] table2 = Arrays.copyOf(table1, table1.length);


//TODO        Вызывем func1
        func1(table2);
        System.out.print("Измененный массив (func1): " + Arrays.toString(table2) + "\n"+"\n");

//TODO        Вызывем func2
        int[] table3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] table4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11};
        System.out.print("Результаты (func2): "+func2(table1,table2)+" ");
        System.out.println(func2(table1,table3)+" "+func2(table1,table4)+"\n");

//TODO        Вызывем func getMax
        int [] tablegM={44,5,33,66,123,44,44,67,3,4,99,1,2,56,100};
        int[] getMax=getMax(tablegM,8);
        System.out.print("Измененный массив (getMax): " + Arrays.toString(getMax) + "\n"+"\n");

//TODO        Вызывем func getMax1
        int[] getMax1=getMax1(tablegM,9);
        System.out.print("Измененный массив (getMax1): " + Arrays.toString(getMax1) + "\n"+"\n");

        int[] getMax2=getMax2(tablegM,9);
        System.out.print("Измененный массив (getMax2): " + Arrays.toString(getMax1) + "\n"+"\n");

    }
}
